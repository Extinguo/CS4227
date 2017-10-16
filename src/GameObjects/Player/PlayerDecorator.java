/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects.Player;

import GameObjects.Helper;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

/**
 *
 * @author Magd
 */
public abstract class PlayerDecorator implements Player {
    
    protected Player tempPlayer;

    public PlayerDecorator(Player newPlayer) { tempPlayer = newPlayer; }

    @Override
    public String getName() { return tempPlayer.getName(); }
    @Override
    public int getLifes() { return tempPlayer.getLifes(); }
    @Override
    public int getX() { return tempPlayer.getX(); }
    @Override
    public int getY() { return tempPlayer.getY(); }
    @Override
    public List<PlayerDecorator> getDecorators() { return tempPlayer.getDecorators(); }
    @Override
    public Rectangle getBounds() { return tempPlayer.getBounds(); }

    @Override
    public void setLifes(int lifes) { tempPlayer.setLifes(lifes); }
    @Override
    public void setX(int x) { tempPlayer.setX(x); }
    @Override
    public void setY(int y) { tempPlayer.setY(y); }
    @Override
    public void setDirectionStatus(Helper.Direction direction, boolean b) {
        tempPlayer.setDirectionStatus(direction, b);
    }
    
    
    
    @Override
    public void render(Graphics g) { tempPlayer.render(g); }
    
    @Override
    public void tick() { tempPlayer.tick(); }
    
    
    
    
    
    
    
    
    
}
