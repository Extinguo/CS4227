/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollisionDetection;

import GameObjects.Helper;
import GameObjects.Level;
import java.awt.Rectangle;

/**
 *
 * @author Magd
 */
public class MyCollisionDetection extends CollisionDetection {

    public MyCollisionDetection(Level level) {
        super(level);
    }
    
    enum Direction { up, down, right, left}


    

    
    @Override
    public boolean collisionHappening(Helper.Direction direction) {
        int deltaX = 0;
        int deltaY = 0;
        int speed = 4;
        
        if (direction == Helper.Direction.up) {
            deltaY = -speed;
        }
        if (direction == Helper.Direction.down) {
            deltaY = +speed;
        }
        if (direction == Helper.Direction.right) {
            deltaX = +speed;
        }
        if (direction == Helper.Direction.left) {
            deltaX = -speed;
        }
                
        
//        switch(direction) {
//            case up:
//                deltaY = -speed;
//                break;
//            case down:
//                deltaY = +speed;
//                break;
//            case right:
//                deltaX = +speed;
//                break;
//            case left:
//                deltaX = -speed;
//                break;
//            default:
//                break;
//        }
        Rectangle newPlayerPosition = new Rectangle(player.getX()+deltaX, player.getY()+deltaY, 
                player.getBounds().width, player.getBounds().height);
        
        for(int x=0; x<level.getWalls().length; x++) {
            for(int y=0; y<level.getWalls()[0].length; y++) {
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
