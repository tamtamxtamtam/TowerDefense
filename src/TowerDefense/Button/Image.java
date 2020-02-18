package TowerDefense.Button;

import javafx.scene.image.ImageView;

public class Image {
    public static ImageView LevelImageViewPink() {
        javafx.scene.image.Image image = new javafx.scene.image.Image("file:lineLight/lineLight23.png");
        ImageView imageView = new ImageView(image);
        return imageView;
    }
    public static ImageView LevelImageViewBlack() {
        javafx.scene.image.Image image = new javafx.scene.image.Image("file:lineDark/lineDark20.png");
        ImageView imageView = new ImageView(image);
        return imageView;
    }

    public static ImageView StartImageViewPink() {
        javafx.scene.image.Image image = new javafx.scene.image.Image("file:lineLight/lineLight50.png");
        ImageView imageView = new ImageView(image);
        return imageView;
    }

    public static ImageView StartImageViewBlack() {
        javafx.scene.image.Image image = new javafx.scene.image.Image("file:lineDark/lineDark37.png");
        ImageView imageView = new ImageView(image);
        return imageView;
    }

    public static ImageView PauseImageViewPink() {
        javafx.scene.image.Image image = new javafx.scene.image.Image("file:lineLight/lineLight51.png");
        ImageView imageView = new ImageView(image);
        return imageView;
    }

    public static ImageView PauseImageViewBlack() {
        javafx.scene.image.Image image = new javafx.scene.image.Image("file:lineDark/lineDark39.png");
        ImageView imageView = new ImageView(image);
        return imageView;
    }

}
