package collisiondetection;

import gameobjects.I_GameObject;
import java.io.Serializable;
import player.Player;


public interface I_CollisionAlgorithm extends Serializable {
    
    /**
     * 
     * Tests if the player and the object are colliding
     * @param player The player for whom you want to check if he is colliding
     * @param secondObject The object to which he might be colliding
     * @return True if the player and the object collide, otherwise false
     */
    public boolean collisionHappening(Player player, I_GameObject secondObject);
    
}
