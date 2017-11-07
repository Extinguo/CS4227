/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collisiondetection;

import gameobjects.Helper;
import gameobjects.Level;

/**
 *
 * @author Magd
 */
public class PlayerEnemyCollisionDetection extends CollisionDetection {

    public PlayerEnemyCollisionDetection(Level level, I_CollisionAlgorithm collisionAlgorithm) {
        super(level, collisionAlgorithm);
    }
    

    @Override
    public boolean collisionHappening(Helper.Direction direction) {
        for(int i=0; i<level.getEnemys().size(); i++) {
            if(collisionAlgorithm.collisionHappening(player, level.getEnemys().get(i))) {
                return true;
            }
        }
        return false;
    }
    
}
