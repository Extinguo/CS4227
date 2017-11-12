package visitor;

import gui.View;
import gameobjects.GameObject;
import player.Player;
import monster.*;

/**
*
* @author Yann Mace
*/

public interface IVisitor {

	/**
     * Use to implement the operation of each themes
     */
    void visit(Enemy o);
    void visit(GameObject o);
    void visit(Player o);
    void visit(View o);
    
}

