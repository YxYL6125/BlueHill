package bullet;

/**
 * @program: BlueHill
 * @description: 我方飞机子弹
 * @author: YxYL
 * @create: 2022-07-27 20:51
 **/

public class HeroBullet extends Bullet {
    private int x;
    private int y;

    public HeroBullet() {
    }

    public HeroBullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    void move() {
        this.y -= 4;
    }
}
