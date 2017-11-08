package monster;


import java.awt.*;

/**
 * Created by viola on 2017/11/8.
 */
public class EnemyFactory{
    public static Enemy createEnemy(int x, int y) {
        return new Enemy(x,y);
    }
}
