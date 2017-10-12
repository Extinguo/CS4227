/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import GameObjects.Helper.Direction;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Magd
 */
public class Player extends Rectangle {

    public boolean right = false;
    private boolean left = false;
    private boolean up   = false;
    private boolean down = false;
    private int speed   = 4;

    public Player(int x, int y) {
        setBounds(x, y, 32, 32);
    }

    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(x, y, width, height);

    }

    public void tick() {
        if (up)        { y -= speed; } 
        else if (down) { y += speed; }
        else if (right){ x += speed; } 
        else if (left) { x -= speed; } 
    }
    
    public void setDirectionStatus(Direction direction, boolean status) {
        switch(direction) {
            case up:    up = status;    break;
            case down:  down = status;  break;
            case right: right = status; break;
            case left:  left = status;  break;
            default: break;
        }
    }
    
    public void setDirections(boolean up, boolean down, boolean right, boolean left) {
        this.up    = up;
        this.down  = down;
        this.right = right;
        this.left  = left;
    }
}
