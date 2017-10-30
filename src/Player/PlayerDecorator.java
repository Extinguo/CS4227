/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.List;

import GameObjects.Helper;
import Visitor.IVisitable;
import Visitor.IVisitor;

/**
 *
 * @author Magd
 */
public abstract class PlayerDecorator implements Player, IVisitable{
    
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
    public int getScore() { return tempPlayer.getScore(); }

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
    public void setScore(int score) { tempPlayer.setScore(score); }
    
    
    
    @Override
    public void render(Graphics g) { tempPlayer.render(g); }
    
    @Override
    public void tick() throws IOException { tempPlayer.tick(); }

    @Override
    public int getNum()
    {
        return tempPlayer.getNum();
    }
    @Override
    public void setNum(int m)
    {
        tempPlayer.setNum(m);
    }
    
    @Override
	public void setColor(Color c) {
		 tempPlayer.setColor(c);
	}

	@Override
	public void accept(IVisitor visitor) {
		tempPlayer.accept(visitor);
	}
    
    
    
    
    
}
