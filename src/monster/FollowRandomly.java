/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monster;

import gameobjects.Level;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Magd
 */
public class FollowRandomly extends FollowState {

    public FollowRandomly(Enemy enemy, Level level) {
        super(enemy, level);
        dir = randomGen.nextInt(4);
    }

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
