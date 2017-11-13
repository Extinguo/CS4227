package gui;

import gameobjects.Level;
import player.Player;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


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
