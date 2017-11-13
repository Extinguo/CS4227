package monster;

import gameobjects.I_GameObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import visitor.IVisitable;
import visitor.IVisitor;
import java.io.Serializable;

public class Enemy implements IVisitable, Serializable, I_GameObject {

    private EnemyIntelligentMovement enemyIntelligentMovement;
    Color color = Color.red;
    Rectangle me;

    public Enemy(int x, int y) {
        me = new Rectangle(x, y, 24, 24);
    }

    public void setEnemyIntelligentMovement(EnemyIntelligentMovement enemyIntelligentMovement) {
        this.enemyIntelligentMovement = enemyIntelligentMovement;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(me.x, me.y, me.width, me.height);
    }

    @Override
    public void setColor(Color c) {
        this.color = c;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Rectangle getBounds() {
        return me;
    }

    public void tick() {
        this.enemyIntelligentMovement.tick();
    }

}
