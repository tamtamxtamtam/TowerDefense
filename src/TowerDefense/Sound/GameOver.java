package TowerDefense.Sound;

import TowerDefense.Entity.Player.GameUpdate;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class GameOver {
    private static MediaPlayer mediaPlayer;

    public static void gameOver() {
        String musicFile = "gameover.mp3";

        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.2);
        if (GameUpdate.heart <= 0) mediaPlayer.play();
    }
}
