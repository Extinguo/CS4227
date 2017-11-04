package Visitor;

import java.awt.Color;

import GUI.View;
import GameObjects.GameObject;
import Monster.Enemy;
import Player.Player;

public class Theme2 implements IVisitor {

	public void visit(Enemy o) {
		// TODO Auto-generated method stub
		o.setColor(Color.blue);
	}

	public void visit(GameObject o) {
		// TODO Auto-generated method stub
		o.setColor(Color.BLACK);
		
	}

	public void visit(Player o) {
		// TODO Auto-generated method stub
		o.setColor(Color.GREEN);
	}
	
	public void visit(View o) {
		o.setBackgroundColor(Color.RED);
	}
	

}
