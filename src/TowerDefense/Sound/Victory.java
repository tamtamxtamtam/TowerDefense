package TowerDefense.Sound;

import TowerDefense.Entity.Enemy.CreateEnemy;
import TowerDefense.Entity.Player.GameUpdate;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Victory {
    private static MediaPlayer mediaPlayer;

    public static void victory() {
        String musicFile = "levelUp.mp3";

        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.2);
        if (CreateEnemy.level >= 19 && GameUpdate.heart > 0) mediaPlayer.play();
    }
}
