package monster;

import gameobjects.Level;
import player.Player;
import java.io.Serializable;

public class EnemyIntelligentMovement implements Serializable {
    
    private Level level;
    private Enemy enemy;
    private FollowState state;
    private int time=0;
    private int targetTime=60*30;
    private Player player;
    
    public EnemyIntelligentMovement(Level level,Enemy enemy)
    {
        this.level=level;
        this.enemy=enemy;
        this.state = new FollowRandomly(enemy, level);
    }
    
    public void tick() {
        state.follow();
        time++;
        if(time==targetTime) {
            state = new SimpleFollowAlgorithm(enemy, level, player);
        }
    }
    
}
