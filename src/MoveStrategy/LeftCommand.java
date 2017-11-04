package MoveStrategy;

import GameObjects.Helper;
import Player.Player;

public class LeftCommand implements Command {

    private Player player = null;

    public LeftCommand(Player player){
        this.player = player;
    }
    @Override
    public void execute() {
        player.setDirectionStatus(Helper.Direction.left, true);
    }

    @Override
    public void undo() {
        player.setDirectionStatus(Helper.Direction.left, false);
    }

}