/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import visitor.IVisitable;
import visitor.IVisitor;

import java.io.Serializable;

/**
 *
 * @author Magd
 */
public class GameObject implements IVisitable, Serializable, I_GameObject {

    Rectangle me;
    Color color;

    /**
     * Walls and Beans are GameObjects. They only differ by the color and the
     * size. These are set here.
     *
     * @param x The x position where the Object will be
     * @param y The y position where the Object will be
     * @param width The width of the Object
     * @param height THe Height of the Object
     * @param color The Color of the Object
     */
    GameObject(int x, int y, int width, int height, Color color) {
        me = new Rectangle(x, y, width, height);
        this.color = color;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(me.x, me.y, me.width, me.height);
    }

    @Override
    public Rectangle getBounds() {
        return me;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void setColor(Color c) {
        this.color = c;
    }

}
