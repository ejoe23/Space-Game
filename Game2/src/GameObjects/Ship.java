package GameObjects;

import java.util.ArrayList;

import Helpers.AssetLoader;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Ship {
	
	private int width,height;
	private Vector2 posistion,velocity,acceleration;
	private float rotation;
	public boolean isRotatingRight = false;
	public boolean isRotatingLeft = false;
	private boolean isAlive;
	private Rectangle shipBoundingRect;
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();// array of bullets the the ship will shoot
	
	public Ship(float x, float y,int width,int height)
	{
		this.width = width;
		this.height = height;
		posistion = new Vector2(x,y);
		velocity = new Vector2(0,0);
		acceleration = new Vector2(0,0);//not moving
		shipBoundingRect = new Rectangle();
		isAlive = true;
	}
	
	
	public void update(float delta)
	{
		velocity.add(acceleration.cpy().scl(delta));//get new velocity
		posistion.add(velocity.cpy().scl(delta));//get new posistion
		shipBoundingRect.set(posistion.x + 10,posistion.y + 2,10,30);
		if(velocity.x > 100)
		{
			velocity.x = 100;
		}
		
		if(velocity.x < -100)
		{
			velocity.x = -100;
		}
		
		if(posistion.x < 0)
		{
			posistion.x = 0;
		}
		
		velocity.x = 0;
		
		
		
	}
	
	public void shoot()
	{
		if(bullets.size() < 3)
		{
		Bullet b = new Bullet(posistion.x + 13,posistion.y);//create new bullet
		bullets.add(b);//add bullet to the array list
		AssetLoader.shoot.play();
		}
	}
	
	public void resetRotation()
	{
		rotation = 0;
		isRotatingRight = false;
		isRotatingLeft = false;
	}
	
	public void onClickRight()
	{
		velocity.x = 100; 
		rotation = 20;
		isRotatingRight = true;
	}
	
	public void onClickLeft()
	{
		velocity.x = -100;
		rotation = -20;
		isRotatingLeft = true;
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
	public float getRotation()
	{
		return rotation;
	}
	public ArrayList getBullets()
	{
		return bullets;
	}
	
	public boolean getAlive()
	{
		return isAlive;
	}
	
	public void setAlive(boolean v)
	{
		isAlive = v;
	}
	
	public Rectangle getShipBoundingRectangle()
	{
		return shipBoundingRect;
	}
	
	
	

}
