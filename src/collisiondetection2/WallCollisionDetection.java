/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collisiondetection2;

import gameobjects2.Helper;
import gameobjects2.Level;
import java.awt.Rectangle;

/**
 *
 * @author Magd
 */
public class WallCollisionDetection extends CollisionDetection {

    
    public WallCollisionDetection(Level level) {
        super(level);
    }
    
    /**
     * Checks whether there will be a collision with the player if he moves.
     * 
     * @param direction The direction in that the player wants to move.
     * @return true, if the movement will cause a collision. Otherwise false
     */
    @Override
    public boolean collisionHappening(Helper.Direction direction) {
        int deltaX = 0;
        int deltaY = 0;
        int speed = 4;
        
        if (direction == Helper.Direction.UP)    { deltaY = -speed; }
        if (direction == Helper.Direction.DOWN)  { deltaY = +speed; }
        if (direction == Helper.Direction.RIGHT) { deltaX = +speed; }
        if (direction == Helper.Direction.LEFT)  { deltaX = -speed; }
                
        Rectangle newPlayerPosition = new Rectangle(player.getX()+deltaX, player.getY()+deltaY, 
                player.getBounds().width, player.getBounds().height);
        
        for(int x=0; x<level.getWalls().length; x++) {
            for(int y=0; y<level.getWalls()[x].length; y++) {
                if(level.getWalls()[x][y] != null) {
                    if(newPlayerPosition.intersects(level.getWalls()[x][y].getBounds())) {
                        return true;
                    }   
                }
            }
        }
        
        return false;
    }
    
    
    
}
