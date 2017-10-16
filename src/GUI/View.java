/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

/**
 *
 * @author Magd
 */
public class View extends Canvas {
    
    Controller controller;

    private final int WIDTH = 640;
    private final int HEIGHT = 480;

    /**
     * Initialises the view by settings its dimension.
     */
    public View() {
        Dimension dimension = new Dimension(WIDTH, HEIGHT);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
    }

    /**
     * Renders the view/new data. This method will be called by the controller.
     */
    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        controller.getPlayer().render(g);
        controller.getLevel().render(g);

        g.dispose();
        bs.show();
    }
    
    public void addPlayerMovementsListener(KeyListener playerMovementsListener) {
        this.addKeyListener(playerMovementsListener);
    }
    
    public void setController(Controller controller) {
        this.controller = controller;
    }

}
