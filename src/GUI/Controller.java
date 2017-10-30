/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import MoveStrategy.PlayerMovementsListener;
import Player.Player;
import Visitor.IVisitor;
import Visitor.Theme1;

/**
 *
 * @author Magd
 */
public class Controller implements Runnable {

    private Model model;
    private View view;

    private final int TARGET_FPS = 60;
    private boolean isRunning = false;
    private Thread thread;
    private IVisitor themeVisitor = new Theme1();

    public Controller(Model model, View view, String path) {
        this.model = model;
        this.view = view;

        model.setLevel(new GameObjects.Level(this));
        view.accept(themeVisitor);
        
        // Loads the level. Since the players are loaded with the map there 
        // the player reference is null until after this.
        // We assume that a valid map will be loaded.
        model.getLevel().loadLevel(path);
        
        view.addPlayerMovementsListener(new PlayerMovementsListener(this));
    }

    public List<Player> getPlayers() {
        return model.getPlayers();
    }

    public GameObjects.Level getLevel() {
        return model.getLevel();
    }

    @Override
    public void run() {
        view.requestFocus();
        try {
            gameloopv2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void start() {
        if (isRunning) {
            return;
        }
        isRunning = true;
        thread = new Thread(this);
        thread.start();

    }

    public synchronized void stop() {
        if (!isRunning) {
            return;
        }
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addPlayer(Player player) {
        model.addPlayer(player);
    }

    
    // Unknown
    private void gameloopv1() throws IOException {
        int fps = 0;
        double timer = System.currentTimeMillis();
        long lastTime = System.nanoTime();
        double delta = 0;
        double ns = 1000000000 / TARGET_FPS;

        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                model.getLevel().tick();
                for(Player mplayer:model.getPlayers())
                    mplayer.tick();
//                model.getPlayer().tick();
                view.render();
                fps++;
                delta--;
            }
            if (System.currentTimeMillis() - timer >= 1000) {
                System.out.println(fps);
                fps = 0;
                timer += 1000;
            }
        }
    }
    
    // Kevin Glass - http://www.java-gaming.org/index.php?topic=24220.0
    private void gameloopv2() throws IOException {
        
        long lastLoopTime = System.nanoTime();
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
        long lastFpsTime = 0;
        int fps = 0;
        
        // keep looping round til the game ends
        while (isRunning) {
            // work out how long its been since the last update, this
            // will be used to calculate how far the entities should
            // move this loop
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double) OPTIMAL_TIME);

            // update the frame counter
            lastFpsTime += updateLength;
            fps++;

            // update our FPS counter if a second has passed since
            // we last recorded
            if (lastFpsTime >= 1000000000) {
                System.out.println("(FPS: " + fps + ")");
                lastFpsTime = 0;
                fps = 0;
            }

            // update the game logic
            model.getLevel().tick();
            for(Player mplayer:model.getPlayers())
                mplayer.tick();
//            model.getPlayer().tick();

            // draw everyting
            view.render();

            // we want each frame to take 10 milliseconds, to do this
            // we've recorded when we started the frame. We add 10 milliseconds
            // to this and then factor in the current time to give 
            // us our final value to wait for
            // remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
            try {
                long timeout = (lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000;
                if(timeout > 0) {
                    Thread.sleep(timeout);
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
;
        }
        
    }
    
    public IVisitor getThemeVisitor() {
		return themeVisitor;
	}

	public void setThemeVisitor(IVisitor themeVisitor) {
		this.themeVisitor = themeVisitor;
	}
}
