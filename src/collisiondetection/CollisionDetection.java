/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collisiondetection;

import gameobjects.Helper.Direction;
import gameobjects.Level;
import player.Player;
import java.io.Serializable;

/**
 *
 * @author Magd
 * Try combining strategy and bridge
 * Make this to a proper bridge
 */
public abstract class CollisionDetection implements Serializable {
    
    protected Player player;
    protected Level level;
    
    protected I_CollisionAlgorithm collisionAlgorithm;

    /**
     * 
     * @param level Contains the level data.
     * @param collisionAlgorithm The CollisionAlgorithm which will be used
     */
    public CollisionDetection(Level level, I_CollisionAlgorithm collisionAlgorithm) {
        this.level = level;
        this.collisionAlgorithm = collisionAlgorithm; 
    }
    
    /**
     * Checks whether there will be a collision with the player if he moves.
     * 
     * @param direction The direction in that the player wants to move.
     * @return true, if the movement will cause a collision. Otherwise false
     */
    public abstract boolean collisionHappening(Direction direction);
    
    public void setLevel(Level level) {
        this.level = level;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    
}
