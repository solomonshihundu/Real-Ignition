package com.iridium.game.realignition;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter
{
	private Handler handler;
	public int lastKey = 0;
	
	public KeyInput(Handler handler,Game game)
	{
		this.handler=handler;
	}
	public void keyPressed(KeyEvent e)
	{
		int key=e.getKeyCode();
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject temp=handler.object.get(i);
			if(temp.getID()==ID.Player)
			{
				if(key==KeyEvent.VK_UP){handler.accelerate(true);}
				if(key==KeyEvent.VK_DOWN){handler.reverse(true);}
				
				if(key==KeyEvent.VK_LEFT){handler.setLeft(true);}
				if(key==KeyEvent.VK_RIGHT){handler.setRight(true);}
				
				if(key==KeyEvent.VK_UP && key==KeyEvent.VK_LEFT ){handler.up_left = true;}
				if(key==KeyEvent.VK_UP && key==KeyEvent.VK_RIGHT ){handler.up_left = true;}
				if(key==KeyEvent.VK_DOWN && key==KeyEvent.VK_LEFT ){handler.up_left = true;}
				if(key==KeyEvent.VK_DOWN && key==KeyEvent.VK_RIGHT ){handler.up_left = true;}
			}
		}
		
	}
	public void keyReleased(KeyEvent e)
	{
		int key=e.getKeyCode();
		lastKey = key;
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject temp=handler.object.get(i);
			if(temp.getID()==ID.Player)
			{
				if(key==KeyEvent.VK_UP){handler.accelerate(false);}
				if(key==KeyEvent.VK_DOWN){handler.reverse(false);}
				if(key==KeyEvent.VK_LEFT){handler.setLeft(false);}
				if(key==KeyEvent.VK_RIGHT){handler.setRight(false);}
				
				if(key==KeyEvent.VK_UP && key==KeyEvent.VK_LEFT ){handler.up_left = false;}
				if(key==KeyEvent.VK_UP && key==KeyEvent.VK_RIGHT ){handler.up_left = false;}
				if(key==KeyEvent.VK_DOWN && key==KeyEvent.VK_LEFT ){handler.up_left = false;}
				if(key==KeyEvent.VK_DOWN && key==KeyEvent.VK_RIGHT ){handler.up_left = false;}
			}
			}
		}
		
	

}
