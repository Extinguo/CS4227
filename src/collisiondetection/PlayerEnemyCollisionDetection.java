package collisiondetection;

import gameobjects.Helper;
import gameobjects.Level;

public class PlayerEnemyCollisionDetection extends CollisionDetection {

    /**
     * Creates a new instance
     * @param level The leveldate
     * @param collisionAlgorithm The CollisionAlgorithm that shall be used to check for collisions 
     */
    public PlayerEnemyCollisionDetection(Level level, I_CollisionAlgorithm collisionAlgorithm) {
        super(level, collisionAlgorithm);
    }
    

    /**
     * Checks if a collision is happening
     * @param direction The direction the player is going
     * @return True if a collision happened/is happening, otherwise false
     */
    @Override
    public boolean collisionHappening(Helper.Direction direction) {
        for(int i=0; i<level.getEnemys().size(); i++) {
            if(collisionAlgorithm.collisionHappening(player, level.getEnemys().get(i))) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Handles a collision with an enemy
     */
    public void enemyplayercollision()
    {
        if(getplayerFalseNum()==0)
            System.exit(0);
        
        for(int i=0;i<level.getEnemys().size();i++)
        {
            if(collisionAlgorithm.collisionHappening(player,level.getEnemys().get(i)))
            {
                player.setLifes(player.getLifes()-1);
                if(player.getLifes()==0) {
                    player.setAvaliable(false);
                }
            }
        }
    }
    
    /**
     * 
     * @return 
     */
    public int getplayerFalseNum()
    {
        int k=0;
        for(int i=0;i<level.getController().getPlayers().size();i++)
        {
            if(level.getController().getPlayers().get(i).getAvaliable())
                k++;
        }
        return k;
    }
    
}
