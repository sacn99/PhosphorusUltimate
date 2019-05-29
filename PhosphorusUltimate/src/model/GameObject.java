package model;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Shape;

public class GameObject implements Movable{
	private ImageView object;
	private double coordenateX;
	private double coordenateY;
	private int width;
	private int height;
	private int live;
	private double velocity;
	
	SpriteAnimation animation;
	
	public GameObject(ImageView skin, double x, double y, int[] size) {
		object=skin;
		coordenateX = x;
		coordenateY = y;
		width = size[0];
		height = size [1];
		object.setViewport(new Rectangle2D(coordenateX, coordenateY, width, height));
		animation = new SpriteAnimation(imageView)
	}
	@Override
	public void moveX(int x) {
		boolean right = x>0?true:false;
		for(int i = 0; i < Math.abs(x); i++) {
			if(right)
		}
	}
	@Override
	public void moveY(int y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void rotateX(int x) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void rotateY(int y) {
		// TODO Auto-generated method stub
		
	}
}
