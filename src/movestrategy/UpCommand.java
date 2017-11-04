package movestrategy;

import gameobjects.Helper;
import player.Player;

public class UpCommand implements Command {

    private Player player = null;

    public UpCommand(Player player){
        this.player = player;
    }
    @Override
    public void execute() {
        player.setDirectionStatus(Helper.Direction.UP, true);
    }

    @Override
    public void undo() {
        player.setDirectionStatus(Helper.Direction.UP, false);
    }

}