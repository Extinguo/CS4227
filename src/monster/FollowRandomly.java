package monster;

import gameobjects.Level;

import java.awt.Rectangle;


public class FollowRandomly extends FollowState {

    public FollowRandomly(Enemy enemy, Level level) {
        super(enemy, level);
        dir = randomGen.nextInt(4);
    }

    /**
     * Checks if the enemy can move to the next position
     * @param nextX The next x-position
     * @param nextY The next y-position
     * @return True/false
     */
    @Override
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
    @Override
    public void follow() {
        if (dir == right) {
            if (canMove(enemy.getBounds().x + speed, enemy.getBounds().y)) {
                enemy.getBounds().setLocation(enemy.getBounds().x + speed, enemy.getBounds().y);
            } else {
                dir = randomGen.nextInt(4);
            }
        } else if (dir == left) {
            if (canMove(enemy.getBounds().x - speed, enemy.getBounds().y)) {
                enemy.getBounds().setLocation(enemy.getBounds().x - speed, enemy.getBounds().y);
            } else {
                dir = randomGen.nextInt(4);
            }
        } else if (dir == up) {
            if (canMove(enemy.getBounds().x, enemy.getBounds().y - speed)) {
                enemy.getBounds().setLocation(enemy.getBounds().x, enemy.getBounds().y - speed);
            } else {
                dir = randomGen.nextInt(4);
            }
        } else if (dir == down) {
            if (canMove(enemy.getBounds().x, enemy.getBounds().y + speed)) {
                enemy.getBounds().setLocation(enemy.getBounds().x, enemy.getBounds().y + speed);
            } else {
                dir = randomGen.nextInt(4);
            }
        }
    }

}
