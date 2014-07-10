package Helpers;

import GameObjects.Ship;
import GameWorld.GameWorld;

import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor {
	
	public boolean holdingRight = false;//holding key
	public boolean holdingLeft = false;
	private Ship myShip;
	
	public InputHandler(GameWorld world)
	{
		myShip = world.getShip();
	}
	
	@Override
	public boolean keyDown(int keycode) {//key is being held
		
		if(keycode == 32 || keycode == 22)
		{
		  holdingRight = true;
		  return true;
		}
		
		else if(keycode == 21 || keycode == 29)
		{
			holdingLeft = true;
			return true;
		}
		
		else if(keycode == 62)//space bar is shoot
		{
			myShip.shoot();
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean keyUp(int keycode) {//key is no longer being held set the bool to false
		if(keycode == 32 || keycode == 22)
		{
		  holdingRight = false;
		  return true;
		}
		
		else if(keycode == 21 || keycode == 29)
		{
			holdingLeft = false;
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
