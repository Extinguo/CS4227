package monster;

import gameobjects.Level;
import player.Player;

import java.awt.*;
import java.io.Serializable;
import java.util.Random;

public class EnemyIntelligentMovement implements Serializable {
    
    private Level level;
    private Enemy enemy;
    private int random=0,smart=1;
    private int state=random;
    private int right=0,left=1,up=2,down=3;
    private int dir=1;
    private Random randomGen;
    private int time=0;
    private int targetTime=60*30;
    private int speed=3;
    private Player player;
    int n=1;
    
    public EnemyIntelligentMovement(Level level,Enemy enemy)
    {
        this.level=level;
        this.enemy=enemy;
        randomGen=new Random();
        dir=randomGen.nextInt(4);
    }
    public boolean canMove(int nextX,int nextY)
    {
        Rectangle bounds=new Rectangle(nextX,nextY,enemy.getBounds().width,enemy.getBounds().height);
        for(int xx=0;xx<level.getWalls().length;xx++)
          for(int yy=0;yy<level.getWalls()[0].length;yy++)
          {
              if(level.getWalls()[xx][yy]!=null)
              {
                  if(bounds.intersects(level.getWalls()[xx][yy].getBounds()))
                  {
                      return false;
                  }
              }
          }
          return true;
    }
    public void tick()
    {
        if(state==random)
        {
            if(dir==right)
            {
                if(canMove(enemy.getBounds().x+speed,enemy.getBounds().y))
                {
                    enemy.getBounds().setLocation(enemy.getBounds().x+speed,enemy.getBounds().y);
                }
                else{
                    dir=randomGen.nextInt(4);
                }
            }
            else if(dir==left)
            {
                if(canMove(enemy.getBounds().x-speed,enemy.getBounds().y))
                {
                    enemy.getBounds().setLocation(enemy.getBounds().x-speed,enemy.getBounds().y);
                }
                else
                {
                    dir=randomGen.nextInt(4);
                }
            }
            else if(dir==up)
            {
                if(canMove(enemy.getBounds().x,enemy.getBounds().y-speed))
                {
                    enemy.getBounds().setLocation(enemy.getBounds().x,enemy.getBounds().y-speed);
                }
                else
                {
                    dir=randomGen.nextInt(4);
                }
            }
            else if(dir==down)
            {
                if(canMove(enemy.getBounds().x,enemy.getBounds().y+speed))
                {
                    enemy.getBounds().setLocation(enemy.getBounds().x,enemy.getBounds().y+speed);
                }
                else
                {
                    dir=randomGen.nextInt(4);
                }
            }
            time++;
            if(time==targetTime)
                state=smart;
        }
        else if(state==smart)
        {

            while(n==1) {
                int m = level.getController().getPlayers().size();
                player = level.getController().getPlayers().get(randomGen.nextInt(m));
                n++;
            }
            if(enemy.getBounds().x<player.getBounds().x)
            {
                if(canMove(enemy.getBounds().x+speed,enemy.getBounds().y))
                {
                    enemy.getBounds().setLocation(enemy.getBounds().x+speed,enemy.getBounds().y);
                }
            }
            if(enemy.getBounds().x>player.getBounds().x)
            {
                if(canMove(enemy.getBounds().x-speed,enemy.getBounds().y))
                {
                    enemy.getBounds().setLocation(enemy.getBounds().x-speed,enemy.getBounds().y);
                }
            }
            if(enemy.getBounds().y<player.getBounds().y)
            {
                if(canMove(enemy.getBounds().x,enemy.getBounds().y+speed))
                {
                    enemy.getBounds().setLocation(enemy.getBounds().x,enemy.getBounds().y+speed);
                }
            }
            if(enemy.getBounds().y>player.getBounds().y)
            {
                if(canMove(enemy.getBounds().x,enemy.getBounds().y-speed))
                {
                    enemy.getBounds().setLocation(enemy.getBounds().x,enemy.getBounds().y-speed);
                }
            }
            boolean move=false;

        }
    }
}
