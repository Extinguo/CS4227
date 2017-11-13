package monster;

import gameobjects.Level;
import player.Player;

public class SimpleFollowAlgorithm extends FollowState {

    private Player player;
    private int n;

    /**
     * Makes the enemy follow a player using a simple algorithm
     * @param enemy The enemy
     * @param level The leveldate
     * @param player The player to follow
     */
    public SimpleFollowAlgorithm(Enemy enemy, Level level, Player player) {
        super(enemy, level);
        this.player = player;
        n = 1;
    }

    /**
     * The enemy follows the player
     */
    @Override
    public void follow() {
        while (n == 1) {
            int m = level.getController().getPlayers().size();
            int r = randomGen.nextInt(m);
            boolean m1 = level.getController().getPlayers().get(r).getAvaliable();
            while (!m1) {
                r = randomGen.nextInt(m);
                m1 = level.getController().getPlayers().get(r).getAvaliable();
            }
            player = level.getController().getPlayers().get(r);
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
