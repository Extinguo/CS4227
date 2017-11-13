package collisiondetection;

import gameobjects.Helper;
import gameobjects.Level;
import interceptor.Dispatcher;
import interceptor.PlayerInfoContext;

import java.io.IOException;


public class BeanCollisionDetection extends CollisionDetection {

    public BeanCollisionDetection(Level level, I_CollisionAlgorithm collisionAlgorithm) {
        super(level, collisionAlgorithm);
    }

    @Override
    public boolean collisionHappening(Helper.Direction direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Handles beancollisions. If pacman collides with a bean the bean is eaten by pacman
     * @throws IOException A player eating a bean is logged using the interceptor pattern. This might cause an IOException.
     */
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

    /**
     * Logs that the player ate a bean using the interceptor pattern
     * @param playerName The playername 
     * @param beans The number of beans the player has eaten up until now
     * @throws IOException Might throw an IOException if logging fails
     */
    private void logPlayerEatBeans(String playerName, int beans) throws IOException {

         Dispatcher.getInstance().dispatchClientRequestInterceptorEatBeansLogging(new PlayerInfoContext(playerName, beans));

    }

    
}
