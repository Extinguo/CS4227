package visitor;

import gui.View;
import gameobjects.GameObject;
import monster.Enemy;
import player.Player;

public interface IVisitor {

    void visit(Enemy o);
    void visit(GameObject o);
    void visit(Player o);
    void visit(View o);
    
}

