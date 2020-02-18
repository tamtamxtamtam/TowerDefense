package TowerDefense.Button;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class Tower1 extends TowerButton {


    public static void setTowerButton(GraphicsContext gc, Group root, Scene scene, Button towerButton){
        towerButton.setGraphic(TowerImageView("file:Isometric/464.png"));
        towerButton.setLayoutX(1400);
        towerButton.setLayoutY(50);
        root.getChildren().add(towerButton);
        towerButton.setStyle("-fx-background-color: pink");


        towerButton.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                //MouseButton button = event.getButton();
                //if (button == MouseButton.PRIMARY) {
                status = 11;
                Image image = new Image("file:Isometric/464.png");
                ImageView imageView = new ImageView(image);

                imageView.setX(event.getSceneX()-23);
                imageView.setY(event.getSceneY()-35.5);

                if (status == 11){
                    drag(gc, root, scene, imageView);
                    drop(gc, root, scene, imageView );
                    root.getChildren().add(imageView);
                }
                if (status == 2) root.getChildren().remove(imageView);
                //}


            }
        });

    }
}
