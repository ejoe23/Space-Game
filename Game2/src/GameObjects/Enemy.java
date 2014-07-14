package GameObjects;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Enemy {
	
	int height,width;
	private Vector2 posistion;
	private Vector2 velocity;
	private boolean isAlive;
	private int movingSpeed;
	private Rectangle boundingRect;
	private Circle boundingCircle;//hit markers
	private Circle boundingCircle2;
    Random rand = new Random();
	private int shootCounter;
	private int counter;
	private ArrayList<EnemyBullet> enemyBullets = new ArrayList<EnemyBullet>();//arraylist of enemy bullets
	
	
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
		shootCounter = rand.nextInt(100) + 20;
		counter = 0;
		movingSpeed = 2;
	}
	
	public void update(float delta)
	{
		posistion.x += movingSpeed;
		boundingRect.set(posistion.x + 10,posistion.y + 20,20,20);
		boundingCircle.set(posistion.x + 5,posistion.y + 11,5);
		boundingCircle2.set(posistion.x + 25,posistion.y + 11,5);
		if(posistion.x > 410)//switch directions
		{
			movingSpeed = -movingSpeed;
			
		}
		
		if(posistion.x < 0)
		{
			movingSpeed = rand.nextInt(3) + 1;
			
		}
		
		if(counter == shootCounter)//the enemy should shoot
		{
			fire();
			shootCounter = rand.nextInt(100) + 20;
			counter = 0;
		}
		else
		{
			counter++;
		}
	}
	
	public void fire()
	{
		EnemyBullet b = new EnemyBullet(posistion.x + 10,posistion.y);
		enemyBullets.add(b);//add bullet to array list
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
	
	public ArrayList getEnemyBullets()
	{
		return enemyBullets;
	}

}
