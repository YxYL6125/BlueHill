package fly;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @program: BlueHill
 * @description: 我方雷霆战机
 * @author: YxYL
 * @create: 2022-07-27 20:51
 **/

public class Hero extends JFrame implements KeyListener {
    // 定义我方的初始位置
    private int x;
    private int y;

    public Hero() {
        this.x = 12;
        this.y = 15;
    }

    void move(char opt) {
        if ('a' == opt) {
            this.x -= 1;
        } else if ('s' == opt) {
            this.y += 1;
        } else if ('d' == opt) {
            this.x += 1;
        } else if ('w' == opt) {
            this.x -= 1;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        move(e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


    @Override
    public String toString() {
        return "fly.Hero{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
