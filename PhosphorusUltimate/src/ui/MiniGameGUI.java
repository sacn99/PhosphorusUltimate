package ui;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.*;

public class MiniGameGUI {
	private SpaceShip player;
	private List<Enemy> enemies;
	private AnimationTimer timer;
	//private double t;
    @FXML
    private ToolBar toolBar;

    @FXML
    private Pane gamePane;

    @FXML
    private VBox informationBox;
    
    @FXML
    void windowInteraction(MouseEvent event) {
    	if(event.getSource().equals(toolBar)) {
    		timer.stop();
    	}else if(event.getSource().equals(gamePane)) {
    		timer.start();
    	}else if(event.getSource().equals(informationBox)) {
    		timer.stop();
    	}else {
    		timer.stop();
    	}
    }
    
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
	            shoot(player);
	            break;
		default:
			break;
		}
    }
    
    public void NodesAlignment() {
    	informationBox.setPrefWidth(350);
    	Image img = new Image("File:media/enviroment/fullOfStars.png", gamePane.getWidth(), gamePane.getHeight(),true,true);
		BackgroundImage staticImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);
		gamePane.setBackground(new Background(staticImg));
    }
    
    @FXML
    public void initialize() {
    	Button saveGame = new Button();
    	saveGame.setText("Save Game");
    	toolBar.getChildrenUnmodifiable().add(saveGame);
    	informationBox.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
    	player = new SpaceShip(new ImageView(new Image("File:media/enviroment/spaceShip.png")), 0, 0, 38, 38, true, 3, 5);
    	
    	/*timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                //update();
            }
        };

        timer.start();

        nextLevel();*/
    }
    
    private void nextLevel() {
        for (int i = 0; i < 5; i++) {
            //Enemy s = new Enemy(new ImageView(new Image("File:media/enviroment/spacerock1.png")), gamePane.getWidth(), new Random().nextDouble(), new int[]{38,38} ,true , 1, new Random().nextInt(9)+1);

            //gamePane.getChildren().add(s);
        }
    }
    private List<GameObject> objects() {
        return gamePane.getChildren().stream().map(n -> (GameObject)n).collect(Collectors.toList());
    }
    private void shoot(GameObject shooter) {
    	ImageView bullet = new ImageView(new Image("File:media/enviroment/laserbullet.png", 10, 3, true, false));
        //GameObject s = new GameObject(bullet, (int) shooter.getTranslateX() + 20, (int) shooter.getTranslateY(),new int[] {10, 3}, true, 1, 6);

        //gamePane.getChildren().add(s);
    }
    /*private void update() {
        t += 0.016;

        objects().forEach(s -> {
            switch (s.getClass()) {

                case :
                    s.moveDown();

                    if (s.getBoundsInParent().intersects(player.getBoundsInParent())) {
                        player.setAlive(false);
                        s.setAlive(false); 
                    }
                    break;

                case "playerbullet":
                    s.moveUp();

                    enemies().stream().filter(e -> e.type.equals("enemy")).forEach(enemy -> {
                        if (s.getBoundsInParent().intersects(enemy.getBoundsInParent())) {
                            enemy.dead = true;
                            s.dead = true;
                        }
                    });

                    break;

                case "enemy":

                    if (t > 2) {
                        if (Math.random() < 0.3) {
                            shoot(s);
                        }
                    }

                    break;
            }
        });

        gamePane.getChildren().removeIf(n -> {
            Enemy s = (Enemy) n;
            return s.dead;
        });

        if (t > 2) {
            t = 0;
        }
    }*/
    
  
}
