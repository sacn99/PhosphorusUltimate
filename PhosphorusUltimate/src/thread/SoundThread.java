package thread;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class SoundThread extends Thread{
	private String url;
	private Media file;
	private MediaPlayer loader;
	private boolean soundEffect;
	public SoundThread(String url, boolean soundEffect) {
		this.url=url;
		this.soundEffect=soundEffect;
	}
	@Override
	public void run() {
		try {
		file = new Media(new File(url).toURI().toString());
		loader = new MediaPlayer(file);
		loader.setVolume(1);
		
		if(soundEffect) {
			loader.play();
			sleep(2000);
			finiquito();
		}else {
			loader.setAutoPlay(true);
			loader.setStopTime(file.getDuration());
			loader.setOnRepeat(this);
			loader.play();
		}

		} catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public void finiquito() {
		loader.stop();
	}
}
