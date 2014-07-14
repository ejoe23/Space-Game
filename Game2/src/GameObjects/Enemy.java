package GameObjects;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Enemy {
	
	int height,width;
	private Vector2 posistion;
	private Vector2 velocity;
	private boolean isAlive;
	private int movingSpeed = 1;
	private Rectangle boundingRect;
	private Circle boundingCircle;//hit markers
	private Circle boundingCircle2;
	
	
	public Enemy(float x, float y, int width, int height)
	{
		this.width = width;
		this.height = height;
		posistion = new Vector2(x,y);
		velocity = new Vector2(0,0);
		isAlive = true;
		boundingRect = new Rectangle();
		boundingCircle = new Circle();
		boundingCircle2 = new Circle();
	}
	
	public void update(float delta)
	{
		posistion.x += movingSpeed;
		boundingRect.set(posistion.x + 10,posistion.y + 20,20,20);
		boundingCircle.set(posistion.x + 5,posistion.y + 11,5);
		boundingCircle2.set(posistion.x + 25,posistion.y + 11,5);
		if(posistion.x > 300)//switch directions
		{
			movingSpeed = -1;
		}
		
		if(posistion.x < 0)
		{
			movingSpeed = 1;
		}
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
	public Rectangle getBoundingRect()
	{
		return boundingRect;
	}
	public Circle getBoundingCircle()
	{
		return boundingCircle;
	}
	public Circle getBoundingCircle2()
	{
		return boundingCircle2;
	}

}
