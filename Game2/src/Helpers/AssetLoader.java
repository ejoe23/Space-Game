package Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	
	public static Texture texture;
	public static TextureRegion character;
	public static TextureRegion fire1;
	public static TextureRegion fire2;
	public static TextureRegion fire3;
	public static TextureRegion fire4;
	public static Texture fire;
	public static Animation Flames;
	public static Texture space;
	public static Sound shoot;
	public static Texture enemy;
	public static BitmapFont font;
	public static Texture missle;
	
	
	
	public static void load()
	
	{
		font = new BitmapFont(Gdx.files.internal("data/text.fnt"));
		font.setScale(.25f, -.25f);
		texture = new Texture("data/ship.png");
		fire = new Texture("data/fire.png");
		character = new TextureRegion(texture,0,0,128,256);
		character.flip(true, true);
		fire1 = new TextureRegion(fire,22,70,112,46);
		fire2 = new TextureRegion(fire,153,67,90,47);
		fire3 = new TextureRegion(fire,280,66,92,49);
		fire4 = new TextureRegion(fire,407,61,92,56);
		TextureRegion[] flames = {fire1,fire2,fire3,fire4};
		Flames = new Animation(0.06f,flames);
		Flames.setPlayMode(Animation.LOOP_PINGPONG);
		space = new Texture("data/space.jpg");
		shoot = Gdx.audio.newSound(Gdx.files.internal("data/shoot.wav"));
		enemy = new Texture("data/enemy.png");
		missle = new Texture("data/missle.png");
		
	}
	
	
	public static void dispose()
	{
		font.dispose();
		texture.dispose();
		fire.dispose();
		space.dispose();
		enemy.dispose();
		missle.dispose();
	}

}
