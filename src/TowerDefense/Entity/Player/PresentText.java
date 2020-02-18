package TowerDefense.Entity.Player;

import TowerDefense.Game;
import javafx.scene.text.Text;

public class PresentText {
    public static void createDataPlayer(){
        Text text = new Text();
        text.setText(String.valueOf(GameUpdate.pointArchive));
        text.setX(100);
        text.setY(100);
        Game.root.getChildren().add(text);

    }
}
