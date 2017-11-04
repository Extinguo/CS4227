/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects2;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import collisiondetection2.BeanCollisionDetection;
import collisiondetection2.WallCollisionDetection;
import gui2.Controller;
import monster2.Enemy;
import monster2.EnemyIntelligentMovement;
import player2.Player;
import player2.PlayerFactory;
import player.attributes2.Speed;
import visitor2.IVisitor;

import java.io.Serializable;

/**
 *
 * @author Magd
 */
public class Level implements Serializable {
    
    private static final int BLOCKSIZE = 32;
    private static final int TILECOLORINPNG   = 0xFF000000;
    private static final int PLAYERCOLORINPNG = 0xFF0000FF;
    private static final int ENEMYCOLORINPNG  = 0xFFFF0000;

    private int width;
    private int height;

    private GameObject[][] walls;
    private List<GameObject> beans;
    
    private List<Enemy> enemys;
    private Controller controller;
    
    
    public Level(Controller controller) {
        this.controller=controller;
    }
    
    public Level(Level level) {
        this.width = level.width;
        this.height = level.height;
        
        this.walls = level.walls;
        this.beans = new ArrayList<>(level.beans);
        
        this.enemys = level.enemys;
        this.controller = level.controller;
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
            IVisitor themeVisitor = this.controller.getThemeVisitor();
            BufferedImage map=ImageIO.read(new FileInputStream("Ressources/" + filename));
           // BufferedImage map=ImageIO.read(new FileInputStream("/Users/apple/IdeaProjects/CS4227/Ressources/map.png"));
          //  BufferedImage map = ImageIO.read(new FileInputStream("/Users/apple/IdeaProjects/CS4227/Ressources/map.png"));
            this.width = map.getWidth();
            this.height = map.getHeight();
            int[] pixels = new int[width * height];
            walls = new GameObject[width][height];
            map.getRGB(0, 0, width, height, pixels, 0, width);
            int count=1;
            for (int xx = 0; xx < width; xx++) {
                for (int yy = 0; yy < height; yy++) {
                    int val = pixels[xx + (yy * width)];
                    switch (val) {
                        case TILECOLORINPNG:
                            walls[xx][yy] = GameObjectFactory.createWall(xx * BLOCKSIZE, yy * BLOCKSIZE, BLOCKSIZE, BLOCKSIZE);
                            walls[xx][yy].accept(themeVisitor);
                            break;
                        case PLAYERCOLORINPNG:
                            
                            Player playerWithSpeed = PlayerFactory.createNewPlayerWithSpeed("bob", 4, 4, xx*BLOCKSIZE+3, yy*BLOCKSIZE+3, BLOCKSIZE-8, BLOCKSIZE-8);
                            playerWithSpeed.accept(themeVisitor);
                            
                            ((Speed)(playerWithSpeed)).setWallCollision(new WallCollisionDetection(this));
                            ((Speed)(playerWithSpeed)).setBeanCollision(new BeanCollisionDetection(this));
                            playerWithSpeed.setNum(count++);
                            controller.addPlayer(playerWithSpeed);
                            break;
                        case ENEMYCOLORINPNG:
                            Enemy enemy=new Enemy(xx*BLOCKSIZE, yy*BLOCKSIZE);
                            EnemyIntelligentMovement enemyIntelligentMovement=new EnemyIntelligentMovement(this,enemy);
                            enemy.setEnemyIntelligentMovement(enemyIntelligentMovement);
                            enemys.add(enemy);
                            enemy.accept(themeVisitor);
                            
                            break;
                        default:
                            GameObject newBeans = GameObjectFactory.createBean(xx * BLOCKSIZE, yy * BLOCKSIZE);
                            beans.add(newBeans);
                            newBeans.accept(themeVisitor);
                            break;
                    }
                }
            }
            System.out.print("The number of Players: ");
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
            GameObjectAdapter goa = new GameObjectAdapter(bean);
            goa.doRenderFunc(g);
//            bean.render(g);
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
}
