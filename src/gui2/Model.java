/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui2;

import gameobjects2.Level;
import player2.Player;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Magd
 */
public class Model implements Serializable {
    
    private Controller controller;
    private List<Player> players;
    private Level level;

    public Model() {
        players=new ArrayList<>();
    }
    
    public Model(Model model) {
        this.controller = model.controller;
        this.players = model.players;
        this.level = new Level(model.level);
    }
    
    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    public void addPlayer(Player player) {
        this.players.add(player);
    }
    
    public void setPlayers(List<Player> players) {
        this.players = players;
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
