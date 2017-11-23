package movestrategy;

import gameobjects.Helper;
import player.Player;

public class UpCommand implements Command {

    private Player player = null;

    public UpCommand(Player player){
        this.player = player;
    }

    /**
     * invoking an action which will be execute when the button pushed
     */
    @Override
    public void execute() {
        player.setDirectionStatus(Helper.Direction.UP, true);
    }

    /**
     * invoking an action which will be execute when the button Released
     */
    @Override
    public void undo() {
        player.setDirectionStatus(Helper.Direction.UP, false);
    }

}