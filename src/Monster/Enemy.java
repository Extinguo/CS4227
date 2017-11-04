/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monster;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Visitor.IVisitable;
import Visitor.IVisitor;

/**
 * sonarcube
 *
 * @author Magd
 */
public class Enemy implements IVisitable  {
    private EnemyIntelligentMovement enemyIntelligentMovement;
    Color color = Color.red;
    public void setEnemyIntelligentMovement(EnemyIntelligentMovement enemyIntelligentMovement)
    {
        this.enemyIntelligentMovement=enemyIntelligentMovement;
    }
    Rectangle me;

    public Enemy(int x, int y) {
        me = new Rectangle(x, y, 24, 24);
    }
    
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(me.x, me.y, me.width, me.height);
    }
    public Rectangle getMe()
    {
        return me;
    }
    public void tick() {
        this.enemyIntelligentMovement.tick();
    }
    
    public void setColor(Color c) {
		this.color = c;
    }

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);       
	}
    
}
