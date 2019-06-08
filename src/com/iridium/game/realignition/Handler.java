package com.iridium.game.realignition;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Handler 
{
	private Textures tex;
	
	LinkedList<GameObject> object=new LinkedList<GameObject>();
	public boolean up=false,down=false,right=false,left=false;
	public boolean up_right =false,up_left=false,down_right=false,down_left=false;
	public boolean rotate = false;
	
	public Handler(Textures tex)
	{
		this.tex = tex;
	}
	public void tick()
	{
		for(int i=0;i<object.size();i++)
		{
			GameObject temp=object.get(i);
			temp.tick();
		}
		
	}
	public void render(Graphics  g)
	{
		for(int i=0;i<object.size();i++)
		{
			GameObject temp=object.get(i);	
			
			temp.render(g);		
		}
		
	}
	public void loadLevel(BufferedImage image)
	{
		int w=image.getWidth();
		int h=image.getHeight();
        
		for(int xx=0;xx<w;xx++)
		{
			for(int yy=0;yy<h;yy++)
			{
				int pixel=image.getRGB(xx, yy);
				
				int red=(pixel>>16)&0xff;
				int green=(pixel>>8)&0xff;
				int blue=(pixel)&0xff;
				
				
				 if(red == 0 && green == 255 && blue == 0)
				{
					addObject(new Tree((int)xx*32,(int)yy*32,ID.Tree));
				}
		
			}
		}
		
	}
	
	public void loadPlayer(BufferedImage image)
	{
		int w=image.getWidth();
		int h=image.getHeight();
        
		for(int xx=0;xx<w;xx++)
		{
			for(int yy=0;yy<h;yy++)
			{
				int pixel=image.getRGB(xx, yy);
				
				int red=(pixel>>16)&0xff;
				int green=(pixel>>8)&0xff;
				int blue=(pixel)&0xff;
				
				 if(red == 0 && green == 0 && blue == 255)
				{
					addObject(new Player((int)xx*48,(int)yy*48,ID.Player,this,tex));
				}
			}
		}
	}
	public void clearLevel()
	{
		object.clear();
	}
	public boolean isUp() {
		return up;
	}
	public void setUp(boolean up) {
		this.up = up;
	}
	public boolean isDown() {
		return down;
	}
	public void setDown(boolean down) {
		this.down = down;
	}
	public boolean isRight() {
		return right;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	public boolean isLeft() {
		return left;
	}
	public void setLeft(boolean left) {
		this.left = left;
	}
	public void addObject(GameObject myObject)
	{
		object.add(myObject);
	}
	public void removeObject(GameObject myObject)
	{
		object.remove(myObject);
	}
	
	

}