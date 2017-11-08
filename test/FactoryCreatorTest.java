

import gameobjects.GameObjectFactory;
import monster.EnemyFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import player.PlayerFactory;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FactoryCreatorTest {

  private int x;
  private int y;
  int width;
  int height;
  int speed;
  String name;
  int lifes;
  private static GameObjectFactory gameObjectFactory = null;
  private static EnemyFactory enemyFactory = null;
  private static PlayerFactory playerFactory = null;

  @BeforeClass
  public static void setUp(){
      gameObjectFactory = new GameObjectFactory();
      enemyFactory = new EnemyFactory();
      playerFactory = new PlayerFactory();

  }

  @Parameters
  public static Collection prepareData() {
    Object[][]object = { { 1,2,1,2,2,"bob",2 }, { 3, 4,2,3,2,"Magd", 2},{ 3, 4,3,3,2,"Lin", 2},{ 3, 4,2,2,2,"Yann", 2} };
    return Arrays.asList(object);
  }

  public FactoryCreatorTest(int x, int y, int width, int height, int speed, String name, int lifes){
      this.x = x;
      this.y = y;
      this.name = name;
      this.height = height;
      this.speed = speed;
      this.width = width;
      this.lifes = lifes;
  }

  @Test
  public void getBeanFactory(){
      Assert.assertNotNull(gameObjectFactory.createBean(this.x, this.y));
  }

@Test
  public void getPlayerFactory(){
    Assert.assertNotNull(PlayerFactory.createNewPlayerWithSpeed(name, lifes, speed, x, y, width, height));
  }

  @Test
  public void getWallFactory(){
    Assert.assertNotNull(GameObjectFactory.createWall(x, y, width, height));
  }

  @Test
  public void getEmenyFactory() {
      Assert.assertNotNull(EnemyFactory.createEnemy(x, y));
  }
}
