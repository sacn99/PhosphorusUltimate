package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import thread.SoundThread;

public class Main extends Application {
	
	
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws IOException {
    	//Content
    			//Text
    			Label title = new Label();
    			title.setText("PHOSPHORUS");
    			title.setFont(Font.loadFont("File:media/Fonts/ka1.ttf", 90));
    			title.setTextFill(Color.BEIGE);
    			Label subtitle = new Label();
    			subtitle.setText("Press any button to start");
    			subtitle.setFont(Font.loadFont("File:media/Fonts/Positive System.otf", 30));
    			subtitle.setTextFill(Color.LIGHTGRAY);
    			//Containers
    			Pane p = new Pane();
    			p.getChildren().add(title);
    			p.getChildren().add(subtitle);
    			Scene scene = new Scene(p);
    			//Media
    			Image img = new Image("File:media/enviroment/fullOfStars2.jpg");
    			BackgroundImage staticImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);
    			p.setBackground(new Background(staticImg));
    			SoundThread soundtrack = new SoundThread();
    			soundtrack.start();
		//Stage
    	stage.setTitle("PHOSPHORUS");
    	stage.setScene(scene);
    	stage.setFullScreen(true);
    	stage.show();
    	//Alignments
    	title.setLayoutX(p.getWidth()/2-title.getWidth()/2);
    	title.setLayoutY(p.getHeight()/2-title.getHeight()/2);
    	subtitle.setLayoutX(p.getWidth()/2-subtitle.getWidth()/2);
    	subtitle.setLayoutY(p.getHeight()/2+title.getHeight());
    	//TheRealProgrammingBeggins
    	scene.setOnKeyPressed(k -> {
			try {
				loadMenu(stage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
    public void loadMenu(Stage stage) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScenes.fxml"));
    	Parent root = loader.load();
    	stage.getScene().setRoot(root);
    	GameScenesGUI controller = loader.getController();
    	controller.NodesAlignment();
    	System.out.println("Game beggings");
	}
}