import fly.Hero;

import javax.swing.*;

/**
 * @program: BlueHill
 * @description: 测试类
 * @author: YxYL
 * @create: 2022-07-28 16:33
 **/

public class Game extends JFrame {

    static int width = 600;
    static int height = 800;

    public static void main(String[] args) {
        JFrame frame = new Hero();
        frame.setTitle("雷霆战机");
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ThunderFighterJFrame j = new ThunderFighterJFrame();
        frame.add(j);
        frame.setVisible(true);
    }
}
