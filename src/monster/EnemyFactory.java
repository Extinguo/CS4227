package monster;


public class EnemyFactory{
    
    public EnemyFactory() {
        // Hiding the constructor
    }
    
    public static Enemy createEnemy(int x, int y) {
        return new Enemy(x,y);
    }
}
