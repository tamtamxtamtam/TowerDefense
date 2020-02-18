package TowerDefense.Entity.Enemy;

import TowerDefense.Entity.Player.PlayStage;

import java.util.ArrayList;
import java.util.List;

public class CreateEnemy {
    public static int level = -1;
    public static List<Enemy> enemyList = new ArrayList<>();
    public static long timePrevious = 0;
    static List<Integer> integers = new ArrayList<>();
    static int i = 0;

    public static void setLevel(int _level){
        level = _level;
    }

    public static int getLevel(){
        return level;
    }

    public static void createEnemyByLevel(int level){
        switch (level){
            case 0:
                addEnemyByAmount(10, new NormalEnemy());
                //enemyMove();
                break;
            case 1:
                addEnemyByAmount(10, new StrongEnemy());
                //enemyMove();
                break;
            case 2:
                addEnemyByAmount(10, new FastEnemy());
                //enemyMove(Game.gc);
                break;
            case 3:
                addEnemyByAmount(10, new EnemyBoss());
                //enemyMove(Game.gc);
                break;
            case 4:
                addEnemyByAmount(12, new NormalEnemy());
                //enemyMove(Game.gc);
                break;
            case 5:
                addEnemyByAmount(12, new StrongEnemy());
                //enemyMove(Game.gc);
                break;
            case 6:
                addEnemyByAmount(12, new FastEnemy());
                //enemyMove(Game.gc);
                break;
            case 7:
                addEnemyByAmount(12, new EnemyBoss());
                //enemyMove(Game.gc);
                break;
            case 8:
                addEnemyByAmount(15, new NormalEnemy());
                //enemyMove(Game.gc);
                break;
            case 9:
                addEnemyByAmount(15, new StrongEnemy());
                //enemyMove(Game.gc);
                break;
            case 10:
                addEnemyByAmount(15, new FastEnemy());
                //enemyMove(Game.gc);
                break;
            case 11:
                addEnemyByAmount(15, new EnemyBoss());
                //enemyMove(Game.gc);
                break;
            case 12:
                addEnemyByAmount(18, new NormalEnemy());
                //enemyMove(Game.gc);
                break;
            case 13:
                addEnemyByAmount(18, new StrongEnemy());
                //enemyMove(Game.gc);
                break;
            case 14:
                addEnemyByAmount(18, new FastEnemy());
                //enemyMove(Game.gc);
                break;
            case 15:
                addEnemyByAmount(18, new EnemyBoss());
                //enemyMove(Game.gc);
                break;
            case 16:
                addEnemyByAmount(20, new NormalEnemy());
                //enemyMove(Game.gc);
                break;
            case 17:
                addEnemyByAmount(20, new StrongEnemy());
                //enemyMove(Game.gc);
                break;
            case 18:
                addEnemyByAmount(20, new FastEnemy());
                //enemyMove(Game.gc);
                break;
            case 19:
                addEnemyByAmount(20, new EnemyBoss());
                //enemyMove(Game.gc);
                break;

        }
    }

    public static void enemyMove(){
        for (int j = 0; j < integers.size(); j++){
            enemyList.get(j).update();
        }
        if (System.nanoTime() - timePrevious >= 1500000000 /*+ enemyList.get(0).getDistanceWait()*/ && i < enemyList.size()){
            i++;
            integers.add(i);
            //System.out.println(i);
            timePrevious = System.nanoTime();
        }

        if (!enemyList.isEmpty() && !integers.isEmpty()){

            for (int k = 0; k < enemyList.size(); k++) {
                if (!enemyList.get(k).getCheck()) {
                    enemyList.remove(k);
                    integers.remove(integers.size() - 1);
                    i--;
                    //System.out.println(1);
                }
            }
        }
        else {
            PlayStage.stage1.status = true;
            PlayStage.stage2.status = false;
        }
    }

    public static void addEnemyByAmount(int amount, Enemy enemy){

        if (enemyList.isEmpty()) {
            for (int i = 0; i < amount; i++) {
                if (enemy instanceof NormalEnemy) enemyList.add(NormalEnemy.createEnemy());
                else if (enemy instanceof StrongEnemy) enemyList.add(StrongEnemy.createEnemy());
                else if (enemy instanceof FastEnemy) enemyList.add(FastEnemy.createEnemy());
                else enemyList.add(EnemyBoss.createEnemy());
                //System.out.println(1);
            }
        }
    }

}
