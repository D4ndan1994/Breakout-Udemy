package com.danielsheridan.breakout.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.danielsheridan.breakout.framework.GameObject;
import com.danielsheridan.breakout.framework.ObjectId;
import com.danielsheridan.breakout.window.Handler;

public class Ball extends GameObject {

	private int width = 20, height = 20;
	private GameObject paddleTemp;
	Handler handler;

	public Ball(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ObjectId.Paddle) {
				paddleTemp = tempObject;
			}
		}
		
		velY = velX = 1;
	}

	public void move() {
		x += velX;
		y += velY;
		
		// Collision against wall	
		if(x <= 0) {
			velX = 8;
		}
		
		if( x > 790) {
			velX = -8;
		}
		
		if(y <= 0) {
			velY = 8;
		}
		
		// Collision against the brick or paddle
		collision();
		// falling below the paddle or board
		
		resetBall();
	}

	private void collision() {
		for(int i = 0; i<handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Paddle) {
				
				if(getBounds().intersects(tempObject.getBoundsTop())) {
					velY = -8;
				}
				if(getBounds().intersects(tempObject.getBoundsLeft())) {
					velY = -8;
					velX = -8;
				}
				if(getBounds().intersects(tempObject.getBoundsRight())) {
					velY = -8;
					velX = 8;
				}
			}
			else if (tempObject.getId() == ObjectId.Brick) {
				
				if(getBounds().intersects(tempObject.getBoundsTop())) {
					velY = -8;
				}
				if(getBounds().intersects(tempObject.getBoundsBottom())) {
					velY = 8;
				}
			}
		}
	}
	
	public void resetBall() {
		if(y > 600 ) {
			velX = 0;
			velY = 0;
			
			x = paddleTemp.getX() + 20;
			y = paddleTemp.getY() - 20;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillOval((int) x,(int) y, width, height);
		
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.blue);
		g2d.draw(getBounds());
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, width, height);
	}

	public Rectangle getBoundsTop() {
		return null;
	}

	public Rectangle getBoundsBottom() {
		return null;
	}

	public Rectangle getBoundsLeft() {
		return null;
	}
	
	public Rectangle getBoundsRight() {
		return null;
	}

}
