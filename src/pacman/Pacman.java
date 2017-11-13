/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import gui.Controller;
import gui.Model;
import gui.View;
import interceptor.ConcreteInterceptor;
import interceptor.Dispatcher;

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
        Dispatcher dispatcher = Dispatcher.getInstance();
        ConcreteInterceptor interceptor = new ConcreteInterceptor();
        dispatcher.register(interceptor);
        
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
