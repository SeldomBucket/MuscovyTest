package com.helloworld.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HelloWorld extends ApplicationAdapter {
	SpriteBatch batch;
	private Texture dropImage, bucketImage;
	private OrthographicCamera camera;
	private Bucket bucket;
	private BitmapFont font;
	private float accel = 2000, decel = 1000;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		dropImage = new Texture("H:/2nd Year Modules/SEPR/HelloWorld/core/assets/droplet.png");
		bucketImage = new Texture("H:/2nd Year Modules/SEPR/HelloWorld/core/assets/bucket.png");
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 400);
		bucket = new Bucket();
        font = new BitmapFont();
        font.setColor(Color.RED);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(bucketImage, bucket.getX(), bucket.getY());
		font.draw(batch, "HelloWorld", 200, 200);
		batch.end();
		movement();
		
	}
	private void movement(){
		if(Gdx.input.isKeyPressed(Keys.A)) {
			if (bucket.getXVelocity() > 50){
				bucket.setXVelocity(50);
			}
			bucket.changeXVelocity(-accel*Gdx.graphics.getDeltaTime());
			checkEdgeCollision();
		}else if(Gdx.input.isKeyPressed(Keys.D)) {
			if (bucket.getXVelocity() < -50){
				bucket.setXVelocity(-50);
			}
			bucket.changeXVelocity(accel*Gdx.graphics.getDeltaTime());
			checkEdgeCollision();
		}else{
			if(!Gdx.input.isKeyPressed(Keys.A)){
				if (bucket.getXVelocity() > 0){
					bucket.changeXVelocity(-decel*Gdx.graphics.getDeltaTime());
					if (bucket.getXVelocity() < 0){
						bucket.setXVelocity(0);
					}
				}
			}
			if(!Gdx.input.isKeyPressed(Keys.D)){
				if (bucket.getXVelocity() < 0){
					bucket.changeXVelocity(decel*Gdx.graphics.getDeltaTime());
					if (bucket.getXVelocity() > 0){
						bucket.setXVelocity(0);
					}
				}
			}
		}
		
		if(Gdx.input.isKeyPressed(Keys.W)) {
			if (bucket.getYVelocity() < -50){
				bucket.setYVelocity(-50);
			}
			bucket.changeYVelocity(accel*Gdx.graphics.getDeltaTime());
			checkEdgeCollision();
			if(Gdx.input.isKeyPressed(Keys.S)){
				bucket.setYVelocity(0);
			}
		}else{
			if (bucket.getYVelocity() > 0){
				bucket.changeYVelocity(-decel*Gdx.graphics.getDeltaTime());
				if (bucket.getYVelocity() < 0){
					bucket.setYVelocity(0);
				}
			}
		}
		if(Gdx.input.isKeyPressed(Keys.S)) {
			if (bucket.getYVelocity() > 50){
				bucket.setYVelocity(50);
			}
			bucket.changeYVelocity(-accel*Gdx.graphics.getDeltaTime());
			checkEdgeCollision();
			if(Gdx.input.isKeyPressed(Keys.W)){
				bucket.setYVelocity(0);
			}
		}else{
			if (bucket.getYVelocity() < 0){
				bucket.changeYVelocity(decel*Gdx.graphics.getDeltaTime());
				if (bucket.getYVelocity() > 0){
					bucket.setYVelocity(0);
				}
			}
		}
		if(Gdx.input.isKeyPressed(Keys.SPACE)) {
			bucket.setXVelocity(0);
			bucket.setYVelocity(0);
		}
		checkEdgeCollision();
		bucket.setX(bucket.getX() + bucket.getXVelocity()*Gdx.graphics.getDeltaTime());
		bucket.setY(bucket.getY() + bucket.getYVelocity()*Gdx.graphics.getDeltaTime());
	}
	private void checkEdgeCollision(){
		if(bucket.getX() < 0) {bucket.setX(0); bucket.setXVelocity(0);}
		if(bucket.getX() > 800 - 64) {bucket.setX(800-64); bucket.setXVelocity(0);}
		if(bucket.getY() < 0) {bucket.setY(0); bucket.setYVelocity(0);}
		if(bucket.getY() > 400 - 64) {bucket.setY(400-64); bucket.setYVelocity(0);}
	}
}
