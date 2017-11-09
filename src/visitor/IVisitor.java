package visitor;

import gui.View;
import gameobjects.GameObject;
import player.Player;
import monster.*;
public interface IVisitor {

    void visit(Enemy o);
    void visit(GameObject o);
    void visit(Player o);
    void visit(View o);
    
}

