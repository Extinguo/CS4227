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
    /*
    Command upCommand;
    Command downCmd;
    Command rightCmd; 
    Command leftCmd;
    */
    Command P1upcommand;
    Command P1downcommand;
    Command P1leftcommand;
    Command P1rightcommand;
    Command P2upcommand;
    Command P2downcommand;
    Command P2leftcommand;
    Command P2rightcommand;
    Command P3upcommand;
    Command P3downcommand;
    Command P3leftcommand;
    Command P3rightcommand;
    Command P4upcommand;
    Command P4downcommand;
    Command P4leftcommand;
    Command P4rightcommand;
    
    public PlayerMovementsListener(Controller controller) {
        this.controller = controller;
        invoker = new Invoker();
        
        if(controller.getPlayers() != null ) {
            initialiseCommands();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(P1upcommand == null) {
            initialiseCommands();
        }
        
        switch (e.getKeyCode()) {
            //player 1
            case KeyEvent.VK_UP:
                //invoker.up();
                invoker.upPressed(0);
                break;
            case KeyEvent.VK_DOWN:
                //invoker.down();
                invoker.downPressed(0);
                break;
            case KeyEvent.VK_RIGHT:
                //invoker.right();
                invoker.rightPressed(0);
                break;
            case KeyEvent.VK_LEFT:
                //invoker.left();
                invoker.leftPressed(0);
                break;
                //player 2
            case KeyEvent.VK_W:
                invoker.upPressed(1);
                break;
            case KeyEvent.VK_S:
                invoker.downPressed(1);
                break;
            case KeyEvent.VK_A:
                invoker.leftPressed(1);
                break;
            case KeyEvent.VK_D:
                invoker.rightPressed(1);
                break;
                //player 3
            case KeyEvent.VK_I:
                invoker.upPressed(2);
                break;
            case KeyEvent.VK_K:
                invoker.downPressed(2);
                break;
            case KeyEvent.VK_J:
                invoker.leftPressed(2);
                break;
            case KeyEvent.VK_L:
                invoker.rightPressed(2);
                break;
            case KeyEvent.VK_T:
                invoker.upPressed(3);
                break;
            case KeyEvent.VK_G:
                invoker.downPressed(3);
                break;
            case KeyEvent.VK_F:
                invoker.leftPressed(3);
                break;
            case KeyEvent.VK_H:
                invoker.rightPressed(3);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(P1upcommand == null) {
            initialiseCommands();
        }
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                //invoker.undoUp();
                invoker.undoupPressed(0);
                break;
            case KeyEvent.VK_DOWN:
                //invoker.undoDown();
                invoker.undodownPressed(0);
                break;
            case KeyEvent.VK_RIGHT:
                //invoker.undoRight();
                invoker.undorightpressed(0);
                break;
            case KeyEvent.VK_LEFT:
                //invoker.undoLeft();
                invoker.undoleftPressed(0);
                break;
            case KeyEvent.VK_W:
                invoker.undoupPressed(1);
                break;
            case KeyEvent.VK_S:
                invoker.undodownPressed(1);
                break;
            case KeyEvent.VK_A:
                invoker.undoleftPressed(1);
                break;
            case KeyEvent.VK_D:
                invoker.undorightpressed(1);
            case KeyEvent.VK_I:
                invoker.undoupPressed(2);
                break;
            case KeyEvent.VK_K:
                invoker.undodownPressed(2);
                break;
            case KeyEvent.VK_J:
                invoker.undoleftPressed(2);
                break;
            case KeyEvent.VK_L:
                invoker.undorightpressed(2);
                break;
            case KeyEvent.VK_T:
                invoker.undoupPressed(3);
                break;
            case KeyEvent.VK_G:
                invoker.undodownPressed(3);
                break;
            case KeyEvent.VK_F:
                invoker.undoleftPressed(3);
                break;
            case KeyEvent.VK_H:
                invoker.undorightpressed(3);
                break;
            default:
                break;
        }
    }
    
    private void initialiseCommands() {
        P1upcommand=new UpCommand(controller.getPlayers().get(0));
        P1downcommand=new DownCommand(controller.getPlayers().get(0));
        P1leftcommand=new LeftCommand(controller.getPlayers().get(0));
        P1rightcommand=new RightCommand(controller.getPlayers().get(0));
        P2upcommand=new UpCommand(controller.getPlayers().get(1));
        P2downcommand=new DownCommand(controller.getPlayers().get(1));
        P2leftcommand=new LeftCommand(controller.getPlayers().get(1));
        P2rightcommand=new RightCommand(controller.getPlayers().get(1));
        P3upcommand=new UpCommand(controller.getPlayers().get(2));
        P3downcommand=new DownCommand(controller.getPlayers().get(2));
        P3leftcommand=new LeftCommand(controller.getPlayers().get(2));
        P3rightcommand=new RightCommand(controller.getPlayers().get(2));
        P4upcommand=new UpCommand(controller.getPlayers().get(3));
        P4downcommand=new DownCommand(controller.getPlayers().get(3));
        P4leftcommand=new LeftCommand(controller.getPlayers().get(3));
        P4rightcommand=new RightCommand(controller.getPlayers().get(3));
        invoker.setCommand(0,P1upcommand,P1downcommand,P1leftcommand,P1rightcommand);
        invoker.setCommand(1,P2upcommand,P2downcommand,P2leftcommand,P2rightcommand);
        invoker.setCommand(2,P3upcommand,P3downcommand,P3leftcommand,P3rightcommand);
        invoker.setCommand(3,P4upcommand,P4downcommand,P4leftcommand,P4rightcommand);
        /*
        upCommand = new UpCommand(controller.getPlayers().get(0));
        downCmd = new DownCommand(controller.getPlayers().get(0));
        rightCmd = new RightCommand(controller.getPlayers().get(0));
        leftCmd = new LeftCommand(controller.getPlayers().get(0));
        invoker.setUpCommand(upCommand);
        invoker.setDownCommand(downCmd);
        invoker.setRightCommand(rightCmd);
        invoker.setLeftCommand(leftCmd);
        */
    }
}
