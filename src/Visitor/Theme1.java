package Visitor;

import java.awt.Color;

import GUI.View;
import GameObjects.GameObject;
import Monster.Enemy;
import Player.Player;

public class Theme1 implements IVisitor {

	public void visit(Enemy o) {
		// TODO Auto-generated method stub
		o.setColor(Color.RED);
	}

	public void visit(GameObject o) {
		// TODO Auto-generated method stub
		o.setColor(Color.BLUE);
		
	}

	public void visit(Player o) {
		// TODO Auto-generated method stub
		o.setColor(Color.yellow);
	}
	
	public void visit(View o) {
		o.setBackgroundColor(Color.BLACK);
	}
	
}
