package model;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpriteAnimation extends Transition{
	private final ImageView skin;
	private final int count;
	private final int columns;
	private int offsetX;
	private int offsetY;
	private final int width;
	private final int height;
	
	
	
	@Override
	protected void interpolate(double arg0) {
		final int index = Math.min((int)Math.floor(count*arg0), count-1);
		final int x = (index%columns)*width+offsetX;
		final int y = (index/columns)*height+offsetY;
		skin.setViewport(new Rectangle2D(x,y,width,height));
	}
	
	public void setOffsetX(int x) {
		this.offsetX=x;
	}
	
	public void setOffsetY(int y) {
		this.offsetY=y;
	}
	
	
	public SpriteAnimation(ImageView skin, Duration duration, int count, int columns, int offsetX, int offsetY, int width, int height) {
		this.skin=skin;
		this.count=count;
		this.columns=columns;
		this.offsetX=offsetX;
		this.offsetY=offsetY;
		this.width=width;
		this.height=height;
		
		setCycleDuration(duration);
		setCycleCount(Animation.INDEFINITE);
		setInterpolator(Interpolator.LINEAR);
		this.skin.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
	}
	
}
