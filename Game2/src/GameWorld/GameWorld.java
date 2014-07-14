package GameWorld;

import java.util.ArrayList;

import GameObjects.Background;
import GameObjects.Bullet;
import GameObjects.Enemy;
import GameObjects.Ship;

import com.badlogic.gdx.math.Rectangle;

public class GameWorld {
	
	private Ship ship;
	private Background background;
	private Background secondBackground;
	private ArrayList bullets;
	private Enemy enemy;
	
	public GameWorld()
	{
		ship = new Ship(200,235,32,64);
		background = new Background(0,0,450,300,10);
		secondBackground = new Background(0,background.getY()-300,450,300,10);//make a second background to scroll
		enemy = new Enemy(200,50,30,30);
	}
	
	
	public void update(float delta)
	{

		ship.update(delta);
		
		if(enemy.isAlive())//if the enemy is alive keep updating
		{
			enemy.update(delta);
		}
		
		bullets = ship.getBullets();//get all the bullets in the arraylist
		
		for(int i = 0; i < bullets.size(); i++)
		{
			Bullet b = (Bullet) bullets.get(i);
			if(b.getVisable() == true)
			{
				b.update(delta);
				if(b.collides(enemy))
				{
					enemy.setAlive(false);//kill enemy
					bullets.remove(i);//remove the bullet if it hits
				}
			}
			else//if its not visiable anymore remove it from the array list
			{
				bullets.remove(i);
				
			}
		}
		
		background.update(delta);//move space
		secondBackground.update(delta);
	}
	
	public Ship getShip()
	{
		return ship;
	}
	
	public Background getBackground()
	{
		return background;
	}
	
	public Background getSecondBackground()
	
	{
		return secondBackground;
	}
	
	public Enemy getEnemy()
	{
		return enemy;
	}
	
	

}
