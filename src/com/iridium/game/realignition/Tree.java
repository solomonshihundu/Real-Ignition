package com.iridium.game.realignition;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Tree extends GameObject
{
	public Tree(int x, int y, ID id) {
		
		super(x, y, id);
		
	}
	public void tick() {
		
	}
	public void render(Graphics g)
	{		
	     g.drawImage(Textures.tree, (int)x, (int)y, null);
	
	}

	public Rectangle getBounds() 
	{
			return new Rectangle((int)x , (int)y,32,64);
	}
	

}
