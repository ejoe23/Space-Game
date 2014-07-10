package GameObjects;

import com.badlogic.gdx.math.Vector2;

public class Enemy {
	
	int height,width;
	private Vector2 posistion;
	private Vector2 velocity;
	private boolean isAlive;
	
	public Enemy(float x, float y, int width, int height)
	{
		this.width = width;
		this.height = height;
		posistion = new Vector2(x,y);
		velocity = new Vector2(0,0);
		isAlive = true;
	}
	
	public void update(float delta)
	{
		
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getWidth()
	{
		return width;
	}
	public float getX()
	{
		return posistion.x;
	}
	public float getY()
	{
		return posistion.y;
	}
	public boolean isAlive()
	{
		return isAlive;
	}
	public void setAlive(boolean isAlive)
	{
		this.isAlive = isAlive;
	}

}
