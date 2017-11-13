package gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import visitor.IVisitor;


public class GameObjectAdapter implements I_GameObject {
    
    private final Delegator renderFunc;
    private final Delegator setColorFunc;
    private final DelegatorWithReturn getBoundFunc;
    private final Delegator acceptFunc;

    /**
     * Pluggable Adapter for a GameObject
     * @param gameObject The given GameObject is the adaptee
     */
    public GameObjectAdapter(GameObject gameObject) {
        
        renderFunc = args -> gameObject.render((Graphics)args[0]);
        setColorFunc = args -> gameObject.setColor((Color)args[0]);
        getBoundFunc = args -> gameObject.getBounds();
        acceptFunc = args -> gameObject.accept((IVisitor)args[0]);
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
