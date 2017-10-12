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
public class Enemy extends Rectangle {
    public Enemy(int x, int y) {
        setBounds(x, y, 32, 32);
    }
    
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }
    
    public void tick() {
    }
    
}
