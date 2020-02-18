package TowerDefense.Entity.Player;

import TowerDefense.Entity.Enemy.*;
import TowerDefense.Entity.Tower.*;
import TowerDefense.Game;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.awt.*;

public class GameUpdate {
    public static int pointArchive = 0;
    public static int coins = 200;
    public static int heart = 30;
    public static void update(GraphicsContext gc) {
        CreateEnemy.enemyMove();
        long[] timePrevious = new long[CreateTower.towerList.size()];
        for (int i = 0; i < CreateTower.towerList.size(); i++) {
            double minDistance = 10000;
            for (int j = 0; j < CreateEnemy.enemyList.size(); j++) {
                double distance = CreateTower.towerList.get(i).distanceEnemy(CreateEnemy.enemyList.get(j));
                if (CreateTower.towerList.get(i).shotRange(CreateEnemy.enemyList.get(j))) {
                    //System.out.println(createTower.towerList.get(i).getX() + " " + createEnemy.enemyList.get(j).getX() + " " + j + " " + createTower.towerList.get(i).getY() + " " + createEnemy.enemyList.get(j).getY() + " " + createEnemy.enemyList.get(j).getCheck());
                    if (distance <= minDistance) minDistance = distance;
                }
                // Neu khoang cach giua tower va enemy ngan nhat thi enemy bi tru mau
                if (System.nanoTime() - timePrevious[i] >= 1200000000){
                    if (minDistance == distance){
                        if (CreateTower.towerList.get(i) instanceof BulletTower) BulletTower.drawBullet(CreateTower.towerList.get(i), CreateEnemy.enemyList.get(j));
                        else if (CreateTower.towerList.get(i) instanceof ThunderTower) ThunderTower.drawBullet(CreateTower.towerList.get(i), CreateEnemy.enemyList.get(j));
                        else IceTower.drawBullet(CreateTower.towerList.get(i), CreateEnemy.enemyList.get(j));
                        timePrevious[i] = System.nanoTime();
                    }
                }
            }
        }
        //System.out.println(createEnemy.level);
    }

    private static void drawLine(GraphicsContext gc,Tower tower, Enemy enemy) {
        Point pointMin = new Point(Math.min(tower.getX() + 23, enemy.getX() + 23), Math.min(tower.getY(), enemy.getY()));
        Point pointMax = new Point(Math.max(tower.getX() + 23, enemy.getX() + 23), Math.max(tower.getY(), enemy.getY()));
        Point pointMiddle = new Point((tower.getX() + 23 + enemy.getX() + 23) / 2, (tower.getY() + enemy.getY()) / 2);

        pointMin.x = pointMiddle.x - (int) ((pointMiddle.x - pointMin.x) / 2 * Math.random());
        pointMin.y = pointMiddle.y - (int) ((pointMiddle.y - pointMin.y) / 2 * Math.random());

        pointMax.x = pointMiddle.x + (int) ((pointMax.x - pointMiddle.x) / 2 * Math.random());
        pointMax.y = pointMiddle.y + (int) ((pointMax.y - pointMiddle.y) / 2 * Math.random());

        if (enemy.getHealth() > 0 && enemy.getCheck()) {
            if (tower.getX() < enemy.getX() && tower.getY() < enemy.getY()) {
                gc.strokeLine(tower.getX() + 23, tower.getY(), pointMin.x, pointMin.y - 3);
                gc.strokeLine(pointMin.x, pointMin.y - 3, pointMax.x, pointMax.y + 3);
                gc.strokeLine(pointMax.x, pointMax.y + 3, enemy.getX() + 23, enemy.getY());
                enemy.setHealth(enemy.getHealth() - 1);
            } else if (tower.getX() > enemy.getX() && tower.getY() < enemy.getY()) {
                gc.strokeLine(tower.getX() + 23, tower.getY(), pointMax.x, pointMin.y - 3);
                gc.strokeLine(pointMax.x, pointMin.y - 3, pointMin.x, pointMax.y + 3);
                gc.strokeLine(pointMin.x, pointMax.y + 3, enemy.getX() + 23, enemy.getY());
                enemy.setHealth(enemy.getHealth() - 1);
            } else if (tower.getX() < enemy.getX() && tower.getY() > enemy.getY()) {
                gc.strokeLine(tower.getX() + 23, tower.getY(), pointMin.x, pointMax.y + 3);
                gc.strokeLine(pointMin.x, pointMax.y + 3, pointMax.x, pointMin.y - 3);
                gc.strokeLine(pointMax.x, pointMin.y - 3, enemy.getX() + 23, enemy.getY());
                enemy.setHealth(enemy.getHealth() - 1);

            } else if (tower.getX() > enemy.getX() && tower.getY() > enemy.getY()) {
                gc.strokeLine(tower.getX() + 23, tower.getY(), pointMax.x, pointMax.y - 3);
                gc.strokeLine(pointMax.x, pointMax.y - 3, pointMin.x, pointMin.y + 3);
                gc.strokeLine(pointMin.x, pointMin.y + 3, enemy.getX() + 23, enemy.getY());
                enemy.setHealth(enemy.getHealth() - 1);

            }
        }
    }

