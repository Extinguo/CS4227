package MoveStrategy;

import GameObjects.Helper;
import GameObjects.Player;

public class RightCommand implements Command {

    private Player player = null;

    public RightCommand(Player player){
        this.player = player;
    }
    @Override
    public void execute() {
        player.setDirectionStatus(Helper.Direction.right, true);
    }

    @Override
    public void undo() {
        player.setDirectionStatus(Helper.Direction.right, false);
    }

}