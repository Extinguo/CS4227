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
public class Apple extends Rectangle {
    
    public Apple(int x, int y) {
        setBounds(x+10, y+10, 8, 8);
    }
    
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y, width, height);
    }
    
}
