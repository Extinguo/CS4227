package movestrategy2;

public class Invoker {

    private Command[] upcommands;
    private Command[] downcommands;
    private Command[] leftcommands;
    private Command[] rightcommands;

    public Invoker()
    {
        upcommands=new Command[4];
        downcommands=new Command[4];
        leftcommands=new Command[4];
        rightcommands=new Command[4];
    }

    public void setCommand(int slot, Command upCommand, Command downCommand,Command leftCommand,Command rightCommand)
    {
        upcommands[slot]=upCommand;
        downcommands[slot]=downCommand;
        leftcommands[slot]=leftCommand;
        rightcommands[slot]=rightCommand;
    }

    public void upPressed(int slot)
    {
        upcommands[slot].execute();
    }
    public void downPressed(int slot)
    {
        downcommands[slot].execute();
    }
    public void leftPressed(int slot)
    {
        leftcommands[slot].execute();
    }
    public void rightPressed(int slot)
    {
        rightcommands[slot].execute();
    }

    public void undoupPressed(int slot)
    {
        upcommands[slot].undo();
    }
    public void undodownPressed(int slot)
    {
        downcommands[slot].undo();
    }
    public void undoleftPressed(int slot)
    {
        leftcommands[slot].undo();
    }
    public void undorightpressed(int slot)
    {
        rightcommands[slot].undo();
    }
}   