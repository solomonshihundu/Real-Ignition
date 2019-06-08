package com.iridium.game.realignition;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class HUD 
{
	public static float HEALTH=100;
	public int score=0;
	public int level=1;
	
	public HUD()
	{
		
	}
	public void tick()
	{
		HEALTH=Game.clamp(HEALTH, 0, 100);
		score++;
	}
	public void render(Graphics g)
	{
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 20);
		g.setColor(Color.green);
		g.fillRect(15, 15, (int)HEALTH*2, 20);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 20);
		
		g.setColor(new Color(190,100,20));
		g.setFont(new Font("Algerian",Font.BOLD,15));
		g.drawString("Score : "+getScore(), 15,55 );
		g.drawString("Level : "+getLevel(), 15,75 );
		
		
	}
	public void setScore(int score)
	{
		this.score=(int)Game.clamp(score, 0, 1000000);
	}
	public int getScore()
	{
		return (int)Game.clamp(score, 0, 1000000);
	}
	public void setLevel(int level)
	{
		this.level=level;
	}
	public int getLevel()
	{
		return level;
	}

}
