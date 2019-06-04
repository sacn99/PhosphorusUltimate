package model;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameObject extends ImageView implements Movable, Comparable<GameObject>{
	private int width;
	private int height;
	private boolean alive;
	private int lives;
	private double velocity;
	private GameObject left;
	private GameObject right;
	
	public GameObject(Image skin, int width, int height, boolean alive, int lives, double velocity) {
		setImage(skin);
		this.width = width;
		this.height = height;
		setViewport(new Rectangle2D(0, 0, width, height));
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


	public GameObject getLeft() {
		return left;
	}


	public void setLeft(GameObject left) {
		this.left = left;
	}


	public GameObject getRight() {
		return right;
	}


	public void setRight(GameObject right) {
		this.right = right;
	}

	@Override
	public int compareTo(GameObject o) {
		
		if(this.getVelocity()<((GameObject)o).getVelocity()) {
			return 1;
		}else {
			return 0;
		}
	}
}
