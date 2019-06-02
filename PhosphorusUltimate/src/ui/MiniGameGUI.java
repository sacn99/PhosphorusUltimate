package ui;


import java.io.IOException;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.*;

public class MiniGameGUI {

	private SpaceShip player;
	private List<Enemy> enemies;
	private AnimationTimer timer;
	
	@FXML
    private BorderPane principalContainer;
	
    @FXML
    private Pane gamePane;

    @FXML
    private VBox informationBox;
    
    @FXML
    private HBox livesHBox;

    @FXML
    private HBox scoreHBox;

    @FXML
    private Label livesTitle;

    @FXML
    private Label livesNumber;

    @FXML
    private Label scoreTitle;

    @FXML
    private Label scoreNumber;

    @FXML
    private Button saveGame;

    @FXML
    private Button instructions;

    @FXML
    private Button backToMenu;

    @FXML
    void move(KeyEvent event) {
    	switch (event.getCode()) {
		case W:
			player.moveUp();
			break;
		case A:
            player.moveLeft();
            break;
        case S:
            player.moveDown();
            break;
        case D:
        	player.moveRight();
        case SPACE:
            //shoot(player);
        	System.out.println("el man disparo");
            break;
        default:
        	break;
    	}
    }
    @FXML
    void goBack(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("menuScene.fxml"));
    	Parent root = loader.load();
    	backToMenu.getScene().setRoot(root);
    	MenuSceneGUI controller = loader.getController();
    	controller.NodesAlignment();
    }

    @FXML
    void saveGame(ActionEvent event) {

    }

    @FXML
    void showInstructions(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	informationBox.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
    	informationBox.setAlignment(Pos.CENTER);
    	livesHBox.setLayoutX(informationBox.getMaxWidth());
    	informationBox.setSpacing(100);
    	
    	livesTitle.setFont(Font.loadFont("File:media/Fonts/Positive System.otf", 20));
    	livesTitle.setTextFill(Color.WHITE);
    	livesTitle.setAlignment(Pos.CENTER_LEFT);
    	
    	livesNumber.setFont(Font.loadFont("File:media/Fonts/Positive System.otf", 20));
    	livesNumber.setTextFill(Color.WHITE);
    	livesNumber.setAlignment(Pos.CENTER_RIGHT);
    	
    	scoreTitle.setFont(Font.loadFont("File:media/Fonts/Positive System.otf", 20));
    	scoreTitle.setTextFill(Color.WHITE);
    	scoreTitle.setAlignment(Pos.CENTER_LEFT);
    	
    	scoreNumber.setFont(Font.loadFont("File:media/Fonts/Positive System.otf", 20));
    	scoreNumber.setTextFill(Color.WHITE);
    	scoreNumber.setAlignment(Pos.CENTER_RIGHT);
    	
    	saveGame.resize(200, 100);
    	saveGame.setBackground(Background.EMPTY);
    	saveGame.setFont(Font.loadFont("File:media/Fonts/Positive System.otf", 20));
    	saveGame.setTextFill(Color.WHITE);
    	saveGame.setOnMouseEntered(e -> saveGame.setTextFill(Color.YELLOW));
    	saveGame.setOnMouseExited(e -> saveGame.setTextFill(Color.WHITE));
    	
    	instructions.resize(200, 100);
    	instructions.setBackground(Background.EMPTY);
    	instructions.setFont(Font.loadFont("File:media/Fonts/Positive System.otf", 20));
    	instructions.setTextFill(Color.WHITE);
    	instructions.setOnMouseEntered(e -> instructions.setTextFill(Color.YELLOW));
    	instructions.setOnMouseExited(e -> instructions.setTextFill(Color.WHITE));
    	
    	backToMenu.resize(200, 100);
    	backToMenu.setBackground(Background.EMPTY);
    	backToMenu.setFont(Font.loadFont("File:media/Fonts/Positive System.otf", 20));
    	backToMenu.setTextFill(Color.WHITE);
    	backToMenu.setOnMouseEntered(e -> backToMenu.setTextFill(Color.YELLOW));
    	backToMenu.setOnMouseExited(e -> backToMenu.setTextFill(Color.WHITE));
    	
    	//Game
    	
    }
    
    public void NodesAlignment() {
    	informationBox.setPrefWidth(350);
    	Image img = new Image("File:media/enviroment/back.jpg", gamePane.getWidth(), gamePane.getHeight(),true,true);
		BackgroundImage staticImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);
		gamePane.setBackground(new Background(staticImg));
		
		alignSpaceShip();
    }
	private void alignSpaceShip() {
		ImageView imv = new ImageView(new Image(getClass().getResourceAsStream("/media/enviroment/fullOfStars2.jpg")));
		Rectangle2D rec = new Rectangle2D(gamePane.getWidth()/2, gamePane.getHeight()/2, 50,50);
		imv.setViewport(rec);
		
		gamePane.getChildren().add(imv);
		imv.setLayoutX(gamePane.getWidth()/2);
		imv.setLayoutY(gamePane.getHeight()/2);
		/*
		player = new SpaceShip(new ImageView(new Image("File:media/enviroment/spaceShip.png")), 50, 50, true, 3, 5);
    	gamePane.getChildren().add(player);
    	player.setLayoutX(gamePane.getWidth()/2);
    	player.setLayoutY(gamePane.getHeight()/2);*/
	}
}