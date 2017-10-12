package MoveStrategy;

public class Invoker {

    private Command upCommand;
    private Command downCommand;
    private Command leftCommand;
    private Command rightCommand;

    public void setUpCommand(Command upCommand) {
        this.upCommand = upCommand;
    }
    public void setDownCommand(Command downCommand) {
        this.downCommand = downCommand;
    }
    public void setLeftCommand(Command leftCommand) {
        this.leftCommand = leftCommand;
    }
    public void setRightCommand(Command rightCommand) {
        this.rightCommand = rightCommand;
    }

    public void up(){
        upCommand.execute();
    }

    public void down(){
        downCommand.execute();
    }

    public void left(){
        leftCommand.execute();
    }

    public void right(){
        rightCommand.execute();
    }
    
    public void undoUp() {
        upCommand.undo();
    }
    
    public void undoDown() {
        downCommand.undo();
    }
    
    public void undoLeft() {
        leftCommand.undo();
    }
    
    public void undoRight() {
        rightCommand.undo();
    }
}   