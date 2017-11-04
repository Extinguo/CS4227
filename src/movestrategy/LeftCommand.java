package movestrategy;

import gameobjects.Helper;
import player.Player;

public class LeftCommand implements Command {

    private Player player = null;

    public LeftCommand(Player player){
        this.player = player;
    }
    @Override
    public void execute() {
        player.setDirectionStatus(Helper.Direction.LEFT, true);
    }

    @Override
    public void undo() {
        player.setDirectionStatus(Helper.Direction.LEFT, false);
    }

}