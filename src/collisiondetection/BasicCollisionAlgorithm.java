package collisiondetection;

import gameobjects.I_GameObject;
import player.Player;

/**
 * 
 * This implements the CollisionAlgorithm Interface and realizes the strategy pattern.
 */
public class BasicCollisionAlgorithm implements I_CollisionAlgorithm {  

    /**
     * 
     * Tests if the player and the object are colliding by checking if the intersection is empty
     * @param player The player for whom you want to check if he is colliding
     * @param secondObject The object to which he might be colliding
     * @return True if the player and the object intersect, otherwise false
     */
    @Override
    public boolean collisionHappening(Player player, I_GameObject secondObject) {
        return player.getBounds().intersects(secondObject.getBounds());
    }
    
}
