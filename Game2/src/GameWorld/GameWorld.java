package GameWorld;

import java.util.ArrayList;

import GameObjects.Background;
import GameObjects.Bullet;
import GameObjects.Enemy;
import GameObjects.EnemyBullet;
import GameObjects.Ship;

import com.badlogic.gdx.math.Rectangle;

public class GameWorld {
	
	private Ship ship;
	private Background background;
	private Background secondBackground;
	private ArrayList bullets;
	private ArrayList enemyBullets;
	private Enemy enemy;
	private int shots;
	
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
		//update bullts
		updateShipBullets(delta);
		updateEnemyBullets(delta);
		background.update(delta);//move space
		secondBackground.update(delta);
		
	}
	
	
	public void updateShipBullets(float delta)
	{
		bullets = ship.getBullets();//get all the bullets in the arraylist
		
		shots = 5 - bullets.size();//set a number of shots to be shown	
		
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
	}
	
	public void updateEnemyBullets(float delta)
	{
		enemyBullets = enemy.getEnemyBullets();
		for(int i = 0; i < enemyBullets.size();i++)
		{
			EnemyBullet b = (EnemyBullet) enemyBullets.get(i);
			if(b.getVisable() == true)
			{
				b.update(delta);//update only if the bullet is still on the screen
			}
			else
			{
				enemyBullets.remove(i);
				
			}
		}
		
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
	
	public int getShots()
	{
		return shots;
	}
	
	

}
