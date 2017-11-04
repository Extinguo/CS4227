package movestrategy2;

import gameobjects2.Helper;
import player2.Player;

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
