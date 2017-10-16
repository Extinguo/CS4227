/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollisionDetection;

import GameObjects.Helper;
import GameObjects.Level;

/**
 *
 * @author Magd
 */
public class OtherCollisionDetection extends CollisionDetection {

    public OtherCollisionDetection(Level level) {
        super(level);
    }

    
    

    @Override
    public boolean collisionHappening(Helper.Direction direction) {
        
        
        
        return false;
    }
    
}
