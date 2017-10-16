/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects.Player;

import CollisionDetection.CollisionDetection;
import GameObjects.Player.Attributes.Speed;

/**
 *
 * @author Magd
 */
public class PlayerFactory {
    
    public static Player createPlainPlayer(int x, int y, int width, int height) {
        return new PlainPlayer(x, y, width, height);
    }
    
    public static Player createPlainPlayer(String name, int lifes, int x, int y, int width, int height) {
        return new PlainPlayer(name, lifes, x, y, width, height);
    }
    
    public static Player createPlayerWithSpeed(int x, int y, int width, int height, CollisionDetection collisionDetection) {
        return new Speed(new PlainPlayer(x, y, width, height), 4, collisionDetection);
    }
    
}