/**
 * @program: BlueHill
 * @description:
 * @author: YxYL
 * @create: 2022-07-27 20:44
 **/

public class ThunderFighter {
    public static void main(String[] args) {
        ThunderFighter thunderFighter = new ThunderFighter();
        thunderFighter.load();
    }

    public static String[][] map = new String[24][30];

    /**
     * 加载
     */
    private void load() {
        loadMap();//初始化战场地图
    }

    /**
     * 初始化战场地图
     */
    private void loadMap() {
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


    }
}