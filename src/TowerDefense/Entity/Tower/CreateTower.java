package TowerDefense.Entity.Tower;

import TowerDefense.Sound.Coin;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class CreateTower {
    public static List<Tower> towerList = new ArrayList<>();

    public static void render(GraphicsContext gc){
        for (int i = 0; i < towerList.size(); i++) towerList.get(i).render(gc);
    }

    public static void createTowerByOrder(int status, int x, int y){
        switch (status) {
            case 11:
                addTowerAfterDrop(new BulletTower(), x, y);
                Coin.buyTower();
                break;
            case 12:
                addTowerAfterDrop(new ThunderTower(), x, y);
                Coin.buyTower();
                break;
            case 13:
                addTowerAfterDrop(new IceTower(), x, y);
                Coin.buyTower();
        }
    }

    public static void addTowerAfterDrop(Tower tower, int x, int y){
        if (tower instanceof BulletTower) towerList.add(BulletTower.createTower(x, y));
        else if (tower instanceof ThunderTower) towerList.add(ThunderTower.createTower(x, y));
        else towerList.add(IceTower.createTower(x, y));
        //System.out.println(towerList.size());
    }

}
