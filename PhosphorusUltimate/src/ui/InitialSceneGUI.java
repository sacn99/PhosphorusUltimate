package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class InitialSceneGUI {
	
    @FXML
    private Pane pane;
    @FXML
    private Label title;
    @FXML
    private Label subtitle;
    @FXML
    void loadMenu(KeyEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("menuScene.fxml"));
    	Parent root = loader.load();
    	pane.getScene().setRoot(root);
    	final MenuSceneGUI controller = loader.getController();
    	controller.NodesAlignment();
    }
    @FXML
    void alignNodes() {
			title.setLayoutX(pane.getWidth()/2-title.getWidth()/2);
			title.setLayoutY(pane.getHeight()/2-title.getHeight()/2);
			subtitle.setLayoutX(pane.getWidth()/2-subtitle.getWidth()/2);
			subtitle.setLayoutY(pane.getHeight()/2+title.getHeight());
    }
    
    @FXML
    public void initialize() {
    	//Text
		title.setText("PHOSPHORUS");
		title.setFont(Font.loadFont("File:media/Fonts/ka1.ttf", 90));
		title.setTextFill(Color.BEIGE);
		subtitle.setText("Press any button to start");
		subtitle.setFont(Font.loadFont("File:media/Fonts/Positive System.otf", 30));
		subtitle.setTextFill(Color.LIGHTGRAY);
		//Media
		Image img = new Image("File:media/enviroment/fullOfStars2.jpg");
		BackgroundImage staticImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);
		pane.setBackground(new Background(staticImg));
    }   
}
