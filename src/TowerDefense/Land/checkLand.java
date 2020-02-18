package TowerDefense.Land;


import static TowerDefense.Land.createMap.MAP_SPRITES;

public class checkLand {

        boolean check(int x, int y){
                if (MAP_SPRITES[y][x] == "343" || MAP_SPRITES[y][x]== "129") return true;
                return false;
        }
}
