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
public class Player {
    
    Rectangle me;

    public boolean right = false;
    private boolean left = false;
    private boolean up   = false;
    private boolean down = false;
    private int speed   = 4;

    public Player(int x, int y) {
        me = new Rectangle(x, y, 32, 32);
    }

    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(me.x, me.y, me.width, me.height);

    }

    public void tick() {
        if (up)        { me.y -= speed; } 
        else if (down) { me.y += speed; }
        else if (right){ me.x += speed; } 
        else if (left) { me.x -= speed; } 
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
}

/*
Bridge for collision detection
    -> Different collision APIs -> Bob
Use Interceptor for whenever a collision happens to log it. -> Qing
Build in Visitor -> Later
(Detailed) UML-Diagramm -> Yann
Sequencediagram -> Yann
Decorator for Player -> Magd
*/