package com.iridium.game.realignition;


import java.awt.Dimension;

import javax.swing.JFrame;

public class Window  extends JFrame
{
	private static final long serialVersionUID = -7992980086018369541L;
	
	public Window(String title,int width,int height,Game game)
	{
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setPreferredSize(new Dimension(width,height));
		this.pack();
		this.setLocationRelativeTo(null);
		this.add(game);
		game.start();
	}

}
