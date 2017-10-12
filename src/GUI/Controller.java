/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
    
//    private GameObjects.Player player;
//    private GameObjects.Level level;
    
    private boolean isRunning = false;
    private Thread thread;

    public Controller(Model model, View view, String path) {
        this.model = model;
        this.view  = view;
        view.addPlayerMovementsListener(new PlayerMovementsListener(this));
        
        model.setLevel(new GameObjects.Level(this));
        
        // Loads the level. Since the players are loaded with the map there 
        // the player reference is null until after this.
        // We assume that a valid map will be loaded.
        model.getLevel().loadLevel(path);
    }
    
    public GameObjects.Player getPlayer() {
        return model.getPlayer();
    }
    
    public GameObjects.Level getLevel() {
        return model.getLevel();
    }

    @Override
    public void run() {
        view.requestFocus();
        int fps = 0;
        double timer = System.currentTimeMillis();
        long lastTime = System.nanoTime();
        double targetTick = 60;
        double delta = 0;
        double ns = 1000000000 / targetTick;

        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                model.getLevel().tick();
                model.getPlayer().tick();
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
    
    public void setPlayer(GameObjects.Player player) {
        model.setPlayer(player);
    }
}
