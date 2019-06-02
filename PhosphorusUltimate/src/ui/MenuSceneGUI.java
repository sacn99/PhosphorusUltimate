package ui;





import java.io.IOException;

import javafx.animation.PathTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;

import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import thread.SoundThread;

public class MenuSceneGUI {
	
    @FXML
    private Pane pane;

	@FXML
	public void initialize() {
		Label title = new Label();
		title.setText("PHOSPHORUS");
		title.setFont(Font.loadFont("File:media/Fonts/ka1.ttf", 90));
		title.setTextFill(Color.BEIGE);
		
		Button newGame = new Button();
		newGame.setText("New Game");
		newGame.setTextFill(Color.LIGHTGRAY);
		newGame.setPrefSize(300, 30);
		newGame.setFont(Font.loadFont("File:media/Fonts/LLPIXEL3.ttf", 30));
		newGame.setBackground(null);
		Button miniGame = new Button();
		miniGame.setText("MiniGame");
		miniGame.setTextFill(Color.LIGHTGRAY);
		miniGame.setPrefSize(300, 30);
		miniGame.setFont(Font.loadFont("File:media/Fonts/LLPIXEL3.ttf", 30));
		miniGame.setBackground(null);
		Button exit = new Button();
		exit.setText("Exit");
		exit.setTextFill(Color.LIGHTGRAY);
		exit.setPrefSize(300, 30);
		exit.setFont(Font.loadFont("File:media/Fonts/LLPIXEL3.ttf", 30));
		exit.setBackground(null);
		
		VBox buttonContainer = new VBox(40);
		buttonContainer.getChildren().add(newGame);
		buttonContainer.getChildren().add(miniGame);
		buttonContainer.getChildren().add(exit);
		pane.getChildren().add(buttonContainer);
		pane.getChildren().add(title);
		Image img = new Image("File:media/enviroment/fullOfStars2.jpg");
		BackgroundImage staticImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);
		pane.setBackground(new Background(staticImg));
		
		newGame.setOnMouseEntered(e -> newGame.setTextFill(Color.YELLOW));
		newGame.setOnMouseExited(e -> newGame.setTextFill(Color.LIGHTGRAY));
		miniGame.setOnMouseEntered(e -> miniGame.setTextFill(Color.YELLOW));
		miniGame.setOnMouseExited(e -> miniGame.setTextFill(Color.LIGHTGRAY));
		exit.setOnMouseEntered(e -> exit.setTextFill(Color.YELLOW));
		exit.setOnMouseExited(e -> exit.setTextFill(Color.LIGHTGRAY));
		SoundThread soundtrack = new SoundThread("media/soundtrack/World-of-Automatons_Looping.mp3");
		soundtrack.start();
		newGame.setOnMouseClicked(e -> Notify("Not Available yet, try with minigame!"));
		miniGame.setOnMouseClicked(e -> {
			try {
				soundtrack.finiquito();;
				loadMiniGame();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				if(!soundtrack.isInterrupted()) {
					soundtrack.interrupt();
				}
			}
		});
		exit.setOnMouseClicked(e -> {
			Stage window = (Stage)(pane.getScene().getWindow());
			window.close();
		});
		
		
	}
	public void Notify(String notification) {
		Rectangle box = new Rectangle(250, 100);
		box.setFill(Color.DARKGRAY);
		Label text = new Label();
		text.setText(notification+"\n\n"+"Press F1 To Close This Notification");
		text.setFont(Font.loadFont("File:media/Fonts/Positive System.otf", 10));
		text.setTextFill(Color.BLACK);
		StackPane stack = new StackPane();
		stack.getChildren().addAll(box, text);
		pane.getChildren().add(stack);
		stack.setLayoutX(pane.getWidth()-box.getWidth());
		stack.setLayoutY(pane.getHeight());
		
		Polyline polyline = new Polyline();
		polyline.getPoints().addAll(new Double[] {
			0.0, 0.0,
			0.0, -box.getHeight()
		});
		
		PathTransition transition = new PathTransition();
		transition.setNode(stack);
		transition.setDuration(Duration.seconds(3)); 
		transition.setPath(polyline);
		transition.setCycleCount(1);
		transition.play();
		transition.setOnFinished(e -> {
			transition.setDelay(Duration.seconds(5));
			pane.getChildren().remove(stack);
		});
	}
	public void NodesAlignment(){
		VBox vBox = (VBox) pane.getChildren().get(0);
		vBox.setAlignment(Pos.CENTER);
		vBox.setLayoutX(pane.getWidth()/2-150);
		vBox.setLayoutY(pane.getHeight()/2+15);
		Label title = (Label)pane.getChildren().get(1);
		title.setLayoutX(pane.getWidth()/2-400);
		title.setLayoutY(350);
	}
	public void loadMiniGame() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MiniGame.fxml"));
    	Parent root = null;
		root = loader.load();
		pane.getScene().setRoot(root);
    	MiniGameGUI controller = loader.getController();
    	controller.NodesAlignment();
	}
}
