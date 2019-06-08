package com.iridium.game.realignition;


import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject
{
	private Handler handler;
	private Textures tex;

	public Player(float x,float y,ID id,Handler handler,Textures tex)
	{
		super(x,y,id);
		this.handler=handler;
		this.tex = tex;
		new Animation(3,tex.lambo[0],tex.lambo[1],tex.lambo[2],tex.lambo[3]);
		
		
	}
	public void tick()
	{
		x+=velX;
		y+=velY;
		
		
		if(handler.isUp()){velY=-3;}
		else if(!handler.isDown()){velY=0;}
		
		if(handler.isDown()){velY=3;}
		else if(!handler.isUp()){velY=0;}
		
		if(handler.isLeft()){velX=-3;}
		else if(!handler.isRight()){velX=0;}
		
		if(handler.isRight()){velX=3;}
		else if(!handler.isLeft()){velX=0;}
		
		
		
		
		collision();
		
	}

	
	public void render(Graphics g) 
	{
	//	handler.setRight(true);
	
//		g.drawImage(tex.lambo[7], (int)x, (int)y, null);
		
		if(handler.isUp())
		{
			g.drawImage(tex.lambo[0], (int)x, (int)y, null);
		}
		else if(handler.isDown())
		{
			g.drawImage(tex.lambo[1], (int)x, (int)y, null);
		}
		else if(handler.isLeft())
		{
			g.drawImage(tex.lambo[3], (int)x, (int)y, null);
		}
		else if(handler.isRight())
		{
			g.drawImage(tex.lambo[2], (int)x, (int)y, null);
		}
		else if(handler.up_left || (handler.isUp() && handler.isLeft()))
		{
			g.drawImage(tex.lambo[4], (int)x, (int)y, null);
		}
		else if(handler.up_right)
		{
			g.drawImage(tex.lambo[7], (int)x, (int)y, null);
		}
		else if(handler.down_left)
		{
			g.drawImage(tex.lambo[6], (int)x, (int)y, null);
		}
		else if(handler.down_right)
		{
			g.drawImage(tex.lambo[5], (int)x, (int)y, null);
		}
	   
	}

	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,32,32);
	}
	public void collision()
	{
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject temp=handler.object.get(i);
			if(temp.getID()==ID.Opponent)
			{
				if(getBounds().intersects(temp.getBounds()))
				{
					HUD.HEALTH--;
				}
			}
			if(temp.getID() == ID.Tree )
			{
			   if(getBounds().intersects(temp.getBounds()))
			   {
				  x+=velX*-1;
				  y+=velY*-1;
				 
			   }
			}
		}
	}

}
