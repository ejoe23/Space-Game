package Screens;

import GameObjects.Ship;
import GameWorld.GameRenderer;
import GameWorld.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import Helpers.InputHandler;

public class GameScreen implements Screen {
	private GameWorld world;
	private GameRenderer renderer;
	private InputHandler handler;
	private Ship ship;
	private float runTime = 0;

	public GameScreen()
	{
		world = new GameWorld();
		renderer = new GameRenderer(world);
		handler = new InputHandler(world);
		Gdx.input.setInputProcessor(handler);
		ship = world.getShip();
		
	}
	
	
	
	@Override
	public void render(float delta) 
	{
		ship.resetRotation(); 
		runTime += delta;
		if(handler.holdingRight)//if the keys are being held run the methods. Run this here because the hander is here
		{
			ship.onClickRight();
		}
		
		else if(handler.holdingLeft)
		{
			ship.onClickLeft();
		}
		
		world.update(delta);//update everything
		renderer.render(runTime);//draw everything
		
	}

	@Override
	public void resize(int width, int height) {
		System.out.println("resize Called");
		
	}

	@Override
	public void show() {
		System.out.println("show Called");
		
	}

	@Override
	public void hide() {
		System.out.println("hide Called");
		
	}

	@Override
	public void pause() {
		System.out.println("pause Called");
		
	}

	@Override
	public void resume() {
		System.out.println("resume Called");
		
	}

	@Override
	public void dispose() {
		System.out.println("dispose Called");
		
	}

}
