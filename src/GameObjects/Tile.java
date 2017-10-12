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
public class Tile extends Rectangle {
    
    public Tile(int x, int y) {
        setBounds(x, y, 32, 32);
    }
    
    public void render(Graphics g) {
        g.setColor(new Color(33, 0, 127));
        g.fillRect(x, y, width, height);
    }
    
}
