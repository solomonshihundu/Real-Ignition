package com.iridium.game.realignition;


import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


public class Game extends Canvas implements Runnable
{
	
	private static final long serialVersionUID = -7171853184430182872L;
	private boolean running =false;
	private Thread thread;
	public static final int WIDTH=1200;
	public static final int HEIGHT=700;
	public static int speed=5;
	
	private Camera cam;
	private Handler handler;
	private HUD hud;
	private Textures tex;
	private Spawner spawner;
	private BufferedImageLoader loader = new BufferedImageLoader();
	private BufferedImage level_image;
	
	public Game()
	{
				
		cam = new Camera(0,0);
		tex = new Textures();
		handler=new Handler("D:\\EclipsePhoton\\RealIgnition\\res\\testmap");
		this.addKeyListener(new KeyInput(handler,this));
	//           	hud=new HUD();
		spawner=new Spawner(handler,hud);
		level_image = tex.gameLevel;
		
		
//		handler.loadLevel(level_image);
//		handler.loadPlayer(level_image);
		
		new Window("NAI-RUSH",WIDTH,HEIGHT,this);
		
	}
	
	public static enum gameID
	{
		
	}

	public void run() 
	{
		this.requestFocus();

		long initialTime = System.nanoTime();
		final double timeU = 1000000000 / 60;
		final double timeF = 1000000000 / 60;
		double deltaU = 0, deltaF = 0;
		
		    while (running) {
		
		        long currentTime = System.nanoTime();
		        deltaU += (currentTime - initialTime) / timeU;
		        deltaF += (currentTime - initialTime) / timeF;
		        initialTime = currentTime;
		
		        if (deltaU >= 1) {
		            tick();
		            
		            deltaU--;
		        }
		
		        if (deltaF >= 1) {
		            render();
		            
		            deltaF--;
		        }
		 }
		    
		    stop();
		
	}
	public void render()
	{
		BufferStrategy bs=this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.translate(-cam.getX(), -cam.getY());
		
		for(int xx=0;xx<30*70;xx+=32)
		{
			for(int yy=0;yy<30*70;yy+=32)
			{
		    	g.drawImage(tex.floor, xx, yy, null);
	 
			}
		}
	
		handler.render(g);
		
		g2d.translate(cam.getX(), cam.getY());
		
	//	hud.render(g);
		
		g.dispose();
		bs.show();
		

	}
	public void tick()
	{
		for(int i = 0;i<handler.object.size();i++)
        {
	        if(handler.object.get(i).getID() == ID.Player)
	          {
		        cam.tick(handler.object.get(i));
	          }
     	}
	//	hud.tick();
		spawner.tick();
		handler.tick();
	
	}
	
	public synchronized void start()
	{
		thread=new Thread(this);
		thread.start();
		running=true;
		
	}
	public synchronized void stop()
	{
		try {
			thread.join();
			running=false;
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	public static float clamp(float var,float min,float max)
	{
		if(var>=max)
		{
			return max;
		}
		else if(var<=min)
		{
			return min;
		}
		else return var;
	}
	public static void main(String args[])
	{
		new Game();
	}

}
