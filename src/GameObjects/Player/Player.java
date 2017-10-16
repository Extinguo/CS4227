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
public interface Player {
    
    public String getName();
    public int    getLifes();
    public int getX();
    public int getY();
    public List<PlayerDecorator> getDecorators();
    public Rectangle getBounds();
    
    public void setLifes(int lifes);
    public void setX(int x);
    public void setY(int y);
    public void setDirectionStatus(Helper.Direction direction, boolean b);
    
    public void tick();
    public void render(Graphics g);

    
}
