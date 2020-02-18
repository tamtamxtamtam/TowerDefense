package TowerDefense.Entity.Tower;

import TowerDefense.Entity.Enemy.Enemy;
import TowerDefense.Entity.Player.GameUpdate;
import TowerDefense.Game;
import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class BulletTower extends Tower{
    public BulletTower(){

    }
    public static Tower createTower(int x, int y) {
        BulletTower tower = new BulletTower();
        tower.i = x;
        tower.j = y;
        tower.setX((tower.j * 31 + 62 - 46 - 5));
        tower.setY((tower.i * 16 + 49 + 32 - 71 - 5));
        tower.fireRange = 1;
        tower.setPrice(100);
        //tower.speed = 3;
        //tower.direction = Direction.UP;
        tower.setImage(new Image("file:Isometric/464.png"));
        return tower;
    }

    public static void drawBullet(Tower tower, Enemy enemy){
        Line line = new Line(tower.getX() + 23 , tower.getY(), enemy.getX() + 23, enemy.getY());
        Circle circle = new Circle();
        circle.setFill(Color.RED);
        circle.setRadius(3);
        circle.setCenterX(-10);
        circle.setCenterY(-10);

        if (enemy.getHealth() > 0 && enemy.getCheck() == true) {
            PathTransition pathTransition = new PathTransition();
            //if (circle.getCenterX() == enemy.getX() + 23 && circle.getCenterY() - 3== enemy.getY()) //Game.root.getChildren().remove(circle);
            //System.out.println(circle.getCenterX() + " " + enemy.getX() + 23);
            pathTransition.setNode(circle);
            pathTransition.setDuration(Duration.millis(300));
            pathTransition.setPath(line);
            pathTransition.setCycleCount(1);
            pathTransition.setOnFinished((actionEvent -> {
                Game.root.getChildren().remove(circle);
                enemy.setHealth(enemy.getHealth() - 1);
                if (enemy.getHealth() == 0) {
                    GameUpdate.pointArchive += enemy.getPointByHealth();
                    GameUpdate.coins += enemy.getCoinByHealth();
                }
            }));
            pathTransition.play();
        }
        Game.root.getChildren().add(circle);
        //Game.root.getChildren().add(shape);
    }
}
