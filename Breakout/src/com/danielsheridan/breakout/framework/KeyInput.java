package com.danielsheridan.breakout.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.danielsheridan.breakout.window.Handler;

public class KeyInput extends KeyAdapter{
	
	Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i< handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ObjectId.Paddle) {
				if(key == KeyEvent.VK_LEFT) {
					tempObject.setVelX(-10);
				}
				if(key == KeyEvent.VK_RIGHT) {
					tempObject.setVelX(10);
				}
			}
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i< handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ObjectId.Paddle) {
				if(key == KeyEvent.VK_LEFT) {
					tempObject.setVelX(0);
				}
				if(key == KeyEvent.VK_RIGHT) {
					tempObject.setVelX(0);
				}
			}
		}
	}
}
