/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import visitor.IVisitor;

/**
 *
 * @author Magd
 */
public interface I_GameObject {
        
    /**
     * Renders the Object using the java.awt.Graphics class
     * @param g The Graphics object which will be drawed on
     */
    public void render(Graphics g);
    
    /**
     * Sets the color to the given color
     * @param c the color
     */
    public void setColor(Color c);
    
    /**
     * 
     * @return A rectangle with the bounds
     */
    public Rectangle getBounds();
    
    /**
     * Visitor pattern
     * @param visitor The visitior
     */
    public void accept(IVisitor visitor);
}
