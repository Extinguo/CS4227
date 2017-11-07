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
 * 
 * Let know why this null thing is going on
 */
public class GameObjectAdapter implements I_GameObject {
    
    private final Delegator renderFunc;
    private final Delegator setColorFunc;
    private final Delegator getBoundFunc;
    private final Delegator acceptFunc;

    /**
     * Pluggable Adapter for a GameObject
     * @param gameObject The given GameObject is the adaptee
     */
    public GameObjectAdapter(GameObject gameObject) {
        
        renderFunc = (args) -> {
            gameObject.render((Graphics)args[0]);
            return null;
        };
        
        setColorFunc = (args) -> {
            gameObject.setColor((Color)args[0]); 
            return null; 
        };
        
        getBoundFunc = (args) -> {
            return gameObject.getBounds();
        };
        
        acceptFunc = (args) -> {
            gameObject.accept((IVisitor)args[0]);
            return null;
        };
    }
   
    
    @Override
    public void render(Graphics g) {
        renderFunc.execute(g);
    }
    
    @Override
    public void setColor(Color c) {
        setColorFunc.execute(c);
    }

    @Override
    public Rectangle getBounds() {
        return (Rectangle)getBoundFunc.execute();
    }

    @Override
    public void accept(IVisitor visitor) {
        acceptFunc.execute(visitor);
    }


    
    
}
