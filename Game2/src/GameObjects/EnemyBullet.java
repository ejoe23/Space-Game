package GameObjects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class EnemyBullet {
	
 private Vector2 posistion;
 private Vector2 velocity;
 private float x,y;
 private boolean visable;
 private Rectangle rect;
 
 	public EnemyBullet(float x, float y)
 	{
 		posistion = new Vector2(x,y);
 		velocity = new Vector2(0,150);
 		visable = true;
 		rect = new Rectangle();
 	}
 	
 	public void update(float delta)
 	{
 		
 		posistion.add(velocity.cpy().scl(delta));
 		if(posistion.y > 300 )//moves off screen
 		{
 			visable = false;
 		}
 		rect.set(posistion.x,posistion.y,5,10);
 	}
 	
 	public boolean collides(Ship ship)
 	{
 		return(Intersector.overlaps(rect, ship.getShipBoundingRectangle()));
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
	
 	public void setVisable(boolean v)
 	{
 		visable = v;
 	}

}
