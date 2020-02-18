package TowerDefense;

import TowerDefense.Button.MenuButton;
import TowerDefense.Entity.Player.PlayStage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game {
    public static GraphicsContext gc;
    public static Canvas canvas;
    public static Scene scene;
    public static Stage stage;
    public static Group root;
    //Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

    //set Stage boundaries to visible bounds of the main screen
 //stage.setX(primaryScreenBounds.getMinX());
 //stage.setY(primaryScreenBounds.getMinY());
 //public double screenWidth = stage.setWidth(primaryScreenBounds.getWidth());
 //public double screenHeight = stage.setHeight(primaryScreenBounds.getHeight());


    public Game() {
        canvas = new Canvas(1500, 720);
        gc = canvas.getGraphicsContext2D();
        root = new Group();
        root.getChildren().add(canvas);
        scene = new Scene(root);
        stage = new Stage();
        scene.setFill(Color.color(0, 0, 0));
        stage.setScene(scene);
        //Background.drawMap(gc);
        //MenuButton.StartButton(gc, root, scene);
        /*for (int i = 0; i < MAP_SPRITES.length; i++) {
            for (int j = 0; j < MAP_SPRITES[i].length; j++) {
                Land land = new Land(i,j);
                MAP_LAND[i][j] = land;
            }
        }

         */
        PlayStage.startStage.getStartStage(gc, root, scene);

        MenuButton.StartButton(gc, root, scene);

    }

    public static Stage getStage() {
        return stage;
    }

}
