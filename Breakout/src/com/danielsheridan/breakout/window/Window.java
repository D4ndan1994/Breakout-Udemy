package com.danielsheridan.breakout.window;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	
	public Window(int width, int height, String title, Board board) {
		// code runs immediately as an object of our class is created
		board.setPreferredSize(new Dimension(width,height));
		board.setMaximumSize(new Dimension (width,height));
		board.setMinimumSize(new Dimension(width, height));
		
		JFrame frame = new JFrame(title);
		frame.add(board);
		frame.pack();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		board.start();
	}

	public static void main (String args[]) {
		
		new Window(800,600, "Breakout", new Board());
	}
}
