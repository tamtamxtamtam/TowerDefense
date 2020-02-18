package TowerDefense.Button;

import TowerDefense.Background;
import TowerDefense.Entity.Enemy.CreateEnemy;
import TowerDefense.Entity.Player.GameUpdate;
import TowerDefense.Entity.Player.PlayStage;
import TowerDefense.Sound.BackgroundSound;
import TowerDefense.Sound.GameOver;
import TowerDefense.Sound.Victory;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.awt.*;

import static TowerDefense.Button.Cancel.setCancelButton;
import static TowerDefense.Button.Image.*;

public class MenuButton {


    public static void StartButton(GraphicsContext gc, Group root, Scene scene) {
        Button startButton = new Button();
        startButton.setGraphic(StartImageViewPink());
        startButton.setLayoutX(600);
        startButton.setLayoutY(450);
        root.getChildren().add(startButton);
        startButton.setStyle("-fx-background-color: transparent");

        /**Tạo hiệu ứng cho nút start**/
        startButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                startButton.setGraphic(StartImageViewBlack());
            }
        });
        startButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                startButton.setGraphic(StartImageViewPink());
            }
        });

        startButton.setOnAction(event -> {
            startButton.setVisible(false);
            //getMAP_LAND();
            PlayStage.startStage.status = false;
            PlayStage.stage1.status = true;

            Button towerButton = new Button();
            Button towerButton2 = new Button();
            Button towerButton3 = new Button();
            Button pauseButton = new Button();
            Button levelButton = new Button();
            Button resumeButton = new Button();
            Button cancelButton = new Button();

            Tower1.setTowerButton(gc, root, scene, towerButton);
            Tower2.setTowerButton(gc, root, scene, towerButton2);
            Tower3.setTowerButton(gc, root, scene, towerButton3);
            PauseButton(gc, root, scene, pauseButton);
            setLevelButton(gc, root, scene, levelButton);
            setResumeButton(gc, root, scene, resumeButton);
            setCancelButton(gc, root,scene, cancelButton);

            Font font = new Font("TUV Noh Carbone", 20);

            Text textPoint = new Text();
            textPoint.setX(200);
            textPoint.setY(30);
            textPoint.setFont(font);
            root.getChildren().add(textPoint);

            Text textHeart = new Text();
            textHeart.setX(75);
            textHeart.setY(93);
            textHeart.setFont(font);
            root.getChildren().add(textHeart);

            Text textCoin = new Text();
            textCoin.setX(75);
            textCoin.setY(38);
            textCoin.setFont(font);
            root.getChildren().add(textCoin);

            Text textEnemy1Price = new Text();
            textEnemy1Price.setX(1400);
            textEnemy1Price.setY(150);
            textEnemy1Price.setFont(font);
            root.getChildren().add(textEnemy1Price);

            Text textEnemy1Sell = new Text();
            textEnemy1Sell.setX(1400);
            textEnemy1Sell.setY(175);
            textEnemy1Sell.setFont(font);
            root.getChildren().add(textEnemy1Sell);

            Text textEnemy2Price = new Text();
            textEnemy2Price.setX(1400);
            textEnemy2Price.setY(300);
            textEnemy2Price.setFont(font);
            root.getChildren().add(textEnemy2Price);

            Text textEnemy2Sell = new Text();
            textEnemy2Sell.setX(1400);
            textEnemy2Sell.setY(320);
            textEnemy2Sell.setFont(font);
            root.getChildren().add(textEnemy2Sell);

            Text textEnemy3Price = new Text();
            textEnemy3Price.setX(1400);
            textEnemy3Price.setY(440);
            textEnemy3Price.setFont(font);
            root.getChildren().add(textEnemy3Price);

            Text textEnemy3Sell = new Text();
            textEnemy3Sell.setX(1400);
            textEnemy3Sell.setY(460);
            textEnemy3Sell.setFont(font);
            root.getChildren().add(textEnemy3Sell);

            Font fontEnding = new Font("TUV Noh Carbone", 50);

            Text textGameOver = new Text();
            textGameOver.setX(700);
            textGameOver.setY(350);
            textGameOver.setFont(fontEnding);
            root.getChildren().add(textGameOver);

            Text textVictory = new Text();
            textVictory.setX(700);
            textVictory.setY(350);
            textVictory.setFont(fontEnding);
            root.getChildren().add(textVictory);

            textEnemy1Price.setText("Buy: $100");
            textEnemy1Sell.setText("Sell: $100");
            textEnemy2Price.setText("Buy: $200");
            textEnemy2Sell.setText("Sell: $100");
            textEnemy3Price.setText("Buy: $150");
            textEnemy3Sell.setText("Sell: $75");

            startButton.setVisible(false);

            AnimationTimer timer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    if (PlayStage.stage1.status) {
                        textPoint.setText(String.valueOf(GameUpdate.pointArchive));
                        textCoin.setText(String.valueOf(GameUpdate.coins));
                        textHeart.setText(String.valueOf(GameUpdate.heart));
                        resumeButton.setVisible(true);
                            if (CreateEnemy.enemyList.isEmpty()) {
                                resumeButton.setVisible(false);
                                levelButton.setVisible(true);
                            } else levelButton.setVisible(false);

                            pauseButton.setVisible(false);
                            if (CreateEnemy.getLevel() == -1) resumeButton.setVisible(false);
                            //else resumeButton.setVisible(true);
                            Background.drawMap(gc);
                        }

                    if (PlayStage.stage2.status) {
                        levelButton.setVisible(false);
                        pauseButton.setVisible(true);
                        resumeButton.setVisible(false);

                        Background.drawMap(gc);
                        if (GameUpdate.heart > 0) {
                            GameUpdate.update(gc);
                            if (CreateEnemy.level >= 19 && CreateEnemy.enemyList.isEmpty()){
                                textVictory.setText("VICTORY!");
                            }
                        }
                        else {
                            textGameOver.setText("LOSE!");
                        }

                        textPoint.setText(String.valueOf(GameUpdate.pointArchive));
                        textCoin.setText(String.valueOf(GameUpdate.coins));
                        textHeart.setText(String.valueOf(GameUpdate.heart));

                    }
                    if (PlayStage.startStage.status) {
                        PlayStage.startStage.getStartStage(gc, root, scene);
                        startButton.setVisible(true);
                        towerButton.setVisible(false);
                        towerButton2.setVisible(false);
                        towerButton3.setVisible(false);
                        levelButton.setVisible(false);
                    }
                }

            };
            timer.start();
            BackgroundSound.gameMusic();
            Victory.victory();
            GameOver.gameOver();
            CreateEnemy.createEnemyByLevel(CreateEnemy.level);

        });
    }

    public static void PauseButton(GraphicsContext gc, Group root, Scene scene, Button pauseButton) {

        pauseButton.setGraphic(PauseImageViewPink());
        pauseButton.setLayoutX(1200);
        pauseButton.setLayoutY(650);
        root.getChildren().add(pauseButton);
        pauseButton.setStyle("-fx-background-color: transparent");
        //Tạo hiệu ứng cho nút pause
        pauseButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                pauseButton.setGraphic(PauseImageViewBlack());
            }
        });
        pauseButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                pauseButton.setGraphic(PauseImageViewPink());
            }
        });

        pauseButton.setOnAction(event -> {
            pauseButton.setVisible(false);
            PlayStage.startStage.status = false;
            PlayStage.stage1.status = true;
            PlayStage.stage2.status = false;

        });
    }

    public static void setLevelButton(GraphicsContext gc, Group root, Scene scene, Button levelButton) {

        levelButton.setGraphic(LevelImageViewPink());
        levelButton.setLayoutX(1100);
        levelButton.setLayoutY(450);
        root.getChildren().add(levelButton);
        levelButton.setStyle("-fx-background-color: transparent");

        levelButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                levelButton.setGraphic(LevelImageViewBlack());
            }
        });
        levelButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                levelButton.setGraphic(LevelImageViewPink());
            }
        });

        levelButton.setOnAction(event -> {
            levelButton.setVisible(false);

            CreateEnemy.setLevel(CreateEnemy.getLevel() + 1);
            CreateEnemy.createEnemyByLevel(CreateEnemy.level);

            PlayStage.stage2.status = true;
            PlayStage.stage1.status = false;
            PlayStage.startStage.status = false;
        });
    }

    public static void setResumeButton(GraphicsContext gc, Group root, Scene scene, Button resumeButton){
        resumeButton.setGraphic(StartImageViewPink());
        resumeButton.setLayoutX(1200);
        resumeButton.setLayoutY(650);
        root.getChildren().add(resumeButton);
        resumeButton.setStyle("-fx-background-color: transparent");

        /**Tạo hiệu ứng cho nút start**/
        resumeButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                resumeButton.setGraphic(StartImageViewBlack());
            }
        });
        resumeButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                resumeButton.setGraphic(StartImageViewPink());
            }
        });

        resumeButton.setOnAction(event ->{
            PlayStage.stage2.status = true;
            PlayStage.stage1.status = false;
            PlayStage.startStage.status = false;
        });
    }

    public static Point find(int x, int y){
        Point point = new Point();
        int i =  x / 31;
        int j = (y - 49)/16;
        if (i >= 0 && i <= 37 && j >= 0 && j <= 37){
            if ((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0))  {
                double a =  Math.sqrt((x%31)*(x%31) + ((y-49)%16)*((y-49)%16));
                if (Math.asin((x%31)/a) <= Math.sin(31/a)){

                    point.x = i;
                    point.y = j ;
                }
                else {

                    point.x = i-1 ;
                    point.y = j-1;
                }
            }
            else  {
                double a = Math.sqrt((31-x%31)*(31-x%31) + ((y-49)%16)*((y-49)%16));
                if (Math.asin((31-(x)%31)/a) <= Math.sin(31/a)){

                    point.x = i;
                    point.y = j-1;
                }
                else {

                    point.x = i-1;
                    point.y = j;
                }
            }
        }
        return point;
    }

}

