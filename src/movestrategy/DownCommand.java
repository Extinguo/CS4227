package movestrategy;

import gameobjects.Helper;
import player.Player;

public class DownCommand implements Command {

    private Player player = null;

    public DownCommand(Player player){
        this.player = player;
    }
    @Override
    public void execute() {
        player.setDirectionStatus(Helper.Direction.DOWN, true);
    }
    
    @Override
    public void undo() {
        player.setDirectionStatus(Helper.Direction.DOWN, false);
    }

}
