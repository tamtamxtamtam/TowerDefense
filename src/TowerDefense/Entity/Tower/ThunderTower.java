package TowerDefense.Entity.Tower;

import TowerDefense.Entity.Enemy.Enemy;
import TowerDefense.Entity.Player.GameUpdate;
import TowerDefense.Game;
import javafx.animation.FadeTransition;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.awt.*;

public class ThunderTower extends Tower {
    public ThunderTower(){

    }

    public static Tower createTower(int x, int y) {
        ThunderTower tower = new ThunderTower();
        tower.i = x;
        tower.j = y;
        tower.setX((tower.j * 31 + 62 - 46 - 15));
        tower.setY((tower.i * 16 + 49 + 32 - 71 - 15));
        tower.fireRange = 1;
        tower.setPrice(200);
        //tower.speed = 3;
        //tower.direction = Direction.UP;
        tower.setImage(new Image("file:Isometric/527.png"));
        return tower;
    }

    public static void drawBullet(Tower tower, Enemy enemy) {
        int x = Math.abs(tower.getX() - enemy.getX());
        int y = Math.abs(tower.getY() - enemy.getY());
        Point pointMin = new Point(Math.min(tower.getX() + 23, enemy.getX() + 23), Math.min(tower.getY(), enemy.getY()));
        Point pointMax = new Point(Math.max(tower.getX() + 23, enemy.getX() + 23), Math.max(tower.getY(), enemy.getY()));
        Point pointMiddle = new Point((tower.getX() + 23 + enemy.getX() + 23) / 2, (tower.getY() + enemy.getY()) / 2);

        pointMin.x = pointMiddle.x - (int) ((pointMiddle.x - pointMin.x) / 2 * Math.random());
        pointMin.y = pointMiddle.y - (int) ((pointMiddle.y - pointMin.y) / 2 * Math.random());

        pointMax.x = pointMiddle.x + (int) ((pointMax.x - pointMiddle.x) / 2 * Math.random());
        pointMax.y = pointMiddle.y + (int) ((pointMax.y - pointMiddle.y) / 2 * Math.random());

        if (enemy.getHealth() > 0 && enemy.getCheck()) {
            Bloom bloom = new Bloom(1.0);
            GaussianBlur blur = new GaussianBlur();
            blur.setInput(bloom);

            if (tower.getX() < enemy.getX() && tower.getY() < enemy.getY()) {
                Line lineStart = new Line(tower.getX() + 23, tower.getY(), pointMin.x, pointMin.y - 3);
                Line lineMiddle = new Line(pointMin.x, pointMin.y - 3, pointMax.x, pointMax.y + 3);
                Line lineEnd = new Line(pointMax.x, pointMax.y + 3, enemy.getX() + 23, enemy.getY());
                lineStart.setStroke(javafx.scene.paint.Color.WHITESMOKE);
                lineMiddle.setStroke(javafx.scene.paint.Color.WHITESMOKE);
                lineEnd.setStroke(javafx.scene.paint.Color.WHITESMOKE);
                lineStart.setEffect(blur);
                lineMiddle.setEffect(blur);
                lineEnd.setEffect(blur);
                lineStart.setStrokeWidth(3);
                lineMiddle.setStrokeWidth(3);
                lineEnd.setStrokeWidth(3);
                if (enemy.getHealth() > 0 && enemy.getCheck()) {
                    FadeTransition pathTransition = new FadeTransition();
                    pathTransition.setNode(lineStart);
                    pathTransition.setNode(lineMiddle);
                    pathTransition.setNode(lineEnd);
                    pathTransition.setFromValue(0);
                    pathTransition.setToValue(1.0);
                    pathTransition.setDuration(Duration.millis(100));
                    pathTransition.setCycleCount(1);
                    pathTransition.setOnFinished((actionEvent -> {
                        Game.root.getChildren().removeAll(lineStart, lineMiddle, lineEnd);
                        enemy.setHealth(enemy.getHealth() - 1);
                        if (enemy.getHealth() == 0) {
                            GameUpdate.pointArchive += enemy.getPointByHealth();
                            GameUpdate.coins += enemy.getCoinByHealth();
                        }
                    }));
                    pathTransition.play();
                }
                Game.root.getChildren().addAll(lineStart, lineMiddle, lineEnd);
            } else if (tower.getX() > enemy.getX() && tower.getY() < enemy.getY()) {
                Line lineStart = new Line(tower.getX() + 23, tower.getY(), pointMax.x, pointMin.y - 3);
                Line lineMiddle = new Line(pointMax.x, pointMin.y - 3, pointMin.x, pointMax.y + 3);
                Line lineEnd = new Line(pointMin.x, pointMax.y + 3, enemy.getX() + 23, enemy.getY());
                lineStart.setStroke(javafx.scene.paint.Color.WHITESMOKE);
                lineMiddle.setStroke(javafx.scene.paint.Color.WHITESMOKE);
                lineEnd.setStroke(javafx.scene.paint.Color.WHITESMOKE);
                lineStart.setEffect(blur);
                lineMiddle.setEffect(blur);
                lineEnd.setEffect(blur);
                lineStart.setStrokeWidth(3);
                lineMiddle.setStrokeWidth(3);
                lineEnd.setStrokeWidth(3);
                if (enemy.getHealth() > 0 && enemy.getCheck()) {
                    FadeTransition pathTransition = new FadeTransition();
                    pathTransition.setNode(lineStart);
                    pathTransition.setNode(lineMiddle);
                    pathTransition.setNode(lineEnd);
                    pathTransition.setDuration(Duration.millis(100));
                    pathTransition.setCycleCount(1);
                    pathTransition.setOnFinished((actionEvent -> {
                        Game.root.getChildren().removeAll(lineStart, lineMiddle, lineEnd);
                        enemy.setHealth(enemy.getHealth() - 1);
                        if (enemy.getHealth() == 0) {
                            GameUpdate.pointArchive += enemy.getPointByHealth();
                            GameUpdate.coins += enemy.getCoinByHealth();
                        }
                    }));
                    pathTransition.play();
                }
                Game.root.getChildren().addAll(lineStart, lineMiddle, lineEnd);
            } else if (tower.getX() < enemy.getX() && tower.getY() > enemy.getY()) {
                Line lineStart = new Line(tower.getX() + 23, tower.getY(), pointMin.x, pointMax.y + 3);
                Line lineMiddle = new Line(pointMin.x, pointMax.y + 3, pointMax.x, pointMin.y - 3);
                Line lineEnd = new Line(pointMax.x, pointMin.y - 3, enemy.getX() + 23, enemy.getY());
                lineStart.setStroke(javafx.scene.paint.Color.WHITESMOKE);
                lineMiddle.setStroke(javafx.scene.paint.Color.WHITESMOKE);
                lineEnd.setStroke(javafx.scene.paint.Color.WHITESMOKE);
                lineStart.setEffect(blur);
                lineMiddle.setEffect(blur);
                lineEnd.setEffect(blur);
                lineStart.setStrokeWidth(3);
                lineMiddle.setStrokeWidth(3);
                lineEnd.setStrokeWidth(3);
                if (enemy.getHealth() > 0 && enemy.getCheck()) {
                    FadeTransition pathTransition = new FadeTransition();
                    pathTransition.setNode(lineStart);
                    pathTransition.setNode(lineMiddle);
                    pathTransition.setNode(lineEnd);
                    pathTransition.setDuration(Duration.millis(100));
                    pathTransition.setCycleCount(1);
                    pathTransition.setOnFinished((actionEvent -> {
                        Game.root.getChildren().removeAll(lineStart, lineMiddle, lineEnd);
                        enemy.setHealth(enemy.getHealth() - 1);
                        if (enemy.getHealth() == 0) {
                            GameUpdate.pointArchive += enemy.getPointByHealth();
                            GameUpdate.coins += enemy.getCoinByHealth();
                        }
                    }));
                    pathTransition.play();
                }
                Game.root.getChildren().addAll(lineStart, lineMiddle, lineEnd);

            } else if (tower.getX() > enemy.getX() && tower.getY() > enemy.getY()) {
                Line lineStart = new Line(tower.getX() + 23, tower.getY(), pointMax.x, pointMax.y - 3);
                Line lineMiddle = new Line(pointMax.x, pointMax.y - 3, pointMin.x, pointMin.y + 3);
                Line lineEnd = new Line(pointMin.x, pointMin.y + 3, enemy.getX() + 23, enemy.getY());
                lineStart.setStroke(javafx.scene.paint.Color.WHITESMOKE);
                lineMiddle.setStroke(javafx.scene.paint.Color.WHITESMOKE);
                lineEnd.setStroke(Color.WHITESMOKE);
                lineStart.setEffect(blur);
                lineMiddle.setEffect(blur);
                lineEnd.setEffect(blur);
                lineStart.setStrokeWidth(3);
                lineMiddle.setStrokeWidth(3);
                lineEnd.setStrokeWidth(3);
                if (enemy.getHealth() > 0 && enemy.getCheck()) {
                    FadeTransition pathTransition = new FadeTransition();
                    pathTransition.setNode(lineStart);
                    pathTransition.setNode(lineMiddle);
                    pathTransition.setNode(lineEnd);
                    pathTransition.setDuration(Duration.millis(100));
                    pathTransition.setCycleCount(1);
                    pathTransition.setOnFinished((actionEvent -> {
                        Game.root.getChildren().removeAll(lineStart, lineMiddle, lineEnd);
                        enemy.setHealth(enemy.getHealth() - 1);
                        if (enemy.getHealth() == 0) {
                            GameUpdate.pointArchive += enemy.getPointByHealth();
                            GameUpdate.coins += enemy.getCoinByHealth();
                        }
                    }));
                    pathTransition.play();
                }
                Game.root.getChildren().addAll(lineStart, lineMiddle, lineEnd);
            }
        }
    }
}
