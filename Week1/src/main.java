import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: BlueHill
 * @description: 测试类
 * @author: YxYL
 * @create: 2022-07-12 23:13
 **/

public class main {
    public static void main(String[] args) {
        searchTest();//排序
        sortTest();//查找
    }

    /**
     * 检索测试
     */
    private static void searchTest() {
        Lost book1 = new BookLost(100,"name1","yxyl");
        book1.setLocation("浙江");
        Lost book2 = new BookLost(200,"name2","yxyl");
        book2.setLocation("医科");
        Lost book3 = new BookLost(300,"name3","yxyl");
        book3.setLocation("邮专");
        Lost book4 = new BookLost(400,"name4","yxyl");
        book4.setLocation("浙江");


        Lost[] losts = LostUtil.selectByKeyword(new Lost[]{book1,book2,book3,book4}, "浙江");
        for (Lost lost : losts) {
            if (lost != null) {
                System.out.println(lost.toString());
            }
        }
    }


    /**
     * 排序测试
     */
    private static void sortTest() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Lost[] losts = new Lost[10];

        for (int i = 0; i < 10; i++) {
            Lost book = new BookLost();
            book.setLostTime(LostUtil.randomDate("1990-01-01", sdf.format(new Date())));
            losts[i] = book;
        }
        LostUtil.sortLost(losts);
        for (int i = 0; i < losts.length; i++) {
            System.out.println(losts[i]);
        }
    }
}
