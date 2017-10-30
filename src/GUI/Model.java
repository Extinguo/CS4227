/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GameObjects.Level;
import Player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Magd
 */
public class Model {
    
    Controller controller;
    List<Player> players;
//    Player List<player>;
    //I just added a new player.
    Level level;

    public Model() {
        players=new ArrayList<>();
    }
    
    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    public void addPlayer(Player player) {
        this.players.add(player);
    }
    public void setLevel(Level level) {
        this.level = level;
    }

    public List<Player> getPlayers() {
        return players;
    }
    public Level getLevel() {
        return level;
    }

    
}
