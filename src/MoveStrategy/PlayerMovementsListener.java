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

    public PlayerMovementsListener(Controller controller) {
        this.controller = controller;
    }

    Invoker invoker = new Invoker();

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        boolean up = false;
        boolean down = false;
        boolean right = false;
        boolean left = false;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                Command upCommand = new UpCommand(controller.getPlayer());
                invoker.setUpCommand(upCommand);
                invoker.up();
                break;
            case KeyEvent.VK_DOWN:
                Command downCmd = new DownCommand(controller.getPlayer());
                invoker.setDownCommand(downCmd);
                invoker.down();
                break;
            case KeyEvent.VK_RIGHT:
                Command rightCmd = new RightCommand(controller.getPlayer());
                invoker.setRightCommand(rightCmd);
                invoker.right();
                break;
            case KeyEvent.VK_LEFT:
                Command leftCmd = new LeftCommand(controller.getPlayer());
                invoker.setLeftCommand(leftCmd);
                invoker.left();
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                Command upCommand = new UpCommand(controller.getPlayer());
                invoker.setUpCommand(upCommand);
                invoker.undoUp();
                break;
            case KeyEvent.VK_DOWN:
                Command downCmd = new DownCommand(controller.getPlayer());
                invoker.setDownCommand(downCmd);
                invoker.undoDown();
                break;
            case KeyEvent.VK_RIGHT:
                Command rightCmd = new RightCommand(controller.getPlayer());
                invoker.setRightCommand(rightCmd);
                invoker.undoRight();
                break;
            case KeyEvent.VK_LEFT:
                Command leftCmd = new LeftCommand(controller.getPlayer());
                invoker.setLeftCommand(leftCmd);
                invoker.undoLeft();
                break;
            default:
                break;
        }
    }

}
