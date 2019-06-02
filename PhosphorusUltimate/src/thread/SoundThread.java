package thread;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundThread extends Thread{
	private String url;
	private Media file;
	private MediaPlayer loader;
	public SoundThread(String url) {
		this.url=url;
	}
	@Override
	public void run() {
		try {
		file = new Media(new File(url).toURI().toString());
		loader = new MediaPlayer(file);
		loader.setVolume(1);
		loader.setAutoPlay(true);
		loader.setStopTime(file.getDuration());
		loader.play();
		loader.setOnRepeat(this);
		} catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public void finiquito() {
		loader.stop();
	}
}
