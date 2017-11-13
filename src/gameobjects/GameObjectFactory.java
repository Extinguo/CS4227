package gameobjects;

import java.awt.Color;


public class GameObjectFactory {
    
    private GameObjectFactory() {
        // Hiding the constructor
    }
    
    /**
     * Returns a wall. 
     * 
     * @param x The x position where the wall will be
     * @param y The y position where the wall will be
     * @param width The width of the wall
     * @param height THe Height of the wall
     * 
     * @return GameObject : The wall with the given size and color.
     */
    public static GameObject createWall(int x, int y, int width, int height) {
        return new GameObject(x, y, width, height, new Color(0, 0, 112));
    }
    
    /**
     * Returns a bean. 
     * 
     * @param x The x position where the bean will be
     * @param y The y position where the bean will be
     * 
     * @return GameObject : The bean with edited size and position (so its in the middle)
     */
    public static GameObject createBean(int x, int y) {
        return new GameObject(x+10, y+10, 8, 8, new Color(204, 140, 0));
    }
    
}
