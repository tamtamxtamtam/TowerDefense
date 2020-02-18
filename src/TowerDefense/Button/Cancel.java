package TowerDefense.Button;

import TowerDefense.Entity.Player.GameUpdate;
import TowerDefense.Land.Land;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.awt.*;

import static TowerDefense.Entity.Tower.CreateTower.towerList;



public class Cancel {

    public static boolean status ;
    public static void dragc(GraphicsContext gc, Group root, Scene scene, ImageView imageView){


        scene.setOnMouseMoved(event -> {
            //if (status == 1) {

            imageView.setX(event.getSceneX()-23);
            imageView.setY(event.getSceneY()-35.5);
            //root.getChildren().add(imageView);
            //gc.drawImage(image,event.getSceneX()-23,event.getSceneX()-23);
            // }

        });
    }

    public static void dropc(GraphicsContext gc, Group root, Scene scene, ImageView imageView){
        scene.setOnMousePressed(event -> {
            //if (status == 1) {
            root.getChildren().remove(imageView);
            Point a = MenuButton.find((int)event.getSceneX(), (int) event.getSceneY());
            for (int k = 0; k < towerList.size(); k++) {
                if (towerList.get(k).i == a.y && towerList.get(k).j == a.x) {
                    GameUpdate.coins += towerList.get(k).getPrice() / 2;
                    towerList.remove(k);
                    Land.CHECK[a.y][a.x] = true;
                    //integers.remove(integers.size() - 1);
                    //i--;
                    //System.out.println(1);
                }

                /*if (Land.CHECK[a.y][a.x]){
                    towerList.add(Tower.createTower(a.y, a.x));
                    Land.CHECK[a.y][a.x] = false;
                }

                 */



                status = false;
            }

        });

    }

    public static void setCancelButton(GraphicsContext gc, Group root, Scene scene, Button cancelButton){
        cancelButton.setGraphic(new ImageView(new Image("file:Isometric/005.png")));
        cancelButton.setLayoutX(1400);
        cancelButton.setLayoutY(470);
        cancelButton.setStyle("-fx-background-color: pink");
        root.getChildren().add(cancelButton);
        cancelButton.setOnMousePressed(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event){
                status = true;
                Image image = new Image("file:LineLight/LineLight45.png");
                ImageView imageView = new ImageView(image);

                imageView.setX(event.getSceneX() - 23);
                imageView.setY(event.getSceneY() - 35.5);

                if (status == true) {
                    dragc(gc, root, scene, imageView);
                    dropc(gc, root, scene, imageView);
                    root.getChildren().add(imageView);
                }
                if (status == false) root.getChildren().remove(imageView);
                //if (status == false)
                //root.getChildren().remove(imageView);


            /*for (int k = 0; k < enemyList.size(); k++) {
                if (!enemyList.get(k).getCheck()) {
                    enemyList.remove(k);
                    integers.remove(integers.size() - 1);
                    i--;
                    //System.out.println(1);
                }
            }

             */
            }
        });

    }

}
