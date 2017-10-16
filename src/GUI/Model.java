/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GameObjects.Level;
import GameObjects.Player.Player;

/**
 *
 * @author Magd
 */
public class Model {
    
    Controller controller;
    Player player;
    Level level;

    /**
     * Creates a level instance, however, at this point there is no informaton,
     * since there is no file to load.
     */
    public Model() { 
        level = new Level();
    }

    /**
     * Creates a new Level and loads it. Also sets the player.
     * @param filename Filename of the file with the level date. Is is expected that the file is located in the Ressources folder.
     */
    public Model(String filename) {
        level = new Level();
        level.loadLevel(filename);
        player = level.getPlayer();
    }
    
    /**
     * Loads the by the filename specified level
     * @param filename Filename of the Level. The file is expected to be in the Ressources folder.
     */
    public void loadLevel(String filename) {
        level.loadLevel(filename);
        player = level.getPlayer();
    }
    
    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    public void setLevel(Level level) {
        this.level = level;
    }
    
    public Player getPlayer() {
        return player;
    }
    public Level getLevel() {
        return level;
    }
    
}
