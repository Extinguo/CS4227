package MoveStrategy;

import GameObjects.Helper;
import GameObjects.Level;
import GameObjects.Player;

public class UpCommand implements Command {

    private Player player = null;

    public UpCommand(Player player){
        this.player = player;
    }
    @Override
    public void execute() {
        player.setDirectionStatus(Helper.Direction.up, true);
    }

    @Override
    public void undo() {
        player.setDirectionStatus(Helper.Direction.up, false);
    }

}