package MoveStrategy;

import GameObjects.Helper;
import GameObjects.Player;

public class DownCommand implements Command {

    private Player player = null;

    public DownCommand(Player player){
        this.player = player;
    }
    @Override
    public void execute() {
        player.setDirectionStatus(Helper.Direction.down, true);
    }
    
    @Override
    public void undo() {
        player.setDirectionStatus(Helper.Direction.down, false);
    }

}
