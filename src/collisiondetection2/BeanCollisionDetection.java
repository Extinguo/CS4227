/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collisiondetection2;

import gameobjects2.Helper;
import gameobjects2.Level;
import interceptor2.Dispatcher;
import interceptor2.PlayerInfoContext;

import java.io.IOException;

/**
 *
 * @author Magd
 */
public class BeanCollisionDetection extends CollisionDetection {

    public BeanCollisionDetection(Level level) {
        super(level);
    }

    @Override
    public boolean collisionHappening(Helper.Direction direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void eatBean() throws IOException {
        for(int i=0;i<this.level.getBeans().size();i++)
        {
            if(player.getBounds().intersects(level.getBeans().get(i).getBounds()))
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
