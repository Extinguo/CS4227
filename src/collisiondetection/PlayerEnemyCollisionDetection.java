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
    public void enemyplayercollision()
    {
        if(getplayerFalseNum()==0)
            System.exit(0);
        int k=0;
        for(int i=0;i<level.getEnemys().size();i++)
        {
            if(collisionAlgorithm.collisionHappening(player,level.getEnemys().get(i)))
            {
                player.setLifes(player.getLifes()-1);
                System.out.println(player.getLifes());
                if(player.getLifes()==0) {
                    player.setAvaliable(false);
                }
            }
        }
        for(int i=0;i<level.getController().getPlayers().size();i++)
        {
            System.out.println(level.getController().getPlayers().get(i).getAvaliable());
        }
    }
    public int getplayerFalseNum()
    {
        int k=0;
        for(int i=0;i<level.getController().getPlayers().size();i++)
        {
            if(level.getController().getPlayers().get(i).getAvaliable()==true)
                k++;
        }
        return k;
    }
    
}
