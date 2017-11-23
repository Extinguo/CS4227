package movestrategy;

import gameobjects.Helper;
import player.Player;

public class DownCommand implements Command {

    private Player player = null;

    public DownCommand(Player player){
        this.player = player;
    }

    /**
     * invoking an action which will be execute when the button pushed
     */
    @Override
    public void execute() {
        player.setDirectionStatus(Helper.Direction.DOWN, true);
    }

    /**
     * invoking an action which will be execute when the button Released
     */
    @Override
    public void undo() {
        player.setDirectionStatus(Helper.Direction.DOWN, false);
    }

}
