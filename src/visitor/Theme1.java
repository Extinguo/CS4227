package visitor;

import java.awt.Color;

import gui.View;
import gameobjects.GameObject;
import monster.Enemy;
import player.Player;

public class Theme1 implements IVisitor {

    public void visit(Enemy o) {
        o.setColor(Color.RED);
    }

    public void visit(GameObject o) {
        o.setColor(Color.BLUE);

    }

    public void visit(Player o) {
        o.setColor(Color.yellow);
    }
    public void visit(View o) {
        o.setBackgroundColor(Color.BLACK);
    }

}
