package TowerDefense.Button;

import TowerDefense.Entity.Player.GameUpdate;
import TowerDefense.Entity.Tower.*;
import TowerDefense.Land.Land;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;

public class TowerButton {
    public static ImageView TowerImageView(String link) {
        Image image = new Image(link);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(image.getHeight());
        imageView.setFitWidth(image.getWidth());
        return imageView;

    }

    public static int status = 0;
    /** 0: chưa ấn
     11: đang kéo thả tower1
     12: dang keo tha tower2
     13: dang keo tha tower3
     2: ấn nhận vị trí*/

    public static void drag(GraphicsContext gc, Group root, Scene scene, ImageView imageView){

        scene.setOnMouseMoved(event -> {
            if (status == 11 || status == 12 || status == 13) {

                imageView.setX(event.getSceneX()-23);
                imageView.setY(event.getSceneY()-35.5);
                //root.getChildren().add(imageView);
                //gc.drawImage(image,event.getSceneX()-23,event.getSceneX()-23);
            }

        });
    }
    public static void drop(GraphicsContext gc, Group root, Scene scene, ImageView imageView){
        scene.setOnMousePressed(event -> {
            /*if (status != 0 && status != 2) {
                root.getChildren().remove(imageView);
                Point a = MenuButton.find((int)event.getSceneX(), (int) event.getSceneY()+32);
                if (Land.CHECK[a.y][a.x] && gameUpdate.coins >= createTower.createTowerByOrder(status, a.y, a.x){
                    createTower.createTowerByOrder(status, a.y, a.x);
                    Land.CHECK[a.y][a.x] = false;
                }

                status = 0;
            }*/


            if (status == 11 && GameUpdate.coins >= 100) {
                Point a = MenuButton.find((int)event.getSceneX(), (int) event.getSceneY()+32);
                //towerList.add(TowerBullet.createTower(a.y, a.x));
                if (Land.CHECK[a.y][a.x]){
                    CreateTower.createTowerByOrder(11, a.y, a.x);
                    GameUpdate.coins -= 100;
                    Land.CHECK[a.y][a.x] = false;
                    status = 0;
                }
            }

            if (status == 12 && GameUpdate.coins >= 200) {
                Point a = MenuButton.find((int)event.getSceneX(), (int) event.getSceneY()+32);
                //towerList.add(TowerThunder.createTower(a.y, a.x));
                if (Land.CHECK[a.y][a.x]){
                    CreateTower.createTowerByOrder(12, a.y, a.x);
                    GameUpdate.coins -= 200;
                    Land.CHECK[a.y][a.x] = false;
                }
            }

            if (status == 13 && GameUpdate.coins >= 150) {
                Point a = MenuButton.find((int)event.getSceneX(), (int) event.getSceneY()+32);
                //towerList.add(TowerIce.createTower(a.y, a.x));
                if (Land.CHECK[a.y][a.x]){
                    CreateTower.createTowerByOrder(13, a.y, a.x);
                    GameUpdate.coins -= 150;
                    Land.CHECK[a.y][a.x] = false;
                }
            }
            status = 0;
            root.getChildren().remove(imageView);

        });

    }



}
