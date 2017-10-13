/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import java.awt.Color;

/**
 *
 * @author Magd
 */
public class GameObjectFactory {
    
    public static GameObject createWall(int x, int y, int width, int height) {
        return new GameObject(x, y, width, height, new Color(0, 0, 112));
    }
    
    public static GameObject createBean(int x, int y) {
        return new GameObject(x+10, y+10, 8, 8, new Color(204, 140, 0));
    }
    
}
