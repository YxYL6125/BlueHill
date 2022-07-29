import bullet.Bullet;
import fly.Enemy;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: BlueHill
 * @description:
 * @author: YxYL
 * @create: 2022-07-27 20:44
 **/

public class ThunderFighterJFrame extends JFrame {

    private List<Enemy> enemyList = new ArrayList<Enemy>();//定义一个集合来装所有的敌机
    private List<Bullet> bullets = new ArrayList<Bullet>();

    public static String[][] map = new String[24][30];

    public ThunderFighterJFrame() {//创建十个敌人
        for (int i = 0; i < 10; i++) {
            enemyList.add(new Enemy());
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        g.drawString();
        
    }

    /**
     * 加载
     */
    public void load() {
        loadMap();//初始化战场地图
    }

    /**
     * 初始化战场地图
     */
    public void loadMap() {
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 30; j++) {
                if (i == 0) {
                    map[i][j] = "■";
                }
                if (i == 23) {
                    map[i][j] = "■";
                } else {
                    if (j == 0 || j == 29) {
                        map[i][j] = "■";
                    } else {
                        if (i == 0) {

                        } else {
                            map[i][j] = " ";
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 30; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }
    
}