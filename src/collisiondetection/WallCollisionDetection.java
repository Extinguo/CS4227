package collisiondetection;

import gameobjects.Helper;
import gameobjects.Level;
import player.PlainPlayer;
import player.Player;


public class WallCollisionDetection extends CollisionDetection {

    public WallCollisionDetection(Level level, I_CollisionAlgorithm collisionAlgorithm) {
        super(level, collisionAlgorithm);
    }

    /**
     * Checks whether there will be a collision with the player if he moves.
     *
     * @param direction The direction in that the player wants to move.
     * @return true, if the movement will cause a collision. Otherwise false
     */
    @Override
    public boolean collisionHappening(Helper.Direction direction) {
        int deltaX = 0;
        int deltaY = 0;
        int speed = 4;

        if (direction == Helper.Direction.UP) {
            deltaY = -speed;
        }
        if (direction == Helper.Direction.DOWN) {
            deltaY = +speed;
        }
        if (direction == Helper.Direction.RIGHT) {
            deltaX = +speed;
        }
        if (direction == Helper.Direction.LEFT) {
            deltaX = -speed;
        }


        Player newPlayerPosition = new PlainPlayer(player.getX()+deltaX, player.getY() + deltaY, player.getBounds().width, player.getBounds().height);

        for (int x = 0; x < level.getWalls().length; x++) {
            for (int y = 0; y < level.getWalls()[x].length; y++) {
                if (level.getWalls()[x][y] != null) {
                    if(collisionAlgorithm.collisionHappening(newPlayerPosition, level.getWalls()[x][y])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
