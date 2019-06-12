package com.iridium.game.realignition;



public class Spawner
{
	
	private HUD hud;
	private int scoreKeep=0;
	
	public Spawner(Handler handler,HUD hud)
	{
		this.hud=hud;
	}
	public void tick()
	{
		scoreKeep++;
		if(scoreKeep>100)
		{
			scoreKeep=0;
		//	hud.setLevel(hud.getLevel()+1);
			/*
			if(hud.getLevel()==2)
			{
				handler.addObject(new SpaceEnemy(r.nextInt(Game.WIDTH),0,ID.SpaceEnemy,handler));
				handler.addObject(new SpaceEnemy(r.nextInt(Game.WIDTH),0,ID.SpaceEnemy,handler));
			}
			if(hud.getLevel()==4)
			{
				handler.addObject(new SpaceEnemy(r.nextInt(Game.WIDTH),0,ID.SpaceEnemy,handler));
				handler.addObject(new SpaceEnemy(r.nextInt(Game.WIDTH),0,ID.SpaceEnemy,handler));
				handler.addObject(new SpaceEnemy(r.nextInt(Game.WIDTH),0,ID.SpaceEnemy,handler));
				handler.addObject(new SpaceEnemy(r.nextInt(Game.WIDTH),0,ID.SpaceEnemy,handler));
			}
			if(hud.getLevel()==6)
			{
				handler.addObject(new SpaceEnemy(r.nextInt(Game.WIDTH),0,ID.SpaceEnemy,handler));
				handler.addObject(new SpaceEnemy(r.nextInt(Game.WIDTH),0,ID.SpaceEnemy,handler));
				handler.addObject(new SpaceEnemy(r.nextInt(Game.WIDTH),0,ID.SpaceEnemy,handler));
				handler.addObject(new SpaceEnemy(r.nextInt(Game.WIDTH),0,ID.SpaceEnemy,handler));
			}
			if(hud.getLevel()==8)
			{
				handler.addObject(new SpaceEnemy(r.nextInt(Game.WIDTH),0,ID.SpaceEnemy,handler));
				handler.addObject(new SpaceEnemy(r.nextInt(Game.WIDTH),0,ID.SpaceEnemy,handler));
				handler.addObject(new SpaceEnemy(r.nextInt(Game.WIDTH),0,ID.SpaceEnemy,handler));
				handler.addObject(new SpaceEnemy(r.nextInt(Game.WIDTH),0,ID.SpaceEnemy,handler));
			}
			if(hud.getLevel()==10)
			{
				handler.addObject(new SpaceEnemy(r.nextInt(Game.WIDTH),0,ID.SpaceEnemy,handler));
				handler.addObject(new SpaceEnemy(r.nextInt(Game.WIDTH),0,ID.SpaceEnemy,handler));
				handler.addObject(new SpaceEnemy(r.nextInt(Game.WIDTH),0,ID.SpaceEnemy,handler));
				handler.addObject(new SpaceEnemy(r.nextInt(Game.WIDTH),0,ID.SpaceEnemy,handler));handler.addObject(new SpaceEnemy(r.nextInt(Game.WIDTH),0,ID.SpaceEnemy,handler));
				handler.addObject(new SpaceEnemy(r.nextInt(Game.WIDTH),0,ID.SpaceEnemy,handler));
			}
		*/}
	}

}
