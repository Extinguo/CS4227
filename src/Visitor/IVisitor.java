package Visitor;

import GUI.View;
import GameObjects.GameObject;
import Monster.Enemy;
import Player.Player;

public interface IVisitor {

	void visit(Enemy o);
    void visit(GameObject o);
    void visit(Player o);
    void visit(View o);
}

