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

public class IceTower extends Tower{
    public IceTower(){

    }
    public static Tower createTower(int x, int y) {
        IceTower tower = new IceTower();
        tower.i = x;
        tower.j = y;
        tower.setX((tower.j * 31 + 62 - 46 - 15));
        tower.setY((tower.i * 16 + 49 + 32 - 71 - 15));
        tower.fireRange = 1;
        tower.setPrice(150);
        //tower.speed = 3;
        //tower.direction = Direction.UP;
        tower.setImage(new Image("file:Isometric/530.png"));
        return tower;
    }

    public static void drawBullet(Tower tower, Enemy enemy){
        Line line = new Line(tower.getX() + 23 , tower.getY(), enemy.getX() + 23, enemy.getY());
        Circle circle = new Circle();
        circle.setFill(Color.ALICEBLUE);
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
                enemy.setCheckSpeed(true);
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
