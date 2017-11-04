/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollisionDetection;

import GameObjects.Helper;
import GameObjects.Level;
import Interceptor.Dispatcher;
import Interceptor.PlayerInfoContext;

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
    public void Eatbean() throws IOException {
        for(int i=0;i<this.level.getBeans().size();i++)
        {
            if(player.getBounds().intersects(level.getBeans().get(i).getBounds()))
            {
                level.getBeans().remove(i);
                player.setEatbeans(player.getEatbeans()+1);
                String s="The player "+player.getName()+": has eaten "+player.getEatbeans()+"beans";
//                System.out.println(s);
                logPlayerEatBeans(player.getName(),player.getEatbeans());
                break;
            }
        }
    }

    public void logPlayerEatBeans(String playerName, int beans) throws IOException {

         Dispatcher.getInstance().dispatchClientRequestInterceptorEatBeansLogging(new PlayerInfoContext(playerName, beans));

    }

    
}
