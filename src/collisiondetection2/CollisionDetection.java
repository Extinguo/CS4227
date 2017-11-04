/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collisiondetection2;

import gameobjects2.Helper.Direction;
import gameobjects2.Level;
import player2.Player;
import java.io.Serializable;

/**
 *
 * @author Magd
 *
 *  Visitor
 *        Plugable Adapter
 *  Lambda Expression
 *  Concurrency
 *  Animation
 */
public abstract class CollisionDetection implements Serializable {
    
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
    public abstract boolean collisionHappening(Direction direction);
    
    public void setLevel(Level level) {
        this.level = level;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    
}
