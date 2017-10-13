/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Magd
 */
public class GameObject {
    
    Rectangle me;
    Color color;
    
    GameObject(int x, int y, int width, int height, Color color) {
        me = new Rectangle(x, y, width, height);
        this.color = color;
    }
    
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(me.x, me.y, me.width, me.height);
    }
    
}
