package movestrategy;

import gameobjects.Helper;
import player.Player;

public class RightCommand implements Command {

    private Player player = null;

    public RightCommand(Player player){
        this.player = player;
    }

    /**
     * invoking an action which will be execute when the button pushed
     */
    @Override
    public void execute() {
        player.setDirectionStatus(Helper.Direction.RIGHT, true);
    }

    /**
     * invoking an action which will be execute when the button Released
     */
    @Override
    public void undo() {
        player.setDirectionStatus(Helper.Direction.RIGHT, false);
    }

}