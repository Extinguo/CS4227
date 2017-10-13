/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects.Player.Attributes;

import GameObjects.Helper;
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

    public Speed(Player newPlayer, int speed) {
        super(newPlayer);
        super.getDecorators().add(this);
        this.speed = speed;
    }

    @Override
    public List<PlayerDecorator> getDecorators() {
        return super.getDecorators();
    }
    
    @Override
    public void tick() {
        if (up)        { super.setY(super.getY()-speed); } 
        else if (down) { super.setY(super.getY()+speed); }
        else if (right){ super.setX(super.getX()+speed); } 
        else if (left) { super.setX(super.getX()-speed); } 
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
