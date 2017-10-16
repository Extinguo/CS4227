/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GameObjects.Player.Player;
import MoveStrategy.PlayerMovementsListener;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    
    /**
     * Registers the model and view at the Controller in the constructor.
     * Also adds the PlayerMovementsListener to the view and controls it.
     * 
     * @param model The model which contains/will contain the data for the view
     * @param view The view to control
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        
        view.addPlayerMovementsListener(new PlayerMovementsListener(this));
    }

    public Player getPlayer() {
        return model.getPlayer();
    }

    public GameObjects.Level getLevel() {
        return model.getLevel();
    }
    
    public void setPlayer(Player player) {
        model.setPlayer(player);
    }

    /**
     * Since the class implements Runnable this method has to be overriden. It calls 
     * the gameloop and requests focus for the view-Window. 
     */
    @Override
    public void run() {
        view.requestFocus();
        gameloop();
    }

    /**
     * Starts the Game in a new thread
     */
    public synchronized void start() {
        if (isRunning) {
            return;
        }
        isRunning = true;
        thread = new Thread(this);
        thread.start();

    }
    
    /**
     * Stops the Game and sets the thread to sleep
     */
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
    
    /**
     * The Gameloop that triggers the tick()-methods in the level and player classes.
     * It also triggers the view to render.
     * The target-FPS is a final int, default: 60. This means that the game renders
     * 60 times per secound. 
     * 
     * Notice: The Gameloop was copien from the following website, all rights go
     * to Kevin Glass
     * http://www.java-gaming.org/index.php?topic=24220.0
     */
    private void gameloop() {
        
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
            model.getPlayer().tick();

            // draw everyting
            view.render();

            // we want each frame to take 10 milliseconds, to do this
            // we've recorded when we started the frame. We add 10 milliseconds
            // to this and then factor in the current time to give 
            // us our final value to wait for
            // remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
            try {
                Thread.sleep((lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
;
        }
        
    }
}
