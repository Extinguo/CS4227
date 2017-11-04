
package visitor2;

import java.awt.Color;

import gui2.View;
import gameobjects2.GameObject;
import monster2.Enemy;
import player2.Player;

public class Theme2 implements IVisitor {

	public void visit(Enemy o) {
		o.setColor(Color.blue);
	}

	public void visit(GameObject o) {
		o.setColor(Color.BLACK);
		
	}

	public void visit(Player o) {
		o.setColor(Color.GREEN);
	}
	
	public void visit(View o) {
		o.setBackgroundColor(Color.RED);
	}
	

}
