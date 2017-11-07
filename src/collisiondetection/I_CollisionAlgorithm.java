/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collisiondetection;

import gameobjects.I_GameObject;
import java.io.Serializable;
import player.Player;

/**
 *
 * @author Magd
 */
public interface I_CollisionAlgorithm extends Serializable {
    
    public boolean collisionHappening(Player player, I_GameObject secondObject);
    
}
