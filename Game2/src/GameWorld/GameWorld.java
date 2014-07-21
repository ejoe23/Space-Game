package GameWorld;

import java.util.ArrayList;

import GameObjects.Background;
import GameObjects.Bullet;
import GameObjects.Enemy;
import GameObjects.EnemyBullet;
import GameObjects.Ship;
import Helpers.AssetLoader;

import com.badlogic.gdx.math.Rectangle;

public class GameWorld {
	
	private Ship ship;
	private Background background;
	private Background secondBackground;
	private ArrayList bullets;
	private ArrayList enemyBullets;
	private Enemy enemy;
	private int shots;
	private float timePassed;
	private int score;
	private float timeLastScored;//if this time is too low dont add score 2 bullets can hit the same guy

	
	public GameWorld()
	{
		ship = new Ship(200,235,32,64);
		background = new Background(0,0,450,300,10);
		secondBackground = new Background(0,background.getY()-300,450,300,10);//make a second background to scroll
		enemy = new Enemy(200,50,30,30);
		timePassed = 0;
		score = 0;
		
	}
	
	
	public void update(float delta)
	{
		
		if(ship.getAlive())
		{
			ship.update(delta);
		}
		
		if(enemy.isAlive())//if the enemy is alive keep updating
		{
			enemy.update(delta);
		}
		if(enemy.isAlive() == false)
		{
			timePassed +=delta;//wait 2 seconds till reset the enemy
			if(timePassed > 2)
			{
				enemy.reset();
				timePassed = 0;
			}
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
		
		shots = 3 - bullets.size();//set a number of shots to be shown	
		
		for(int i = 0; i < bullets.size(); i++)
		{
			Bullet b = (Bullet) bullets.get(i);//draw the bullet object out of the arraylist
			if(b.getVisable() == true)
			{
				timeLastScored += delta;
				b.update(delta);
				if(b.collides(enemy))
				{
					enemy.setAlive(false);//kill enemy
					bullets.remove(i);//remove the bullet if it hits
					if(timeLastScored > 1)//only if there is a 1 second delay between hits
					{
						score++;//add one to the score
						timeLastScored = 0;
					}
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
				if(b.collides(ship))
				{
					ship.setAlive(false);
					enemyBullets.remove(i);
					AssetLoader.explosionSound.play();//play explosion
				}
			}
			else
			{
				enemyBullets.remove(i);
				
			}
		}
		
	}
	
	public void reset()
	{
		score = 0;
		ship.reset(200,235);
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
	
	public int getScore()
	{
		return score;
	}
	
	

}
