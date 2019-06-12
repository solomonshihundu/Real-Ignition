package com.iridium.game.realignition;


import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Handler 
{
	private Textures tex;
	private int x;
	private int y;
	private int [][]map;
	private int mapHeight;
	private int mapWidth; 
	private String myMap;
	
	
	LinkedList<GameObject> object=new LinkedList<GameObject>();
	public boolean accelerate=false,reverse=false,right=false,left=false;
	public boolean up_right =false,up_left=false,down_right=false,down_left=false;
	public boolean rotate = false;
	
	public Handler(String s)
	{
		this.myMap = s;
		tex = new Textures();
		

		try {
			BufferedReader br = new BufferedReader(new FileReader(myMap));
			mapWidth = Integer.parseInt(br.readLine());
			mapHeight = Integer.parseInt(br.readLine());
			map = new int[mapHeight][mapWidth]; 
			
			String delimiters = " ";
			
			for(int row = 0;row < mapHeight;row++)
			{
				String line = br.readLine();
				String [] tokens = line.split(delimiters);
				for(int col =0; col < mapWidth;col ++)
				{
					map[row][col] = Integer.parseInt(tokens[col]);
				}
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch(IOException d)
		{
			d.printStackTrace();
		}
		
		loadMap();
	
		
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
	
	public void loadMap()
	{
		for(int row = 0; row < mapHeight; row++)
		{
			for(int col = 0;col < mapWidth; col++)
			{
				int tileType = map[row][col];
				
				if(tileType == GameID.Tree)
				{
					addObject(new Tree((int)x,(int)y,ID.Tree));
				}
				
				
				else if(tileType == GameID.Player)
				{
					addObject(new Player((int)x,(int)y,ID.Player,this,tex));
				}
				
				else if(tileType == GameID.Opponent)
				{
					addObject(new Opponent((int)x,(int)y,ID.Opponent,this,tex));
				}
				
				else if(tileType == GameID.Block)
				{
					addObject(new Block((int)x,(int)y,ID.Block));
				}
						
			}
		}
	}
		
	
	
	
	public void clearLevel()
	{
		object.clear();
	}
	
	public boolean isAccelerate() {
		return accelerate;
	}
	public void accelerate(boolean up) {
		this.accelerate = up;
	}
	public boolean isReverse() {
		return reverse;
	}
	public void reverse(boolean down) {
		this.reverse = down;
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