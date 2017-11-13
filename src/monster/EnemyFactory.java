package monster;


public class EnemyFactory{
    
    private EnemyFactory() {
        // Hiding the constructor
    }
    
    public static Enemy createEnemy(int x, int y) {
        return new Enemy(x,y);
    }
}
