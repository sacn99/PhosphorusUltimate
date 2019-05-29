package thread;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundThread extends Thread{
	private Media file;
	private MediaPlayer loader;
	@Override
	public void run() {
		try {
		file = new Media(new File("media/soundtrack/Midnight-Crawlers_Looping.mp3").toURI().toString());
		loader = new MediaPlayer(file);
		loader.setVolume(1);;
		loader.play();
		} catch(Exception e) {
			
		}
	}
}
