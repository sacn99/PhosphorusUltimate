package ui;

import java.util.List;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
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
	
    @FXML
    private ToolBar toolBar;

    @FXML
    private Pane gamePane;

    @FXML
    private VBox informationBox;
    @FXML
    public void initialize() {
    	informationBox.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
    }
    
    public void NodesAlignment() {
    	informationBox.setPrefWidth(350);
    	Image img = new Image("File:media/enviroment/longSpace.png", gamePane.getWidth(), gamePane.getHeight(),true,true);
		BackgroundImage staticImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);
		gamePane.setBackground(new Background(staticImg));
    }
}
