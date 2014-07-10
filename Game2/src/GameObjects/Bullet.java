package GameObjects;

import com.badlogic.gdx.math.Vector2;

public class Bullet {
	
	private Vector2 posistion;
	private Vector2 velocity;
	private float x,y;
	private boolean visable;
	
	public Bullet(float x, float y)
	{
		posistion = new Vector2(x,y);
		velocity = new Vector2(0,-100);
		visable = true;
		
	}

	public void update(float delta)
	{
		posistion.add(velocity.cpy().scl(delta));
		if(posistion.y < 0)//if it moves off screen
		{
			System.out.println("removing");
			visable = false;
		}
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
