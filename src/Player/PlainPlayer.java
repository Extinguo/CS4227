/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import GameObjects.Helper;
import Visitor.IVisitable;
import Visitor.IVisitor;

/**
 *
 * @author Magd
 */
public class PlainPlayer implements Player, IVisitable {

    private String name = "RandomName";
    private int lifes = 3;
    private int score = 0;
    private int eatBeans=0;
    private List<PlayerDecorator> decorators;
    private Rectangle me;  
    private Color color = Color.yellow;

    private int num;

    public PlainPlayer(int x, int y, int width, int height) {
        me = new Rectangle(x, y, width, height);
        decorators = new ArrayList<>();
    }
    
    public PlainPlayer(String name, int lifes, int x, int y, int width, int height) {
        this.name = name;
        this.lifes = lifes;
        me = new Rectangle(x, y, width, height);
        decorators = new ArrayList<>();
    }
    
    @Override
    public String getName() { return name; }
    @Override
    public int getLifes() { return lifes; }
    @Override
    public int getX() { return me.x; }
    @Override
    public int getY() { return me.y; }
    @Override
    public List<PlayerDecorator> getDecorators() { return decorators; }
    @Override
    public Rectangle getBounds() { return me; }
    @Override
    public int getScore() { return this.score; }

    @Override
    public void setLifes(int lifes) { this.lifes = lifes; }
    @Override
    public void setX(int x) { me.x = x; }
    @Override
    public void setY(int y) { me.y = y; }
    @Override
    public void setScore(int score) { this.score = score; }
    
    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(me.x, me.y, me.width, me.height);
    }

    @Override
    public int getEatbeans() {
        return eatBeans;
    }

    @Override
    public void setEatbeans(int eatbeans) {
        this.eatBeans=eatbeans;
    }

    @Override
    public int getNum() {
        return this.num;
    }

    @Override
    public void setNum(int m) {
        this.num=m;
    }

    @Override
    public void setName(String name)
    {
        this.name=name;
    }

    @Override
    public void tick() { }

    @Override
    public void setDirectionStatus(Helper.Direction direction, boolean b) { }
    
    @Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);    
	}

	@Override
	public void setColor(Color c) {
		this.color = c;
	}

    
}