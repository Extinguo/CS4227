/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects.Player.Attributes;

import CollisionDetection.CollisionDetection;
import GameObjects.Helper;
import GameObjects.Helper.Direction;
import GameObjects.Player.Player;
import GameObjects.Player.PlayerDecorator;
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
    CollisionDetection collisionDetection;

    public Speed(Player newPlayer, int speed, CollisionDetection collisionDetection ) {
        super(newPlayer);
        super.getDecorators().add(this);
        this.speed = speed;
        this.collisionDetection = collisionDetection;
        this.collisionDetection.setPlayer(this);
    }

    @Override
    public List<PlayerDecorator> getDecorators() {
        return super.getDecorators();
    }
    
    @Override
    public void tick() {
        if (up) {
            if(!collisionDetection.collisionHappening(Direction.up))
                super.setY(super.getY()-speed); 
        } if (down) {
            if(!collisionDetection.collisionHappening(Direction.down))
                super.setY(super.getY()+speed); 
        } if (right) { 
            if(!collisionDetection.collisionHappening(Direction.right))
                super.setX(super.getX()+speed); 
        } if (left) { 
            if(!collisionDetection.collisionHappening(Direction.left))
                super.setX(super.getX()-speed); 
        } 
    }
    
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
    
}
