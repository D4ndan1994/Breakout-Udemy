package com.danielsheridan.breakout.window;

import java.awt.Graphics;
import java.util.LinkedList;

import com.danielsheridan.breakout.framework.GameObject;
import com.danielsheridan.breakout.framework.ObjectId;
import com.danielsheridan.breakout.objects.Brick;

public class Handler {
	
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	private GameObject tempObject;
	
	public void move() {
		for(int i = 0; i < object.size(); i++) {
			tempObject = object.get(i);
			tempObject.move();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
	public void createLevel() {
		int xpos = 50;
		
		for(int x = 0; x < 7; x++) {
			addObject(new Brick(xpos, 100, this, ObjectId.Brick));
			xpos += 100;
		}
		
		xpos = 50;
		for(int x = 0; x < 7; x++) {
			addObject(new Brick(xpos, 120, this,  ObjectId.Brick));
			xpos += 100;
		}
		
		xpos = 50;
		for(int x = 0; x < 7; x++) {
			addObject(new Brick(xpos, 140, this, ObjectId.Brick));
			xpos += 100;
		}
	}
}
