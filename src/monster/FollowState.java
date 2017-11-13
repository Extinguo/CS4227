package monster;

import gameobjects.Level;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.Random;

public abstract class FollowState implements Serializable {

    protected int dir = 1;
    protected int right = 0, left = 1, up = 2, down = 3;
    protected int speed = 3;
    protected int targetTime = 60 * 30;
    protected monster.Enemy enemy;
    protected Level level;
    protected Random randomGen;

    public FollowState(Enemy enemy, Level level) {
        this.enemy = enemy;
        this.level = level;
        randomGen = new Random();
    }

    /**
     * Checks if the enemy can move to the next position
     *
     * @param nextX The next x-position
     * @param nextY The next y-position
     * @return True/false
     */
    protected boolean canMove(int nextX, int nextY) {
        Rectangle bounds = new Rectangle(nextX, nextY, enemy.getBounds().width, enemy.getBounds().height);
        for (int xx = 0; xx < level.getWalls().length; xx++) {
            for (int yy = 0; yy < level.getWalls()[0].length; yy++) {
                if (level.getWalls()[xx][yy] != null) {
                    if (bounds.intersects(level.getWalls()[xx][yy].getBounds())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * The enemy follows the player
     */
    public abstract void follow();
}
