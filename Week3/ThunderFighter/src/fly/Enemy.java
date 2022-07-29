package fly;

import java.util.Random;

/**
 * @program: BlueHill
 * @description: 敌军类
 * @author: YxYL
 * @create: 2022-07-27 20:50
 **/

public class Enemy {
    private Random random = new Random();

    // 定义敌机的初始位置
    private int x;
    private int y;

    public Enemy() {//随机位置
        this.x = random.nextInt(24);
        this.y = 0;
    }

    void move() {
        this.y += 1;
    }


}
