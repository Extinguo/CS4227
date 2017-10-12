/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GameObjects.Level;
import GameObjects.Player;

/**
 *
 * @author Magd
 */
public class Model {
    
    Controller controller;
    
    Player player;
    Level level;

    public Model() {
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
