package player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import gameobjects.Helper;
import visitor.IVisitable;
import visitor.IVisitor;


public class PlainPlayer implements Player, IVisitable {

    protected String name = "RandomName";
    protected boolean avaliable=true;
    protected int lifes = 3;
    protected int score = 0;
    protected int eatBeans=0;
    protected List<PlayerDecorator> decorators;
    protected Rectangle me;
    protected Color color =Color.GREEN;
    private int num;

    /**
     * Creates a player at the given position with the given boundaries using the default name "RandomName" and sets the number of lifes to 3
     * @param x
     * @param y
     * @param width
     * @param height 
     */
    public PlainPlayer(int x, int y, int width, int height) {
        me = new Rectangle(x, y, width, height);
        decorators = new ArrayList<>();
    }
    
    /**
     * Creates a player with the given name, number of lifes, x and y position and boundaries.
     * @param name
     * @param lifes
     * @param x
     * @param y
     * @param width
     * @param height 
     */
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
        if(this.getAvaliable()) {
            g.setColor(color);
            g.fillOval(me.x,me.y,me.width,me.height);
        }
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
    public void tick() {
        // Since a plain player can´t do anything there is no mean in implementing this method
    }

    @Override
    public void setDirectionStatus(Helper.Direction direction, boolean b) { 
        // Since a plain player can´t do anything there is no mean in implementing this method
    }
    
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void setAvaliable(boolean avaliable) {
        this.avaliable=avaliable;
    }

    @Override
    public boolean getAvaliable() {
        return this.avaliable;
    }

    @Override
    public void setColor(Color c) {
        this.color = c;
    }


    
}
