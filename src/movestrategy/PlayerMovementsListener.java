package movestrategy;

import gui.Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;


public class PlayerMovementsListener implements KeyListener {

    Controller controller;
    Invoker invoker;

    Command[] moveCommands = new Command[4];

    public PlayerMovementsListener(Controller controller) {
        this.controller = controller;
        invoker = new Invoker();
        if(controller.getPlayers() != null ) {
            initialiseCommands();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        /*
        Do nothing, because we want to have the player move as long as a key is pressed.
        Typing would not be sufficient. So keyPressed and keyReleased are implemented.
        */
    }


    /**
     * when the button pushed the operation execute
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(moveCommands[0] == null) {
            initialiseCommands();
        }
        
        switch (e.getKeyCode()) {
            //player 1
            case KeyEvent.VK_UP:
                if(controller.getPlayers().get(0).getAvaliable())
                 invoker.upPressed(0);
                break;
            case KeyEvent.VK_DOWN:
                if(controller.getPlayers().get(0).getAvaliable())
                 invoker.downPressed(0);
                break;
            case KeyEvent.VK_RIGHT:
                if(controller.getPlayers().get(0).getAvaliable())
                 invoker.rightPressed(0);
                break;
            case KeyEvent.VK_LEFT:
                if(controller.getPlayers().get(0).getAvaliable())
                 invoker.leftPressed(0);
                break;
                //player 2
            case KeyEvent.VK_W:
                if(controller.getPlayers().get(1).getAvaliable())
                 invoker.upPressed(1);
                break;
            case KeyEvent.VK_S:
                if(controller.getPlayers().get(1).getAvaliable())
                 invoker.downPressed(1);
                break;
            case KeyEvent.VK_A:
                if(controller.getPlayers().get(1).getAvaliable())
                 invoker.leftPressed(1);
                break;
            case KeyEvent.VK_D:
                if(controller.getPlayers().get(1).getAvaliable())
                 invoker.rightPressed(1);
                break;
                //player 3
            case KeyEvent.VK_I:
                if(controller.getPlayers().get(2).getAvaliable())
                    invoker.upPressed(2);
                break;
            case KeyEvent.VK_K:
                if(controller.getPlayers().get(2).getAvaliable())
                    invoker.downPressed(2);
                break;
            case KeyEvent.VK_J:
                if(controller.getPlayers().get(2).getAvaliable())
                   invoker.leftPressed(2);
                break;
            case KeyEvent.VK_L:
                if(controller.getPlayers().get(2).getAvaliable())
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

    /**
     * when the button Released the operation undo
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if(moveCommands[0] == null) {
            initialiseCommands();
        }
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if(controller.getPlayers().get(0).getAvaliable())
                 invoker.undoupPressed(0);
                break;
            case KeyEvent.VK_DOWN:
                if(controller.getPlayers().get(0).getAvaliable())
                  invoker.undodownPressed(0);
                break;
            case KeyEvent.VK_RIGHT:
                if(controller.getPlayers().get(0).getAvaliable())
                  invoker.undorightpressed(0);
                break;
            case KeyEvent.VK_LEFT:
                if(controller.getPlayers().get(0).getAvaliable())
                  invoker.undoleftPressed(0);
                break;
            case KeyEvent.VK_W:
                if(controller.getPlayers().get(1).getAvaliable())
                  invoker.undoupPressed(1);
                break;
            case KeyEvent.VK_S:
                if(controller.getPlayers().get(1).getAvaliable())
                    invoker.undodownPressed(1);
                break;
            case KeyEvent.VK_A:
                if(controller.getPlayers().get(1).getAvaliable())
                   invoker.undoleftPressed(1);
                break;
            case KeyEvent.VK_D:
                if(controller.getPlayers().get(1).getAvaliable())
                   invoker.undorightpressed(1);
                break;
            case KeyEvent.VK_I:
                if(controller.getPlayers().get(2).getAvaliable())
                   invoker.undoupPressed(2);
                break;
            case KeyEvent.VK_K:
                if(controller.getPlayers().get(2).getAvaliable())
                   invoker.undodownPressed(2);
                break;
            case KeyEvent.VK_J:
                if(controller.getPlayers().get(2).getAvaliable())
                   invoker.undoleftPressed(2);
                break;
            case KeyEvent.VK_L:
                if(controller.getPlayers().get(2).getAvaliable())
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
        java.util.logging.Logger.getLogger(
                PlayerMovementsListener.class.getName()).log(Level.INFO, "The number of Players: " + controller.getPlayers().size());
    }
}
