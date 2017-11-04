package movestrategy;

import gameobjects.Helper;
import player.Player;

public class RightCommand implements Command {

    private Player player = null;

    public RightCommand(Player player){
        this.player = player;
    }
    @Override
    public void execute() {
        player.setDirectionStatus(Helper.Direction.RIGHT, true);
    }

    @Override
    public void undo() {
        player.setDirectionStatus(Helper.Direction.RIGHT, false);
    }

}