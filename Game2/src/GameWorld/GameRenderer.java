package GameWorld;

import java.util.ArrayList;

import GameObjects.Bullet;
import GameObjects.Enemy;
import GameObjects.Ship;
import GameObjects.Background;
import Helpers.AssetLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameRenderer {

    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batch;
    private Ship ship;
    private TextureRegion character;
    private Texture space;
    private Texture enemyShip;
    private Background background;
    private Background secondBackground;
    private ArrayList bullets;
    private Enemy enemy;
    public GameRenderer(GameWorld world) {
        myWorld = world;
        ship = myWorld.getShip();//set ship
        enemy = myWorld.getEnemy();
        background = myWorld.getBackground();//set background
        secondBackground = myWorld.getSecondBackground();
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 450, 300);//450 300
        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        character = AssetLoader.character;
        space = AssetLoader.space;
        enemyShip = AssetLoader.enemy;
        
    }
    
    
    public void drawFire(float runTime)//draw the fire
    {
    	
    	if(ship.isRotatingRight)
        {
        	batch.draw(AssetLoader.Flames.getKeyFrame(runTime), ship.getX()-5, ship.getY() + 50, 20, 20,  15, 20, 1, 1, ship.getRotation());
        }
        
        else if(ship.isRotatingLeft)
        {
        	batch.draw(AssetLoader.Flames.getKeyFrame(runTime), ship.getX()+21, ship.getY() + 45, 20, 20,  15, 20, 1, 1, ship.getRotation());
        }
        
        else
        {
        	batch.draw(AssetLoader.Flames.getKeyFrame(runTime), ship.getX()+9, ship.getY() + 50, 15, 20);
        }
    	
    }
    
    public void drawBackground()
    {
    	batch.draw(space,background.getX(),background.getY(),background.getWidth(),background.getHeight());
        batch.draw(space,secondBackground.getX(),secondBackground.getY(),secondBackground.getWidth(),secondBackground.getHeight());
    }
    
    
    public void render(float runTime) {
    	bullets = ship.getBullets();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        batch.begin();
        drawBackground();
        drawFire(runTime);
        batch.draw(character, ship.getX(), ship.getY(), ship.getWidth() / 2.0f, ship.getHeight() / 2.0f,  ship.getWidth(), ship.getHeight(), 1, 1, ship.getRotation());
        batch.draw(enemyShip,enemy.getX(),enemy.getY(),enemy.getWidth(),enemy.getHeight());
        batch.end();
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(1, 0, 0, 0);
        for(int i = 0; i < bullets.size();i++)//draw bullets
        {
        	Bullet b = (Bullet)bullets.get(i);
        	shapeRenderer.rect(b.getX(),b.getY(),5,10);
        }
        shapeRenderer.end();
     
    }

}