/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman;

import GUI.Controller;
import GUI.Model;
import GUI.View;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Magd
 */
public class Pacman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view, "map.png");
        view.setController(controller);
        model.setController(controller);
        
        JFrame frame = new JFrame("PacMan");
        frame.add(view);
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        frame.setVisible(true);
        controller.start();
    }
    
}
