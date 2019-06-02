package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import thread.SoundThread;

public class Main extends Application {
	
	
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("initialScene.fxml"));
    	Parent root = loader.load();
    	final InitialSceneGUI controller= loader.getController();
    	stage.setTitle("PHOSPHORUS");
    	stage.setScene(new Scene(root));
    	stage.setFullScreen(true);
    	SoundThread soundtrack = new SoundThread("media/soundtrack/Security-Breach_Looping.mp3");
		soundtrack.start();
    	stage.getScene().setOnKeyPressed(e-> {
    		if(stage.getScene().getRoot()==root) {
    			try {
    				soundtrack.finiquito();
					controller.loadMenu(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					if(!soundtrack.isInterrupted()) {
						soundtrack.interrupt();
					}
				}
    		}
    	});
    	stage.show();
		controller.alignNodes();
    	
	}
}