/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collisiondetection;

import gameobjects.I_GameObject;
import player.Player;

/**
 *
 * @author Magd
 */
public class BasicCollisionAlgorithm implements I_CollisionAlgorithm {  

    @Override
    public boolean collisionHappening(Player player, I_GameObject secondObject) {
        return player.getBounds().intersects(secondObject.getBounds());
    }
    
}
