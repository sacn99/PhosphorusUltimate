package model;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public class GameObject extends ImageView implements Movable{
	private ImageView object;
	private double coordenateX;
	private double coordenateY;
	private int width;
	private int height;
	private boolean alive;
	private int lives;
	private double velocity;
	
	
	public GameObject(ImageView skin, double x, double y, int width, int height, boolean alive, int lives, double velocity) {
		object=skin;
		coordenateX = x;
		coordenateY = y;
		this.width = width;
		this.height = height;
		object.setViewport(new Rectangle2D(coordenateX, coordenateY, width, height));
		this.alive=alive;
		this.lives=lives;
		this.velocity=velocity;
	}


	@Override
	public void moveUp() {
		 setTranslateY(getTranslateY() - velocity);
		
	}


	@Override
	public void moveDown() {
		 setTranslateY(getTranslateY() + velocity);
		
	}


	@Override
	public void moveRight() {
		 setTranslateX(getTranslateX() + velocity);
		
	}


	@Override
	public void moveLeft() {
		 setTranslateX(getTranslateX() - velocity);
		
	}
	public ImageView getObject() {
		return object;
	}


	public void setObject(ImageView object) {
		this.object = object;
	}


	public double getCoordenateX() {
		return coordenateX;
	}


	public void setCoordenateX(double coordenateX) {
		this.coordenateX = coordenateX;
	}


	public double getCoordenateY() {
		return coordenateY;
	}


	public void setCoordenateY(double coordenateY) {
		this.coordenateY = coordenateY;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public boolean isAlive() {
		return alive;
	}


	public void setAlive(boolean alive) {
		this.alive = alive;
	}


	public int getLives() {
		return lives;
	}


	public void setLives(int lives) {
		this.lives = lives;
	}


	public double getVelocity() {
		return velocity;
	}


	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}
}
