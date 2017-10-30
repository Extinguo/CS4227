/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player.Attributes;

import CollisionDetection.BeanCollisionDetection;
import CollisionDetection.WallCollisionDetection;
import GameObjects.Helper;
import GameObjects.Helper.Direction;
import Player.Player;
import Player.PlayerDecorator;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Magd
 */
public class Speed extends PlayerDecorator { 
    
    private boolean right = false;
    private boolean left = false;
    private boolean up   = false;
    private boolean down = false;
    
    int speed;
    WallCollisionDetection wallCollision;
    BeanCollisionDetection beanCollision;

    public Speed(Player newPlayer, int speed ) {
        super(newPlayer);
        super.getDecorators().add(this);
        this.speed = speed;
        this.setEatbeans(newPlayer.getEatbeans());
    }

    @Override
    public List<PlayerDecorator> getDecorators() {
        return super.getDecorators();
    }
    
    @Override
    public void tick() throws IOException {
        if (up) {
            if(!wallCollision.collisionHappening(Direction.up))
                super.setY(super.getY()-speed); 
        }else if (down) {
            if(!wallCollision.collisionHappening(Direction.down))
                super.setY(super.getY()+speed); 
        }else if (right) {
            if(!wallCollision.collisionHappening(Direction.right))
                super.setX(super.getX()+speed); 
        }else if (left) {
            if(!wallCollision.collisionHappening(Direction.left))
                super.setX(super.getX()-speed); 
        }
        beanCollision.Eatbean();
    }

    @Override
    public int getEatbeans() {
        return tempPlayer.getEatbeans();
    }

    @Override
    public void setEatbeans(int eatbeans) {
         tempPlayer.setEatbeans(eatbeans);
    }

    @Override
    public String getName(){return tempPlayer.getName();}

    @Override
    public void setName(String name){tempPlayer.setName(name);}

    public void setSpeed(int speed) { this.speed = speed; }
    
    @Override
    public void setDirectionStatus(Helper.Direction direction, boolean status) {
        switch(direction) {
            case up:    up = status;    break;
            case down:  down = status;  break;
            case right: right = status; break;
            case left:  left = status;  break;
            default: break;
        }
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public void setWallCollisionAndBeanCollision(WallCollisionDetection wallCollision,BeanCollisionDetection beanCollision) {
        this.wallCollision = wallCollision;
        this.beanCollision=beanCollision;
        wallCollision.setPlayer(this);
        beanCollision.setPlayer(this);
    }
    
    public void setWallCollision (WallCollisionDetection wallCollision) {
        this.wallCollision = wallCollision;
        wallCollision.setPlayer(this);
    }
    
    public void setBeanCollision(BeanCollisionDetection beanCollision) {
        this.beanCollision=beanCollision;
        beanCollision.setPlayer(this);
    }
    
    public WallCollisionDetection getWallCollision() { return wallCollision; }
    public BeanCollisionDetection getBeanCollision() { return beanCollision; }
}
