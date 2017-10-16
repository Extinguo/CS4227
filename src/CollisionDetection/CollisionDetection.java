/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollisionDetection;

import GameObjects.Helper.Direction;
import GameObjects.Level;
import GameObjects.Player.Player;

/**
 *
 * @author Magd
 */
public abstract class CollisionDetection {
    
    protected Player player;
    protected Level level;

    /**
     * 
     * @param level Contains the level data.
     */
    public CollisionDetection(Level level) {
        this.level = level;
    }
    
    /**
     * Checks whether there will be a collision with the player if he moves.
     * 
     * @param direction The direction in that the player wants to move.
     * @return true, if the movement will cause a collision. Otherwise false
     */
    abstract public boolean collisionHappening(Direction direction);
    
    public void setLevel(Level level) {
        this.level = level;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    
}
