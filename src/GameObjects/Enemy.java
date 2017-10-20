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
public class Enemy {
    
    Rectangle me;
    
    public Enemy(int x, int y) {
        me = new Rectangle(x, y, 32, 32);
    }
    
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(me.x, me.y, me.width, me.height);
    }
    
    public void tick() {
        
    }
    
}
