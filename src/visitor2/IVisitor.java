package visitor2;

import gui2.View;
import gameobjects2.GameObject;
import monster2.Enemy;
import player2.Player;

public interface IVisitor {

    void visit(Enemy o);
    void visit(GameObject o);
    void visit(Player o);
    void visit(View o);
    
}

