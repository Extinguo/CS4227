/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import GUI.Controller;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
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

    private int width;
    private int height;

    private Tile[][] tiles;
    private List<Apple> apples;
    public List<Enemy> enemys;

    public Level(Controller controller) {
        this.controller = controller;
    }

    public void loadLevel(String path) {
        apples = new ArrayList<>();
        enemys = new ArrayList<>();
        try {
            BufferedImage map = ImageIO.read(getClass().getResource(path));
            this.width = map.getWidth();
            this.height = map.getHeight();
            int[] pixels = new int[width * height];
            tiles = new Tile[width][height];
            map.getRGB(0, 0, width, height, pixels, 0, width);
            for (int xx = 0; xx < width; xx++) {
                for (int yy = 0; yy < height; yy++) {
                    int val = pixels[xx + (yy * width)];
                    if (val == 0xFF000000) {
                        tiles[xx][yy] = new Tile(xx * 32, yy * 32);
                    } else if (val == 0xFF0000FF) {
                        controller.getPlayer().x = xx * 32;
                        controller.getPlayer().y = yy * 32;
                    } else if(val == 0xFFFF0000) {
                        enemys.add(new Enemy(xx*32, yy*32));
                    } else {
                        apples.add(new Apple(xx * 32, yy * 32));
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
                if (tiles[x][y] != null) {
                    tiles[x][y].render(g);
                }
            }
        }

        for (Apple a : apples) {
            a.render(g);
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

}
