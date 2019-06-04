package ui;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Exception.NoEnemiesException;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import model.*;
import thread.SoundThread;

public class MiniGameGUI {
	private GameObject root;
	private SpaceShip player;
	private List<Enemy> enemies;
	private List<Bullet> shoots;
	private AnimationTimer timer;
	private double time = 0;
	private Bonus first;
	private List<GameObject> objectList;
	
	
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
        	break;
        case F:
            shoot();
            break;
        default:
        	break;
    	}
    }
    
    public void shoot() {
    	Bullet shoot = new Bullet(new Image("File:media/enviroment/hope.png", 50, 50, true, false), 40, 40, true, 1, 8);
    	gamePane.getChildren().add(shoot);
    	shoot.setY(player.getTranslateY()+40);
    	shoot.setX(player.getTranslateX()+player.getWidth());
    	shoots.add(shoot);
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
    	
    	shoots = new ArrayList<Bullet>();
    	enemies = new ArrayList<Enemy>();
    	
    	timer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				upload();
				
			}
		};
		timer.start();
		try {
			loadEnemies("data/Enemies.txt");
		} catch (NumberFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    
    private void loadEnemies(String path) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
         
        while ((line = br.readLine()) != null) {
            String info[] = line.split(",");
            //Enemy actual = new Enemy(new Image(info[1]), Integer.parseInt(info[2]), Integer.parseInt(info[2]), Boolean.parseBoolean(info[4]), Integer.parseInt(info[5]), Double.parseDouble(info[6]));
            //enemies.add(actual);
        }
     
	}

	protected void upload() {
		
		time+=0.016;
		
		shoots.forEach(s->{
			s.moveRight();
			SoundThread shootEffect =new SoundThread("media/soundtrack/shoot.wav", true);
			shootEffect.start();
		});
		
		/*enemies.forEach(e->{
			gamePane.getChildren().add(e);
			e.moveLeft();
			SoundThread fallEffect = new SoundThread("", true);
			fallEffect.start();
		});
		
		if(time%1==0 && time > 10) {
			Bonus position = new Bonus(new Image("File:media/enviroment/spaceShip.png", 20, 20, true, false), 30, 30, true, 1, 6); 
			addBonus(position, first);
			Random r = new Random();
			double y = r.nextInt((int) (principalContainer.getHeight()/2));
			gamePane.getChildren().add(position);
			position.setY(y);
			position.setX(principalContainer.getWidth());
			position.moveLeft();
		}*/
		int counter1 = 0;
		if(gamePane.getChildren().size()!=counter1) {
			//generateTree(root, 0);
		}	
		
	}

	private void addBonus(Bonus b, Bonus current ) {
		if(current == null) {
			current = b;
			current.setNext(b);
			current.setPrev(b);
		}else {
			current.getPrev().setNext(b);
			current.getPrev().getNext().setNext(current);
			current.getPrev().getNext().setPrev(current.getPrev());
			current.setPrev(b);
		}
		
	}
	
	private void generateTree(GameObject current, int position){
		
		if(root==null) {
			root=player;
			objectList.add(root);
			generateTree(root, 0);
		}if(!objectList.containsAll(enemies)){
			if(!objectList.contains(enemies.get(position))) {
				if(current.compareTo(enemies.get(position))==1) {
					objectList.add(enemies.get(position));
					if(current.getRight()==null) {
						current.setRight(enemies.get(position));
						generateTree(root, position++);
					}else {
						generateTree(current.getRight(),position);
					}
				}else {
					objectList.add(enemies.get(position));
					if(current.getLeft()==null) {
						current.setLeft(enemies.get(position));
						generateTree(root, position++);
					}else {
						generateTree(current.getLeft(), position);
					}
				}
			}
		}else if(!objectList.containsAll(shoots)) {
			if(!objectList.contains(shoots.get(position))) {
				if(current.compareTo(shoots.get(position))==1) {
					objectList.add(shoots.get(position));
					if(current.getRight()==null) {
						current.setRight(shoots.get(position));
						generateTree(root, position++);
					}else {
						generateTree(current.getRight(),position);
					}
				}else {
					objectList.add(shoots.get(position));
					if(current.getLeft()==null) {
						current.setLeft(shoots.get(position));
						generateTree(root, position++);
					}else {
						generateTree(current.getLeft(), position);
					}
				}
			}
		}
		if(objectList.containsAll(enemies)&& objectList.containsAll(shoots)) {
			generateTree(root,0);
		}
	}

	public void NodesAlignment() {
    	informationBox.setPrefWidth(350);
    	Image img = new Image("File:media/enviroment/back.jpg", gamePane.getWidth(), gamePane.getHeight(),true,true);
		BackgroundImage staticImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);
		gamePane.setBackground(new Background(staticImg));
		
		player = new SpaceShip(new Image("File:media/enviroment/spaceShip.png", 100, 100, true, false), 100, 100, true, 3, 10);
		
		principalContainer.getChildren().add(player);
		player.setTranslateY(principalContainer.getHeight()/2-player.getHeight()/2);
		
		player.getScene().setOnKeyPressed(e -> move(e));
		
    }
}