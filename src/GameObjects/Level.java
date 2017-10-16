/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import CollisionDetection.MyCollisionDetection;
import CollisionDetection.OtherCollisionDetection;
import GUI.Controller;
import GameObjects.Player.PlayerFactory;
import Pacman.Pacman;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
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

    Controller controller;
    
    private final int BLOCKSIZE = 32;
    private final int tileColorInPNG   = 0xFF000000;
    private final int playerCclorInPNG = 0xFF0000FF;
    private final int enemyColorInPNG  = 0xFFFF0000;

    private int width;
    private int height;

    private GameObject[][] walls;
    private List<GameObject> beans;
    
    public List<Enemy> enemys;

    public Level(Controller controller) {
        this.controller = controller;
    }

    public void loadLevel(String filename) {
        beans = new ArrayList<>();
        enemys = new ArrayList<>();
        try {
            
            
            URL location = Level.class.getProtectionDomain().getCodeSource().getLocation();
            String path = location.getPath().replace("build/classes/", "Ressources/" + filename);
            
            BufferedImage map = ImageIO.read(new URL(location, path));
            this.width = map.getWidth();
            this.height = map.getHeight();
            int[] pixels = new int[width * height];
            walls = new GameObject[width][height];
            map.getRGB(0, 0, width, height, pixels, 0, width);
            for (int xx = 0; xx < width; xx++) {
                for (int yy = 0; yy < height; yy++) {
                    int val = pixels[xx + (yy * width)];
                    switch (val) {
                        case tileColorInPNG:
                            walls[xx][yy] = GameObjectFactory.createWall(xx * BLOCKSIZE, yy * BLOCKSIZE, BLOCKSIZE, BLOCKSIZE);
                            break;
                        case playerCclorInPNG:
                            controller.setPlayer(PlayerFactory.createPlayerWithSpeed(xx*BLOCKSIZE+3, yy*BLOCKSIZE+3, BLOCKSIZE-6, BLOCKSIZE-6, new MyCollisionDetection(this)));
                            break;
                        case enemyColorInPNG:
                            enemys.add(new Enemy(xx*BLOCKSIZE, yy*BLOCKSIZE));
                            break;
                        default:
                            beans.add(GameObjectFactory.createBean(xx * BLOCKSIZE, yy * BLOCKSIZE));
                            break;
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

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
    
    public void tick() {
        for(Enemy e : enemys) {
            e.tick();
        }
    }
    
    public GameObject[][] getWalls() {
        return walls;
    }

}
