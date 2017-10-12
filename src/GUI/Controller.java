/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GameObjects.Helper;
import GameObjects.Helper.Direction;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Magd
 */
public class Controller implements Runnable {
    
    private Model model;
    private View view;
    
    private GameObjects.Player player;
    private GameObjects.Level level;
    
    private boolean isRunning = false;
    private Thread thread;

    public Controller(Model model, View view) {
        this.model = model;
        this.view  = view;
        view.addPlayerMovementsListener(new PlayerMovementsListener());
        
        player = new GameObjects.Player(view.getWidth()/2, view.getHeight()/2);
        
        level = new GameObjects.Level(this);
        level.loadLevel("map.png");
    }
    
    public GameObjects.Player getPlayer() {
        return player;
    }
    
    public GameObjects.Level getLevel() {
        return level;
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
                level.tick();
                player.tick();
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
    
    
    class PlayerMovementsListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) { }

        @Override
        public void keyPressed(KeyEvent e) {
            boolean up    = false;
            boolean down  = false;
            boolean right = false;
            boolean left  = false;
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    player.setDirectionStatus(Direction.up, true);
                    break;
                case KeyEvent.VK_DOWN:
                    player.setDirectionStatus(Direction.down, true);
                    break;
                case KeyEvent.VK_RIGHT:
                    player.setDirectionStatus(Direction.right, true);
                    break;
                case KeyEvent.VK_LEFT:
                    player.setDirectionStatus(Direction.left, true);
                    break;
                default:
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) { 
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    player.setDirectionStatus(Direction.up, false);
                    break;
                case KeyEvent.VK_DOWN:
                    player.setDirectionStatus(Direction.down, false);
                    break;
                case KeyEvent.VK_RIGHT:
                    player.setDirectionStatus(Direction.right, false);
                    break;
                case KeyEvent.VK_LEFT:
                    player.setDirectionStatus(Direction.left, false);
                    break;
                default:
                    break;
            }
        }
        
    }
}
