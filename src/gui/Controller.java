/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import memento.Caretaker;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import movestrategy.PlayerMovementsListener;
import player.Player;
import visitor.IVisitor;
import visitor.Theme1;
import java.io.Serializable;
import player.PlayerDecorator;
import player.attributes.Speed;
import visitor.Theme2;

/**
 *
 * @author Magd
 */
public class Controller implements Runnable, Serializable {

    private Model model;
    private transient View view;

    private static final int targetFps = 60;
    private transient boolean isRunning = false;
    private transient Thread thread;
    private transient IVisitor themeVisitor = new Theme1();
    
    private transient Caretaker caretaker;

    public Controller(Model model, View view, String path) {
        this.model = model;
        this.view = view;
        
        this.caretaker = new Caretaker();

        model.setLevel(new gameobjects.Level(this));
        view.accept(themeVisitor);
        
        // Loads the level. Since the players are loaded with the map there 
        // the player reference is null until after this.
        // We assume that a valid map will be loaded.
        model.getLevel().loadLevel(path);
        
        view.addPlayerMovementsListener(new PlayerMovementsListener(this));
    }
    
    /**
     * Only use this constructor in case the game crashed. It loads the previous state
     * from the given Memento
     * @param filename The path/filename of the Memento
     * @param view The view on which the game will be shown
     */
    public Controller(String filename, View view) {
        this.view = view;
        this.caretaker = new Caretaker();
        restoreMemento(filename);
    }

    public List<Player> getPlayers() {
        return model.getPlayers();
    }

    public gameobjects.Level getLevel() {
        return model.getLevel();
    }

    @Override
    public void run() {
        view.requestFocus();
        try {
            gameloop();
        } catch (IOException e) {
            Logger.getLogger(Controller.class.getName()).
                    log(Level.INFO, null, e);
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

    /**
     * Stops the game.
     */
    public synchronized void stop() {
        if (!isRunning) {
            return;
        }
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.WARNING, "Interrupted!", ex);
            isRunning = true;
            Thread.currentThread().interrupt();
        }
    }
    
    /**
     * Add another player to the game.
     * @param player The player that will be added
     */
    public void addPlayer(Player player) {
        model.addPlayer(player);
    }
    
    /**
     * This gameloop is used to reach approx. 60FPS. This also defines how often the 
     * user input is validated. By letting the thread sleep if the game is going above
     * 60FPS no processor time is wasted. The game is definitely smooth at 60FPS.
     * Noteice: Source: Kevin Glass - http://www.java-gaming.org/index.php?topic=24220.0
     * @throws IOException 
     */
    private void gameloop() throws IOException {
        
        long lastLoopTime = System.nanoTime();
        final long OPTIMAL_TIME = 1000000000 / targetFps;
        long lastFpsTime = 0;
        int secOfMin = 0;
        
        // keep looping round til the game ends
        while (isRunning) {
            // work out how long its been since the last update, this
            // will be used to calculate how far the entities should
            // move this loop
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;

            // update the frame counter
            lastFpsTime += updateLength;

            // update our FPS counter if a second has passed since
            // we last recorded
            if (lastFpsTime >= 1000000000) {
                lastFpsTime = 0;
                secOfMin++;
                
                if(secOfMin==5) {
                    System.out.println("Creating a Memento");
                    createMemento("Test1_Memento");
                }
                
                if(secOfMin==10) {
                    System.out.println("Restoring a Memento");
                    restoreMemento("Test1_Memento");
                } 
            }

            // update the game logic
            model.getLevel().tick();
            for(Player mplayer:model.getPlayers()) {
                mplayer.tick();
                boolean enemyPlayerCollision = checkForAnamyAndPlayerCollision(mplayer);
                if(enemyPlayerCollision) {
                   handleDeath(mplayer);
                   checkAndHandleGameOver();
                }
            }
                

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
                Logger.getLogger(Controller.class.getName()).log(Level.WARNING, "Interrupted!", ex);
                Thread.currentThread().interrupt();
            }
        }
    }
    
    /**
     * Checks if a player is colliding with an enemy.
     * @param p The player for who you want to check if he is colliding with an enemy
     * @return True, if there is a collision. Otherwise false
     */
    private boolean checkForAnamyAndPlayerCollision(Player p) {
        List<PlayerDecorator> decorators = p.getDecorators();
        for (PlayerDecorator pd : decorators) {
            if (pd instanceof Speed) {
                if (((Speed) (p)).getPlayerEnemyCollision().collisionHappening(null)) {
                    return true;
                }
            }
        }

        return false;
    }
    
    /**
     * Handles the death of a player
     * @param p The player that died
     */
    private void handleDeath(Player p) {
    }
    
    /**
     * If every player is dead, the game is over.
     * This Method handles that scenario
     */
    private void checkAndHandleGameOver() {
        
    }
    
    public IVisitor getThemeVisitor() {
        return themeVisitor;
    }

    public void setThemeVisitor(IVisitor themeVisitor) {
        this.themeVisitor = themeVisitor;
    }
    
    
    
    // The following functions are for the Memento-Pattern

    /**
     * Creates a memento containing a snapshot of its current internal state
     * @return The Memento. This is a snapshot of the currently used data.
     */
    private void createMemento(String filename) {
        caretaker.storeMemento(model, filename);
    }
    
    /**
     * Restores the previous state by using a snapshot/memento that was taken before.
     * @param filename The path/filename to/of the saved memento that shall be restored
     */
    private void restoreMemento(String filename) {
        Model oldMemento = caretaker.getMomento(filename);
        this.model = oldMemento;
        view.setController(this);
        view.addPlayerMovementsListener(new PlayerMovementsListener(this));
        view.accept(themeVisitor);
    }
    
}