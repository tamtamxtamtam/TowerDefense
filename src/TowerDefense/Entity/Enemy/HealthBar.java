package TowerDefense.Entity.Enemy;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class HealthBar {
    public static ImageView imageView = new ImageView("file:button/red_wvyvum.png");
    public static SnapshotParameters params = new SnapshotParameters();
    public static Image image = imageView.snapshot(params, null);

    public static void healthBar (GraphicsContext gc, Enemy enemy) {
        //imageView = new ImageView("file:button/red_wvyvum.png");
        imageView.setFitHeight(5);
        imageView.setFitWidth(updateHealth(gc, enemy));

        params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        image = imageView.snapshot(params, null);
        if (enemy.getHealth()>0)
            gc.drawImage(image, (enemy.getX()+23-imageView.getFitWidth()/2) , enemy.getY()-5);
    }

    public static double updateHealth (GraphicsContext gc, Enemy enemy) {
        //if (enemy.getHealth() > 0)
        return enemy.getHealth();
    }

}
