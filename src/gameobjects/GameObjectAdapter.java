/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects;

import java.awt.Graphics;

/**
 *
 * @author Magd
 */
public class GameObjectAdapter {
    
    Delegator renderFunc;

    public GameObjectAdapter(GameObject go) {
        renderFunc = args->go.render((Graphics)args[0]);
    }
    
    public GameObjectAdapter(Level l) {
        renderFunc = args->l.render((Graphics)args[0]);
        
    }
    
    public void doRenderFunc(Graphics g) {
        renderFunc.execute(g);
    }
    
    
}
