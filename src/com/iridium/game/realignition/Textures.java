package com.iridium.game.realignition;


import java.awt.image.BufferedImage;

public class Textures 
{
	public BufferedImageLoader loader= new BufferedImageLoader();
	
	public SpriteSheet terrain_sprite;
	public SpriteSheet newRoadSprite;
	public SpriteSheet lamboYSprite;
	public SpriteSheet lamboXSprite;
	public SpriteSheet lamboCornerSprite;
	
	public BufferedImage terrain_sprite_image = null;
	public BufferedImage lamboYSpriteImage = null;
	public BufferedImage lamboXSpriteImage = null;
	public BufferedImage lamboCornerImage = null;
	public BufferedImage gameLevel = null;
	public static BufferedImage tree = null;
	public static BufferedImage sea = null;
	
	public BufferedImage floor = null;
	public BufferedImage [] lambo = new BufferedImage[8];
	
	
	public Textures()
	{
		terrain_sprite_image = loader.loadImage("/game_textures.png");
		lamboYSpriteImage = loader.loadImage("/lamboYSprite.png");
		lamboXSpriteImage = loader.loadImage("/lamboXSprite.png");
		lamboCornerImage = loader.loadImage("/CornerSprite.png");
		gameLevel = loader.loadImage("/level.png");
		
		terrain_sprite = new SpriteSheet(terrain_sprite_image);
		lamboYSprite = new SpriteSheet(lamboYSpriteImage);
		lamboXSprite = new SpriteSheet(lamboXSpriteImage);
		lamboCornerSprite = new SpriteSheet(lamboCornerImage);
		
		floor = loader.loadImage("/RoughRoad.png");
		
		lambo[0] = lamboYSprite.grabImage(1, 1, 32, 48);
		lambo[1] = lamboYSprite.grabImage(2, 1, 32, 48);
		lambo[2] = lamboXSprite.grabImage(1, 1, 48, 32);
		lambo[3] = lamboXSprite.grabImage(1, 2, 48, 32);
		
		lambo[4] = lamboCornerSprite.grabImage(1, 1, 52, 46);
		lambo[5] = lamboCornerSprite.grabImage(2, 1, 52, 46);
		lambo[6] = lamboCornerSprite.grabImage(3, 1, 52, 46);
		lambo[7] = lamboCornerSprite.grabImage(4, 1, 52, 46);
		
		tree = terrain_sprite.grabImage(1, 5, 64, 95);
		
	}


}
