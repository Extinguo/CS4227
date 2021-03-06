package player;

import player.attributes.Speed;


public class PlayerFactory {
    
    public PlayerFactory() {
        // Just hiding the constructor
    }
    
    public static Player createPlainPlayer(int x, int y, int width, int height) {
        return new PlainPlayer(x, y, width, height);
    }
    
    public static Player createPlainPlayer(String name, int lifes, int x, int y, int width, int height) {
        return new PlainPlayer(name, lifes, x, y, width, height);
    }


    public static Player createPlayerWithSpeed(int x, int y, int width, int height) {
        return new Speed(new PlainPlayer(x, y, width, height), 4);
    }

    public static Player createNewPlayerWithSpeed(String name, int lifes, int speed, int x, int y, int width, int height) {
        return new Speed(new PlainPlayer(name, lifes, x, y, width, height), speed);
    }

    public static Player createPlayerWithSpeed(Player player, int speed) {
        return new Speed(player, speed);
    }
    
}
