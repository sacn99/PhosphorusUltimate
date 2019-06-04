package model;

import javafx.scene.image.Image;

public class Bonus extends GameObject{
	private Bonus prev;
	private Bonus next;
	public Bonus(Image skin, int width, int height, boolean alive, int lives, double velocity) {
		super(skin, width, height, alive, lives, velocity);
		// TODO Auto-generated constructor stub
	}
	public Bonus getPrev() {
		return prev;
	}
	public void setPrev(Bonus prev) {
		this.prev = prev;
	}
	public Bonus getNext() {
		return next;
	}
	public void setNext(Bonus next) {
		this.next = next;
	}

}
