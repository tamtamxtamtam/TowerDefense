package TowerDefense.Entity.Tower;

import TowerDefense.Entity.AttackableObject;
import TowerDefense.Entity.Enemy.Enemy;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Tower extends AttackableObject {
    double range = 3;
    int price;

    public void setX(int x){
        this.x = x;
    }
    public int getX(){
        return x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getY(){
        return y;
    }

    public void setImage(Image img){
        this.img = img;
    }

    public Image getImage(){
        return img;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
        //gc.drawImage(gunImg, x, y);
    }

    @Override
    public void update() {
    }

    public double distanceEnemy(Enemy enemy){
        double x = (this.x + 23 - 31 * 2 + 62 ) - (enemy.getX() + 24);
        double y = (this.y + 33 + 31) - (enemy.getY() + 48);
        double distance = (x * x) * 1.0/ (62 * 62) + (y * y) * 1.0/ (31 * 31);
        return distance;
    }

    public boolean shotRange(Enemy enemy){
        //double distance = (x * x) * 1.0/ (62 * 62) + (y * y) * 1.0/ (31 * 31);
        if (this.distanceEnemy(enemy) <= fireRange) return true;
        else return false;
    }

}

