package TowerDefense.Entity.Enemy;

import TowerDefense.Entity.Direction;
import javafx.scene.image.Image;

public class EnemyBoss extends Enemy{
    public EnemyBoss(){

    }

    public static Enemy createEnemy() {
        Enemy enemy = new Enemy();
        enemy.i = 35;
        enemy.j = 15;
        enemy.setX((enemy.j * 62 + 62 - 46) / 2);
        enemy.setY((enemy.i * 31 + 31 - 38) / 2);
        enemy.setSpeed(3 + CreateEnemy.level / 4);
        enemy.setHealth(25 + CreateEnemy.level / 4 * 5);
        enemy.setDirection(Direction.UP);
        enemy.setPointByHealth(150 + 5 * CreateEnemy.level / 4);
        enemy.setCoinByHealth(50 + CreateEnemy.level / 4 * 5);
        enemy.setDistanceWait(- (3 + CreateEnemy.level/4) / 3 * 200000000);
        enemy.setImage(new Image("file:Isometric/60.png"));
        return enemy;
    }
}
