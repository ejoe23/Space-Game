package GameObjects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bullet {
	
	private Vector2 posistion;
	private Vector2 velocity;
	private float x,y;
	private boolean visable;
	private Rectangle rect;
	
	public Bullet(float x, float y)
	{
		posistion = new Vector2(x,y);
		velocity = new Vector2(0,-100);
		visable = true;
		rect = new Rectangle();//new bounding rectangle for bullet
		
	}

	public void update(float delta)
	{
		posistion.add(velocity.cpy().scl(delta));
		rect.set(posistion.x,posistion.y,5,10);//create the bounding rectangle to the same size as defined in gameRenderer
		if(posistion.y < 0)//if it moves off screen
		{
			visable = false;
		}
	}
	
	public boolean collides(Enemy enemy)//return true if the rect bullet hits any of the hit markers on the enemys
	{
		return(Intersector.overlaps(enemy.getBoundingRect(),rect)||
			   Intersector.overlaps(enemy.getBoundingCircle(), rect)||
			   Intersector.overlaps(enemy.getBoundingCircle2(), rect));
	}
	
	
	public float getX()
	{
		return posistion.x;
	}
	
	public float getY()
	{
		return posistion.y;
	}
	
	public boolean getVisable()
	{
		return visable;
	}
	
	public void setVisable(boolean visable)
	{
		this.visable = visable;
	}
	
	
	
	
}
