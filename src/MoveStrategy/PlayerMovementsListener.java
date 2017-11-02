/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveStrategy;

import GUI.Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;

/**
 *
 * @author Magd
 */
public class PlayerMovementsListener implements KeyListener {

    Controller controller;
    Invoker invoker;

    Command moveCommands[]=new Command[4];

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
        if(moveCommands[0] == null) {
            initialiseCommands();
        }
        
        switch (e.getKeyCode()) {
            //player 1
            case KeyEvent.VK_UP:
                //invoker.up();
                if(controller.getPlayers().get(0)!=null)
                 invoker.upPressed(0);
                break;
            case KeyEvent.VK_DOWN:
                //invoker.down();
                if(controller.getPlayers().get(0)!=null)
                 invoker.downPressed(0);
                break;
            case KeyEvent.VK_RIGHT:
                //invoker.right();
                if(controller.getPlayers().get(0)!=null)
                 invoker.rightPressed(0);
                break;
            case KeyEvent.VK_LEFT:
                //invoker.left();
                if(controller.getPlayers().get(0)!=null)
                 invoker.leftPressed(0);
                break;
                //player 2
            case KeyEvent.VK_W:
                if(controller.getPlayers().size()>=2)
                 invoker.upPressed(1);
                break;
            case KeyEvent.VK_S:
                if(controller.getPlayers().size()>=2)
                 invoker.downPressed(1);
                break;
            case KeyEvent.VK_A:
                if(controller.getPlayers().size()>=2)
                 invoker.leftPressed(1);
                break;
            case KeyEvent.VK_D:
                if(controller.getPlayers().size()>=2)
                 invoker.rightPressed(1);
                break;
                //player 3
            case KeyEvent.VK_I:
                if(controller.getPlayers().size()>=3)
                    invoker.upPressed(2);
                break;
            case KeyEvent.VK_K:
                if(controller.getPlayers().size()>=3)
                    invoker.downPressed(2);
                break;
            case KeyEvent.VK_J:
                if(controller.getPlayers().size()>=3)
                   invoker.leftPressed(2);
                break;
            case KeyEvent.VK_L:
                if(controller.getPlayers().size()>=3)
                  invoker.rightPressed(2);
                break;
            case KeyEvent.VK_T:
                if(controller.getPlayers().size()>=4)
                 invoker.upPressed(3);
                break;
            case KeyEvent.VK_G:
                if(controller.getPlayers().size()>=4)
                 invoker.downPressed(3);
                break;
            case KeyEvent.VK_F:
                if(controller.getPlayers().size()>=4)
                    invoker.leftPressed(3);
                break;
            case KeyEvent.VK_H:
                if(controller.getPlayers().size()>=4)
                  invoker.rightPressed(3);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(moveCommands[0] == null) {
            initialiseCommands();
        }
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                //invoker.undoUp();
                if(controller.getPlayers().get(0)!=null)
                 invoker.undoupPressed(0);
                break;
            case KeyEvent.VK_DOWN:
                //invoker.undoDown();
                if(controller.getPlayers().get(0)!=null)
                  invoker.undodownPressed(0);
                break;
            case KeyEvent.VK_RIGHT:
                //invoker.undoRight();
                if(controller.getPlayers().get(0)!=null)
                  invoker.undorightpressed(0);
                break;
            case KeyEvent.VK_LEFT:
                //invoker.undoLeft();
                if(controller.getPlayers().get(0)!=null)
                  invoker.undoleftPressed(0);
                break;
            case KeyEvent.VK_W:
                if(controller.getPlayers().size()>=2)
                  invoker.undoupPressed(1);
                break;
            case KeyEvent.VK_S:
                if(controller.getPlayers().size()>=2)
                    invoker.undodownPressed(1);
                break;
            case KeyEvent.VK_A:
                if(controller.getPlayers().size()>=2)
                   invoker.undoleftPressed(1);
                break;
            case KeyEvent.VK_D:
                if(controller.getPlayers().size()>=2)
                   invoker.undorightpressed(1);
            case KeyEvent.VK_I:
                if(controller.getPlayers().size()>=3)
                   invoker.undoupPressed(2);
                break;
            case KeyEvent.VK_K:
                if(controller.getPlayers().size()>=3)
                   invoker.undodownPressed(2);
                break;
            case KeyEvent.VK_J:
                if(controller.getPlayers().size()>=3)
                   invoker.undoleftPressed(2);
                break;
            case KeyEvent.VK_L:
                if(controller.getPlayers().size()>=3)
                  invoker.undorightpressed(2);
                break;
            case KeyEvent.VK_T:
                if(controller.getPlayers().size()>=4)
                  invoker.undoupPressed(3);
                break;
            case KeyEvent.VK_G:
                if(controller.getPlayers().size()>=4)
                  invoker.undodownPressed(3);
                break;
            case KeyEvent.VK_F:
                if(controller.getPlayers().size()>=4)
                  invoker.undoleftPressed(3);
                break;
            case KeyEvent.VK_H:
                if(controller.getPlayers().size()>=4)
                  invoker.undorightpressed(3);
                break;
            default:
                break;
        }
    }
    
    private void initialiseCommands() {
        for(int i=0;i<controller.getPlayers().size();i++)
        {
            moveCommands[0]=new UpCommand(controller.getPlayers().get(i));
            moveCommands[1]=new DownCommand(controller.getPlayers().get(i));
            moveCommands[2]=new LeftCommand(controller.getPlayers().get(i));
            moveCommands[3]=new RightCommand(controller.getPlayers().get(i));
            invoker.setCommand(i,moveCommands[0],moveCommands[1],moveCommands[2],moveCommands[3]);
        }
        System.out.println("The size of players "+controller.getPlayers().size());
    }
}
