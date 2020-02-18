package TowerDefense.Entity.Player;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PlayStage {
    public static class stage2{
        public static boolean status = false;

    }
    public static class stage1{
        public static void getMoney(GraphicsContext gc){
            gc.drawImage(new Image("file:Pictures/coin.png"), 20,10);

        }

        public static void getHeart(GraphicsContext gc){
            gc.drawImage(new Image("file:Pictures/heart.png"), 20, 65);
        }


        public static boolean status = false;

        public static void getStage1(GraphicsContext gc, Group root, Scene scene) {
            gc.drawImage(new Image("file:Pictures/12.png"), 0, 0);
            getMoney(gc);

            //PauseButton(gc, root, scene);
            //TowerButton.TowerButton(gc, root, scene);
            //LevelButton(gc, root, scene);
        }
    }
    public static class startStage{
        public static boolean status = true;
        public static void getStartStage(GraphicsContext gc, Group root, Scene scene){
            gc.drawImage(new Image("file:Pictures/12.png"), 0, 0);
            //StartButton(gc, root, scene);
        }

    }


}
