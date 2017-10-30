/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import CollisionDetection.BeanCollisionDetection;
import CollisionDetection.WallCollisionDetection;
import GUI.Controller;
import GameObjects.Player.Attributes.Speed;
import GameObjects.Player.Player;
import GameObjects.Player.PlayerFactory;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Magd
 */
public class Level {
    
    private final int BLOCKSIZE = 32;
    private final int tileColorInPNG   = 0xFF000000;
    private final int playerCclorInPNG = 0xFF0000FF;
    private final int enemyColorInPNG  = 0xFFFF0000;

    private int width;
    private int height;

    private GameObject[][] walls;
    private List<GameObject> beans;
    
   // private List<Player> players;
    private List<Enemy> enemys;
    private Controller controller;
    public Level(Controller controller) {
        this.controller=controller;
    }

    /**
     * Loads the leveldata from the given file and stores it. 
     * The Player is created by this aswell since his position is only clear after loading the leveldata!
     * 
     * @param filename The file in the Ressources folder, which describes the level structure.
     * It is important that the Colors in the file are the ones specified above.
     */
    public void loadLevel(String filename) {
        beans = new ArrayList<>();
        enemys = new ArrayList<>();
        try {
            
            URL location = Level.class.getProtectionDomain().getCodeSource().getLocation();
            String path = location.getPath().replace("build/classes/", "Ressources/" + filename);
            BufferedImage map=ImageIO.read(new FileInputStream("E:/map.png"));
          //  BufferedImage map = ImageIO.read(new FileInputStream("/Users/apple/IdeaProjects/CS4227/Ressources/map.png"));
            this.width = map.getWidth();
            this.height = map.getHeight();
            System.out.print(map.getHeight()+"  "+map.getHeight());
            int[] pixels = new int[width * height];
            walls = new GameObject[width][height];
            map.getRGB(0, 0, width, height, pixels, 0, width);
            int count=1;
            for (int xx = 0; xx < width; xx++) {
                for (int yy = 0; yy < height; yy++) {
                    int val = pixels[xx + (yy * width)];
                    switch (val) {
                        case tileColorInPNG:
                            walls[xx][yy] = GameObjectFactory.createWall(xx * BLOCKSIZE, yy * BLOCKSIZE, BLOCKSIZE, BLOCKSIZE);
                            break;
                        case playerCclorInPNG:


                            Player playerWithSpeed = PlayerFactory.createNewPlayerWithSpeed("bob", 4, 4, xx*BLOCKSIZE+3, yy*BLOCKSIZE+3, BLOCKSIZE-8, BLOCKSIZE-8);

                            // -------------------------------

                            //Player playerWithSpeed = PlayerFactory.createPlayerWithSpeed(xx*BLOCKSIZE+3, yy*BLOCKSIZE+3, BLOCKSIZE-6, BLOCKSIZE-6);
                            ((Speed)(playerWithSpeed)).setWallCollision(new WallCollisionDetection(this));
                            ((Speed)(playerWithSpeed)).setBeanCollision(new BeanCollisionDetection(this));
                            playerWithSpeed.setNum(count++);
                            controller.addPlayer(playerWithSpeed);
                           // players.add(playerWithSpeed);
                            // player = playerWithSpeed;
                            break;
                        case enemyColorInPNG:
                            Enemy enemy=new Enemy(xx*BLOCKSIZE, yy*BLOCKSIZE);
                            EnemyIntelligentMovement enemyIntelligentMovement=new EnemyIntelligentMovement(this,enemy);
                            enemy.setEnemyIntelligentMovement(enemyIntelligentMovement);
                            enemys.add(enemy);
                            break;
                        default:
                            beans.add(GameObjectFactory.createBean(xx * BLOCKSIZE, yy * BLOCKSIZE));
                            break;
                    }
                }
            }
            System.out.print("The number of Players:");
        } catch (IOException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    /**
     * Renders the Level. This includes beans, walls and enemys.
     * 
     * @param g The Graphic on which to render
     */
    public void render(Graphics g) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (walls[x][y] != null) {
                    walls[x][y].render(g);
                }
            }
        }

        for (GameObject bean : beans) {
            bean.render(g);
        }
        
        for(Enemy e : enemys) {
            e.render(g);
        }
    }
    
    /**
     * This tick-method helps to update the gamedata.
     */
    public void tick() {
        for(Enemy e : enemys) {
            e.tick();
        }
    }
    
    public GameObject[][] getWalls() {
        return walls;
    }
    
    public List<GameObject> getBeans() {
        return beans;
    }

    public List<Enemy> getEnemys(){return enemys;}

    public Controller getController(){return this.controller;}
    /*
    public List<Player> getPlayer() {
        return players;
    }
    */

}
