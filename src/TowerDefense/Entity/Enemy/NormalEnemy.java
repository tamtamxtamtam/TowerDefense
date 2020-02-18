package TowerDefense.Entity.Enemy;

import TowerDefense.Entity.Direction;
import javafx.scene.image.Image;

public class NormalEnemy extends Enemy {
    public NormalEnemy(){
    }

    public static Enemy createEnemy() {
        Enemy enemy = new Enemy();
        enemy.i = 35;
        enemy.j = 15;
        enemy.setX((enemy.j * 62 + 62 - 46) / 2);
        enemy.setY((enemy.i * 31 + 31 - 38) / 2);
        enemy.setSpeed(2 + CreateEnemy.level / 4);
        enemy.setHealth(15 + CreateEnemy.level / 4 * 5) ;
        enemy.setDirection(Direction.UP);
        enemy.setPointByHealth(100 + 5 * CreateEnemy.level / 4);
        enemy.setCoinByHealth(30 + CreateEnemy.level / 4 * 5);
        enemy.setDistanceWait((2 + CreateEnemy.level / 4) / 2 * 200000000);
        enemy.setImage(new Image("file:Isometric/50.png"));
        return enemy;
    }
}
