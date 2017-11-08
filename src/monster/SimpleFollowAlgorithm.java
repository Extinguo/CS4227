/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monster;

import gameobjects.Level;
import player.Player;

/**
 *
 * @author Magd
 */
public class SimpleFollowAlgorithm extends FollowState {
    
    private Player player;
    private int n;

    public SimpleFollowAlgorithm(Enemy enemy, Level level, Player player) {
        super(enemy, level);
        this.player = player;
        n = 1;
    }

    @Override
    public void follow() {
        while (n == 1) {
            int m = level.getController().getPlayers().size();
            player = level.getController().getPlayers().get(randomGen.nextInt(m));
            n++;
        }
        if (enemy.getBounds().x < player.getBounds().x) {
            if (canMove(enemy.getBounds().x + speed, enemy.getBounds().y)) {
                enemy.getBounds().setLocation(enemy.getBounds().x + speed, enemy.getBounds().y);
            }
        }
        if (enemy.getBounds().x > player.getBounds().x) {
            if (canMove(enemy.getBounds().x - speed, enemy.getBounds().y)) {
                enemy.getBounds().setLocation(enemy.getBounds().x - speed, enemy.getBounds().y);
            }
        }
        if (enemy.getBounds().y < player.getBounds().y) {
            if (canMove(enemy.getBounds().x, enemy.getBounds().y + speed)) {
                enemy.getBounds().setLocation(enemy.getBounds().x, enemy.getBounds().y + speed);
            }
        }
        if (enemy.getBounds().y > player.getBounds().y) {
            if (canMove(enemy.getBounds().x, enemy.getBounds().y - speed)) {
                enemy.getBounds().setLocation(enemy.getBounds().x, enemy.getBounds().y - speed);
            }
        }
    }
    
    
    
}
