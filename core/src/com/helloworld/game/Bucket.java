package com.helloworld.game;

import com.badlogic.gdx.math.Rectangle;

public class Bucket {
	private float xVelocity, yVelocity;
	private Rectangle box;
	private float maxVelocity = 300;
	private String testagain = "howzis?", testing = "howzat?";
	public Bucket(){
		xVelocity = 0;
		yVelocity = 0;
		box = new Rectangle();
		box.x = 800 / 2 - 64 / 2;
		box.y = 20;
		box.width = 64;
		box.height = 64;
	}
	public float getXVelocity(){
		return xVelocity;
	}
	public void changeXVelocity(float velocity){
		xVelocity += velocity;
		if (xVelocity > maxVelocity) xVelocity = maxVelocity;
		if (xVelocity < 0 -  maxVelocity) xVelocity = 0 -  maxVelocity;
	}
	public void setXVelocity(float velocity){
		xVelocity = velocity;
		if (xVelocity > maxVelocity) xVelocity = maxVelocity;
		if (xVelocity < 0 - maxVelocity) xVelocity = 0 - maxVelocity;
	}
	public float getYVelocity(){
		return yVelocity;
	}
	public void changeYVelocity(float velocity){
		yVelocity += velocity;
		if (yVelocity > maxVelocity) yVelocity = maxVelocity;
		if (yVelocity < 0 - maxVelocity) yVelocity = 0 - maxVelocity;
	}
	public void setYVelocity(float velocity){
		yVelocity = velocity;
		if (yVelocity > maxVelocity) yVelocity = maxVelocity;
		if (yVelocity < 0 - maxVelocity) yVelocity = 0 - maxVelocity;
	}
	public float getX(){
		return box.x;
	}
	public float getY(){
		return box.y;
	}
	public void setX(float setVal){
		box.x = setVal;
	}
	public void setY(float setVal){
		box.y = setVal;
	}
}
