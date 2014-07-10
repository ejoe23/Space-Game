package GameObjects;

import com.badlogic.gdx.math.Vector2;

public class Background {
	
	private Vector2 posistion;
	private Vector2 velocity;
	private int width,height;
	
	
	
	public Background(float x,float y, int width, int height,int scrollSpeed)
	{
		posistion = new Vector2(x,y);
		this.width = width;
		this.height = height;
		velocity = new Vector2(0,scrollSpeed);//move in the y direction
	}
	
	public void reset()
	{
		posistion.y = -300;
	}
	
	public void update(float delta)
	{
		posistion.add(velocity.cpy().scl(delta));
		if(posistion.y > 300)
		{
			reset();
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
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}
	

}
