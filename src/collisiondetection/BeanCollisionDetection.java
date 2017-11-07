/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collisiondetection;

import gameobjects.Helper;
import gameobjects.Level;
import interceptor.Dispatcher;
import interceptor.PlayerInfoContext;

import java.io.IOException;

/**
 *
 * @author Magd
 */
public class BeanCollisionDetection extends CollisionDetection {

    public BeanCollisionDetection(Level level, I_CollisionAlgorithm collisionAlgorithm) {
        super(level, collisionAlgorithm);
    }

    @Override
    public boolean collisionHappening(Helper.Direction direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void eatBean() throws IOException {
        for(int i=0;i<this.level.getBeans().size();i++)
        {
            if(collisionAlgorithm.collisionHappening(player, level.getBeans().get(i)))
            {
                level.getBeans().remove(i);
                player.setEatbeans(player.getEatbeans()+1);
                logPlayerEatBeans(player.getName(),player.getEatbeans());
                break;
            }
        }
    }

    public void logPlayerEatBeans(String playerName, int beans) throws IOException {

         Dispatcher.getInstance().dispatchClientRequestInterceptorEatBeansLogging(new PlayerInfoContext(playerName, beans));

    }

    
}
