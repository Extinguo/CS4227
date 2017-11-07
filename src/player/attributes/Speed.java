/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player.attributes;

import collisiondetection.BeanCollisionDetection;
import collisiondetection.PlayerEnemyCollisionDetection;
import collisiondetection.WallCollisionDetection;
import gameobjects.Helper;
import gameobjects.Helper.Direction;
import player.Player;

import java.io.IOException;
import player.PlayerDecorator;

/**
 *
 * @author Magd
 */
public class Speed extends PlayerDecorator { 
    
    private boolean right = false;
    private boolean left = false;
    private boolean up   = false;
    private boolean down = false;
    
    int charSpeed;
    
    WallCollisionDetection wallCollision;
    BeanCollisionDetection beanCollision;
    PlayerEnemyCollisionDetection peCollision;

    public Speed(Player newPlayer, int speed ) {
        super(newPlayer);
        super.getDecorators().add(this);
        this.charSpeed = speed;
        this.setEatbeans(newPlayer.getEatbeans());
    }
    
    @Override
    public void tick() throws IOException {
        if (up && !wallCollision.collisionHappening(Direction.UP)) {
                super.setY(super.getY()-charSpeed); 
        } else if (down && !wallCollision.collisionHappening(Direction.DOWN)) {
                super.setY(super.getY()+charSpeed); 
        } else if (right && !wallCollision.collisionHappening(Direction.RIGHT)) {
                super.setX(super.getX()+charSpeed); 
        } else if (left && !wallCollision.collisionHappening(Direction.LEFT)) {
                super.setX(super.getX()-charSpeed); 
        }
        beanCollision.eatBean();
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

    public void setSpeed(int speed) { this.charSpeed = speed; }
    
    @Override
    public void setDirectionStatus(Helper.Direction direction, boolean status) {
        switch(direction) {
            case UP:
                up = status;
                break;
            case DOWN:
                down = status;
                break;
            case RIGHT:
                right = status;
                break;
            case LEFT:
                left = status;
                break;
            default: 
                break;
        }
    }
    
    public int getSpeed() {
        return charSpeed;
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
    
    public void setPlayerEnemyCollisionDetection(PlayerEnemyCollisionDetection peCollision) {
        this.peCollision = peCollision;
        peCollision.setPlayer(this);
    }
    
    public WallCollisionDetection getWallCollision() { return wallCollision; }
    public BeanCollisionDetection getBeanCollision() { return beanCollision; }
    public PlayerEnemyCollisionDetection getPlayerEnemyCollision() {
        return peCollision;
    }
}
