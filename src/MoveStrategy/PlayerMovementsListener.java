/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveStrategy;

import GUI.Controller;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Magd
 */
public class PlayerMovementsListener implements KeyListener {

    Controller controller;
    Invoker invoker;
    
    Command upCommand;
    Command downCmd;
    Command rightCmd; 
    Command leftCmd;
    
    public PlayerMovementsListener(Controller controller) {
        this.controller = controller;
        invoker = new Invoker();
        
        if(controller.getPlayer() != null ) {
            initialiseCommands();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(upCommand == null) {
            initialiseCommands();
        }
        
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                invoker.up();
                break;
            case KeyEvent.VK_DOWN:
                invoker.down();
                break;
            case KeyEvent.VK_RIGHT:
                invoker.right();
                break;
            case KeyEvent.VK_LEFT:
                invoker.left();
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(upCommand == null) {
            initialiseCommands();
        }
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                invoker.undoUp();
                break;
            case KeyEvent.VK_DOWN:
                invoker.undoDown();
                break;
            case KeyEvent.VK_RIGHT:
                invoker.undoRight();
                break;
            case KeyEvent.VK_LEFT:
                invoker.undoLeft();
                break;
            default:
                break;
        }
    }
    
    private void initialiseCommands() {
        upCommand = new UpCommand(controller.getPlayer());
        downCmd = new DownCommand(controller.getPlayer());
        rightCmd = new RightCommand(controller.getPlayer());
        leftCmd = new LeftCommand(controller.getPlayer());
        invoker.setUpCommand(upCommand);
        invoker.setDownCommand(downCmd);
        invoker.setRightCommand(rightCmd);
        invoker.setLeftCommand(leftCmd);
    }
}