    private static void drawLine1(GraphicsContext gc,Tower tower, Enemy enemy) {
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
                lineStart.setStroke(Color.WHITESMOKE);
                lineMiddle.setStroke(Color.WHITESMOKE);
                lineEnd.setStroke(Color.WHITESMOKE);
                lineStart.setEffect(blur);
                lineMiddle.setEffect(blur);
                lineEnd.setEffect(blur);
                lineStart.setStrokeWidth(3);
                lineMiddle.setStrokeWidth(3);
                lineEnd.setStrokeWidth(3);
                if (enemy.getHealth() > 0 && enemy.getCheck() == true) {
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
                    }));
                    pathTransition.play();
                }
                Game.root.getChildren().addAll(lineStart, lineMiddle, lineEnd);
            } else if (tower.getX() > enemy.getX() && tower.getY() < enemy.getY()) {
                Line lineStart = new Line(tower.getX() + 23, tower.getY(), pointMax.x, pointMin.y - 3);
                Line lineMiddle = new Line(pointMax.x, pointMin.y - 3, pointMin.x, pointMax.y + 3);
                Line lineEnd = new Line(pointMin.x, pointMax.y + 3, enemy.getX() + 23, enemy.getY());
                lineStart.setStroke(Color.WHITESMOKE);
                lineMiddle.setStroke(Color.WHITESMOKE);
                lineEnd.setStroke(Color.WHITESMOKE);
                lineStart.setEffect(blur);
                lineMiddle.setEffect(blur);
                lineEnd.setEffect(blur);
                lineStart.setStrokeWidth(3);
                lineMiddle.setStrokeWidth(3);
                lineEnd.setStrokeWidth(3);
                if (enemy.getHealth() > 0 && enemy.getCheck() == true) {
                    FadeTransition pathTransition = new FadeTransition();
                    pathTransition.setNode(lineStart);
                    pathTransition.setNode(lineMiddle);
                    pathTransition.setNode(lineEnd);
                    pathTransition.setDuration(Duration.millis(100));
                    pathTransition.setCycleCount(1);
                    pathTransition.setOnFinished((actionEvent -> {
                        Game.root.getChildren().removeAll(lineStart, lineMiddle, lineEnd);
                        enemy.setHealth(enemy.getHealth() - 1);
                    }));
                    pathTransition.play();
                }
                Game.root.getChildren().addAll(lineStart, lineMiddle, lineEnd);
            } else if (tower.getX() < enemy.getX() && tower.getY() > enemy.getY()) {
                Line lineStart = new Line(tower.getX() + 23, tower.getY(), pointMin.x, pointMax.y + 3);
                Line lineMiddle = new Line(pointMin.x, pointMax.y + 3, pointMax.x, pointMin.y - 3);
                Line lineEnd = new Line(pointMax.x, pointMin.y - 3, enemy.getX() + 23, enemy.getY());
                lineStart.setStroke(Color.WHITESMOKE);
                lineMiddle.setStroke(Color.WHITESMOKE);
                lineEnd.setStroke(Color.WHITESMOKE);
                lineStart.setEffect(blur);
                lineMiddle.setEffect(blur);
                lineEnd.setEffect(blur);
                lineStart.setStrokeWidth(3);
                lineMiddle.setStrokeWidth(3);
                lineEnd.setStrokeWidth(3);
                if (enemy.getHealth() > 0 && enemy.getCheck() == true) {
                    FadeTransition pathTransition = new FadeTransition();
                    pathTransition.setNode(lineStart);
                    pathTransition.setNode(lineMiddle);
                    pathTransition.setNode(lineEnd);
                    pathTransition.setDuration(Duration.millis(100));
                    pathTransition.setCycleCount(1);
                    pathTransition.setOnFinished((actionEvent -> {
                        Game.root.getChildren().removeAll(lineStart, lineMiddle, lineEnd);
                        enemy.setHealth(enemy.getHealth() - 1);
                    }));
                    pathTransition.play();
                }
                Game.root.getChildren().addAll(lineStart, lineMiddle, lineEnd);

            } else if (tower.getX() > enemy.getX() && tower.getY() > enemy.getY()) {
                Line lineStart = new Line(tower.getX() + 23, tower.getY(), pointMax.x, pointMax.y - 3);
                Line lineMiddle = new Line(pointMax.x, pointMax.y - 3, pointMin.x, pointMin.y + 3);
                Line lineEnd = new Line(pointMin.x, pointMin.y + 3, enemy.getX() + 23, enemy.getY());
                lineStart.setStroke(Color.WHITESMOKE);
                lineMiddle.setStroke(Color.WHITESMOKE);
                lineEnd.setStroke(Color.WHITESMOKE);
                lineStart.setEffect(blur);
                lineMiddle.setEffect(blur);
                lineEnd.setEffect(blur);
                lineStart.setStrokeWidth(3);
                lineMiddle.setStrokeWidth(3);
                lineEnd.setStrokeWidth(3);
                if (enemy.getHealth() > 0 && enemy.getCheck() == true) {
                    FadeTransition pathTransition = new FadeTransition();
                    pathTransition.setNode(lineStart);
                    pathTransition.setNode(lineMiddle);
                    pathTransition.setNode(lineEnd);
                    pathTransition.setDuration(Duration.millis(100));
                    pathTransition.setCycleCount(1);
                    pathTransition.setOnFinished((actionEvent -> {
                        Game.root.getChildren().removeAll(lineStart, lineMiddle, lineEnd);
                        enemy.setHealth(enemy.getHealth() - 1);
                    }));
                    pathTransition.play();
                }
                Game.root.getChildren().addAll(lineStart, lineMiddle, lineEnd);
            }
        }
    }

    private static void drawBullet(Tower tower, Enemy enemy){
        Line line = new Line(tower.getX() + 23 , tower.getY(), enemy.getX() + 23, enemy.getY());
        Circle circle = new Circle();
        circle.setFill(Color.RED);
        circle.setRadius(3);
        circle.setCenterX(-10);
        circle.setCenterY(-10);

        double distance = Math.sqrt(Math.pow(tower.getX() - enemy.getX(), 2) + Math.pow(tower.getY() - enemy.getY(), 2));
        double side = Math.sqrt(distance * distance / 2);

        javafx.scene.shape.Shape shape = javafx.scene.shape.Shape.subtract(new Rectangle(side * 2, side * 2), new Circle(side * 2));
        shape.setTranslateX(enemy.getX());
        shape.setTranslateY(enemy.getY() + side);
        shape.setFill(Color.DARKVIOLET);
        if (enemy.getHealth() > 0 && enemy.getCheck() == true) {
            PathTransition pathTransition = new PathTransition();
            //if (circle.getCenterX() == enemy.getX() + 23 && circle.getCenterY() - 3== enemy.getY()) //Game.root.getChildren().remove(circle);
            //System.out.println(circle.getCenterX() + " " + enemy.getX() + 23);

            pathTransition.setNode(circle);
            pathTransition.setDuration(Duration.millis(50));
            pathTransition.setPath(line);
            pathTransition.setCycleCount(1);
            pathTransition.setOnFinished((actionEvent -> {
                Game.root.getChildren().remove(circle);
                enemy.setHealth(enemy.getHealth() - 1);
            }));
            pathTransition.play();
        }
        Game.root.getChildren().add(circle);
        //Game.root.getChildren().add(shape);
    }

}
