package TowerDefense.Entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}

public abstract class GameObject {
    public int i;
    public int j;
    protected int x;
    protected int y;
    protected Image img;

    protected abstract void render(GraphicsContext gc);
    protected abstract void update();
}

abstract class MovableObject extends GameObject {
    protected int speed;
    protected Direction direction;
}


