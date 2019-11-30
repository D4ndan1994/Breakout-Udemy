package com.danielsheridan.breakout.window;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.danielsheridan.breakout.framework.KeyInput;
import com.danielsheridan.breakout.framework.ObjectId;
import com.danielsheridan.breakout.objects.Ball;
import com.danielsheridan.breakout.objects.Paddle;

public class Board extends JPanel implements Runnable{
	private boolean running = false;
	private Thread thread;
	private static int WIDTH, HEIGHT;
	Handler handler;
	
	public Board() {
		
	}
	
	private void init() {
		setFocusable(true);
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		handler = new Handler();
		handler.addObject(new Paddle(100, 570, handler, ObjectId.Paddle));
		handler.addObject(new Ball(120, 448, handler, ObjectId.Ball));
		handler.createLevel();
		
		this.addKeyListener(new KeyInput(handler));
	}
	
	public synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this); //this keyword references the current object using this method
		thread.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		// this is the code to create our objects 
		
		handler.render(g);
		g.dispose();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		init();
		
		while(running) {
			// game loop
			
			move();
			repaint();
			
			try {
				thread.sleep(20);
				
			}
			catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}	
	}
	
	private void move() {
		handler.move();
	}
}
