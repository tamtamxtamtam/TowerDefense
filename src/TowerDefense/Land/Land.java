package TowerDefense.Land;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static TowerDefense.Land.createMap.MAP_SPRITES;

public class Land {
    public static boolean[][] CHECK_MAP(){
        boolean[][] Check = new boolean[37][37];
        for (int i = 0; i < 37; i++) {
            for (int j = 0; j < 37; j++) {
                if (MAP_SPRITES[i][j] == "129" || MAP_SPRITES[i][j]=="343"){
                    Check[i][j] = true;
                }
                else Check[i][j] = false;
            }
        }
        return Check;
    }
    public static boolean[][] CHECK = CHECK_MAP();

    public  Land[][] getMAP_LAND(){
        Land[][] MAP_LAND = new Land[37][37];
        for (int i = 0; i < 37; i++) {
            for (int j = 0; j < 37; j++) {
                //Land land =
                MAP_LAND[i][j] = new Land(i,j);
            }
        }
        return MAP_LAND;
    }

    public static int i;
    public static int j;
    public static Image c;
    public static double a;
    public static double b;
    //public static boolean status = false;

    public static void getLand(Land land, GraphicsContext gc){
        gc.drawImage(land.c, land.a, land.b);
    }
    public static void setLand(Land land){
        Land.a = (j * 31 + 65 - Land.c.getWidth());
        Land.b = (i * 16 + 49 + 41 - Land.c.getHeight()-30);
        //Land.status = true;
    }

    public Land(int i, int j){
        Land.i = i;
        Land.j = j;
        Land.c = new Image("file:Isometric/" + MAP_SPRITES[i][j] + ".png");
        Land.a = (j * 31 + 65 - Land.c.getWidth());
        Land.b = (i * 16 + 49 + 41 - Land.c.getHeight());


    }

}
