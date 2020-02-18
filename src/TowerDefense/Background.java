package TowerDefense;

import TowerDefense.Button.TowerButton;
import TowerDefense.Entity.Enemy.HealthBar;
import TowerDefense.Entity.Player.PlayStage;
import TowerDefense.Entity.Tower.CreateTower;
import TowerDefense.Entity.Enemy.CreateEnemy;
import TowerDefense.Land.Land;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.*;

import static TowerDefense.Button.MenuButton.find;
import static TowerDefense.Land.Land.*;
import TowerDefense.Land.createMap;

public class Background {
    public static void drawMap(GraphicsContext gc) {
        gc.drawImage(new Image("file:Pictures/12.png"),0,0);
        PlayStage.stage1.getMoney(gc);
        PlayStage.stage1.getHeart(gc);
        for (int i = 0; i < createMap.MAP_SPRITES.length; i++) {
            for (int j = 0; j < createMap.MAP_SPRITES[i].length; j++) {
                //Point d = find(gameObjects.get(0).x + 76, gameObjects.get(0).y + 92);
                //Point f = find(towerList.get(0).x + 92, towerList.get(0).y + 141);
                //Point f1 = find(towerList.get(1).x + 92, towerList.get(1).y + 141);

                //System.out.println(d.y + " " + d.x);
                if (createMap.MAP_SPRITES[i][j] != "000") {
                    Land land = new Land(i,j);
                    if (TowerButton.status / 10 == 1 && CHECK[i][j]){
                        land.b = land.b-15;
                    }
                    if (j == 11 && i == 4)
                        gc.drawImage(new Image("file:Isometric/140.png"), (double) 11 * 62 / 2, (double) (4 * 31 + 49 - (97 - 81)) / 2);
                    else getLand(land, gc);

                    for (int h = 0; h < CreateEnemy.enemyList.size(); h++){
                        Point pointEnemy = find(CreateEnemy.enemyList.get(h).getX() + 23, CreateEnemy.enemyList.get(h).getY() + 13 + 49);
                        //System.out.println("i=" +pointEnemy.x+ " j="+  pointEnemy.y);
                        //for (int k = 0; k < createEnemy.enemyList.size(); k++) createEnemy.enemyList.get(k).render(gc);
                        if (pointEnemy.x == j && pointEnemy.y == i) {
                            CreateEnemy.enemyList.get(h).render(gc);
                            HealthBar.healthBar(gc, CreateEnemy.enemyList.get(h));
                        }
                    }

                    for (int k = 0; k < CreateTower.towerList.size(); k++){
                        //Point pointTower = find(createTower.towerList.get(k).getX() + 23, createTower.towerList.get(k).getY() + 55);
                        if (CreateTower.towerList.get(k).j == j  && CreateTower.towerList.get(k).i == i) {
                            CreateTower.towerList.get(k).render(gc);
                            //System.out.println("i=" +pointTower.x+ " j="+  pointTower.y);
                        }
                    }

                    /*for (int k = 0; k < createEnemy.enemyList.size(); k++) {
                        //if (createEnemy.enemyList.get(k).)
                        createEnemy.enemyList.get(k).render(gc);
                    }*/
                }

            }
        }
    }
}
