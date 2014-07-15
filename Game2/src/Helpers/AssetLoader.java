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
	public static Animation shipDie;
	public static Texture space;
	public static Sound shoot;
	public static Sound enemyShoot;
	public static Sound explosionSound;
	public static Texture enemy;
	public static BitmapFont font;
	public static Texture missle;
	public static Texture explosion;
	public static TextureRegion explosion1,explosion2,explosion3,explosion4,explosion5;
	
	
	
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
		explosionSound = Gdx.audio.newSound(Gdx.files.internal("data/explosionsound.wav"));
		enemyShoot = Gdx.audio.newSound(Gdx.files.internal("data/enemyShoot.wav"));
		enemy = new Texture("data/enemy.png");
		missle = new Texture("data/missle.png");
		//explosion
		explosion = new Texture("data/GrenadeExplosion.png");
		explosion1 = new TextureRegion(explosion,2,28,47,75);
		explosion1.flip(false, true);
		explosion2 = new TextureRegion(explosion,49,4,51,98);
		explosion2.flip(false, true);
		explosion3 = new TextureRegion(explosion,101,3,51,98);
		explosion3.flip(false, true);
		explosion4 = new TextureRegion(explosion,151,7,49,94);
		explosion4.flip(false, true);
		explosion5 = new TextureRegion(explosion,201,1,50,104);
		explosion5.flip(false, true);
		TextureRegion[] explosions = {explosion1,explosion2,explosion3,explosion3,explosion4,explosion5};
		shipDie = new Animation(0.06f,explosions);
		shipDie.setPlayMode(Animation.LOOP_PINGPONG);
		
	}
	
	
	public static void dispose()
	{
		font.dispose();
		texture.dispose();
		fire.dispose();
		space.dispose();
		enemy.dispose();
		missle.dispose();
		explosion.dispose();
	}

}
