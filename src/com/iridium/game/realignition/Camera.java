package com.iridium.game.realignition;


public class Camera 
{
	private float x,y;
	
	public Camera(float x,float y)
	{
		this.x = x;
		this.y = y;
		
	}
	public void tick(GameObject object)
	{
		x = Game.clamp((int)x, 28, 850);
		y = Game.clamp((int)y, 15,1400);
		
		x+=((object.getX()-x)-1200/2)*0.05f;
		y+=((object.getY()-y)-500/2)*0.05f;	
		
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
}

