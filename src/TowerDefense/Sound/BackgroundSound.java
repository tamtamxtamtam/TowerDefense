package TowerDefense.Sound;

import TowerDefense.Entity.Player.GameUpdate;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class BackgroundSound {
    private static MediaPlayer mediaPlayer;

    public static void gameMusic() {
        String musicFile = "samset.mp3";

        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        if (GameUpdate.heart <= 0) mediaPlayer.stop();
    }


}
