/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollisionDetection;

import GameObjects.Helper;
import GameObjects.Level;

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
    public void Eatbean()
    {
        for(int i=0;i<this.level.getBeans().size();i++)
        {
            if(player.getBounds().intersects(level.getBeans().get(i).getBounds()))
            {
                level.getBeans().remove(i);
                player.setEatbeans(player.getEatbeans()+1);
                System.out.println("have eaten "+player.getEatbeans()+"beans");
                break;
            }
        }
    }

    
}
