package model;

import javafx.scene.image.Image;

public class SpaceShip extends GameObject {

	public SpaceShip(Image skin, int width,int height, boolean alive, int lives, double velocity) {
		super(skin, width, height, alive, lives, velocity);
		setRotate(90);
		// TODO Auto-generated constructor stub
	}
	
}
