/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.List;

import gameobjects.Helper;
import visitor.IVisitor;
import java.io.Serializable;

/**
 *
 * @author Magd
 */
public interface Player extends Serializable {
    
    public String getName();
    public void setName(String name);
    public int  getLifes();
    public int getX();
    public int getY();
    public List<PlayerDecorator> getDecorators();
    public Rectangle getBounds();
    public int getScore();
    
    public void setLifes(int lifes);
    public void setX(int x);
    public void setY(int y);
    public void setDirectionStatus(Helper.Direction direction, boolean b);
    public void setScore(int score);
    
    public void tick() throws IOException;
    public void render(Graphics g);

    public int getEatbeans();
    public void setEatbeans(int eatbeans);

    public int getNum();
    public void setNum(int m);
    
    public void setColor(Color c);
    
    public void accept(IVisitor visitor);
}
