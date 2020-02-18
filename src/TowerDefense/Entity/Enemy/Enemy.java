package TowerDefense.Entity.Enemy;

import TowerDefense.Entity.Direction;
import TowerDefense.Entity.Player.GameUpdate;
import TowerDefense.Entity.VulnerableObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.Point;

public class Enemy extends VulnerableObject {
    int wayPointIndex = 0;
    boolean check = true;
    boolean checkSpeed = false;
    int pointByHealth;
    int coinByHealth;
    long distanceWait;
    int speedByIceBullet = speed / 2;
    int speedWithoutIceBullet = speed;
    //Point point = find(x+500, y+400);
    //public Point getPoint(){return point;}

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
        return  y;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getHealth(){
        return health;
    }

    public void setCheck(boolean check){
        this.check = check;
    }

    public boolean getCheck(){
        return check;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public int getSpeed(){
        return speed;
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }

    public Direction getDirection(){
        return this.direction;
    }

    public void setImage(Image img){
        this.img = img;
    }

    public Image getImage(){
        return img;
    }

    public void setCheckSpeedEnemy(boolean checkSpeed){
        if (!checkSpeed) speed = speedWithoutIceBullet;
        else speed = speedByIceBullet;
    }

    public void setPointByHealth(int pointByHealth){
        this.pointByHealth = pointByHealth;
    }

    public int getPointByHealth(){
        return pointByHealth;
    }

    public void setCoinByHealth(int coinByHealth){
        this.coinByHealth = coinByHealth;
    }

    public int getCoinByHealth(){
        return coinByHealth;
    }

    public void setDistanceWait(long distanceWait){
        this.distanceWait = distanceWait;
    }

    public long getDistanceWait(){
        return distanceWait;
    }

    public void setSpeedByIceBullet(int speedByIceBullet){
        this.speedByIceBullet = speedByIceBullet;
    }

    public int getSpeedByIceBullet(){
        return speedByIceBullet;
    }

    public void setSpeedWithoutIceBullet(int speedWithoutIceBullet){
        this.speedWithoutIceBullet = speedWithoutIceBullet;
    }

    public int getSpeedWithoutIceBullet(){
        return speedWithoutIceBullet;
    }

    public void setCheckSpeed(boolean checkSpeed){
        this.checkSpeed = checkSpeed;
    }

    public static final Point[] wayPoints = new Point[] {
            new Point((19 * 62 + 62 - 46) / 2, (31 * 31 + 31 - 38) / 2),
            new Point((11 * 62 + 62 - 46) / 2, (22 * 31 + 31 - 38 +31) / 2),
            new Point((9 * 62 + 62 - 46) / 2, (24 * 31 + 31 - 38 +31) / 2),
            new Point((5 * 62 + 62 - 46) / 2, (21 * 31 + 31 - 38) / 2),
            new Point((10 * 62 + 62 - 46) / 2, (16 * 31 + 31 - 38) / 2),
            new Point((22 * 62 + 62 - 46) / 2, (28 * 31 + 31 - 38) / 2),
            new Point((31 * 62 + 62 - 46) / 2, (19 * 31 + 31 - 38) / 2),
            new Point((23 * 62 + 62 - 46) / 2, (11 * 31 + 31 - 38) / 2),
            new Point((20 * 62 + 62 - 46) / 2, (14 * 31 + 31 - 38) / 2),
            new Point((24 * 62 + 62 - 46) / 2, (18 * 31 + 31 - 38) / 2),
            new Point((21 * 62 + 62 - 46) / 2, (21 * 31 + 31 - 38) / 2),
            new Point((13 * 62 + 62 - 46) / 2, (13 * 31 + 31 - 38) / 2),
            new Point((21 * 62 + 62 - 46) / 2, (5 * 31 + 31 - 38) / 2),
    };

    public Point getNextWayPoint() {
        if (wayPointIndex < wayPoints.length - 1)
            return wayPoints[++wayPointIndex];
        return null;
    }

    @Override
    public void render(GraphicsContext gc) {
        if (check && health > 0) gc.drawImage(img, x, y);
    }

    void calculateDirection(){
        if (wayPointIndex >= wayPoints.length) return;

        Point currentWP = wayPoints[wayPointIndex];
        if (Math.abs(x- currentWP.x) <= speed*2 && Math.abs(y-currentWP.y) <= speed) {
            x = currentWP.x;
            y = currentWP.y;
            Point nextWayPoint = getNextWayPoint();
            if (health <= 0) {
                check = false;
            }
            if (nextWayPoint == null) {
                GameUpdate.heart--;
                check = false;
                return;
            }
            double deltaX = nextWayPoint.x - x;
            double deltaY = nextWayPoint.y - y;
            if (deltaX > speed * 2 && deltaY < -speed) direction = Direction.UP;
            else if (deltaX < -speed * 2 && deltaY > speed) direction = Direction.DOWN;
            else if (deltaY < -speed && deltaX < -speed * 2) direction = Direction.LEFT;
            else if (deltaY > speed && deltaX > speed * 2) direction = Direction.RIGHT;
        }
    }

    @Override
    protected void update() {
        //setCheckSpeedEnemy(checkSpeed);
        //if (!checkSpeed) speed = speedWithoutIceBullet;
        //else speed = speedByIceBullet;

        if (check) calculateDirection();

        switch (direction) {
            case UP:
                x += speed * 2;
                y -= speed;
                break;
            case DOWN:
                x -= speed * 2;
                y += speed;
                break;
            case LEFT:
                x -= speed * 2;
                y -= speed;
                break;
            case RIGHT:
                x += speed * 2;
                y += speed;
                break;
        }
    }

    //protected static abstract Enemy createEnemy();
}
