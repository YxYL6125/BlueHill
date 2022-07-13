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
        sortTest();//排序
        searchTest();//查找
    }

    /**
     * 检索测试
     */
    private static void searchTest() {
        Lost card1 = new CardLost(001, new Date(), "yxyl");
        card1.setLocation("浙江");
        Lost card2 = new CardLost(002, new Date(), "yxyl");
        card2.setLocation("医科");
        Lost card3 = new CardLost(003, new Date(), "yxyl");
        card3.setLocation("邮专");
        Lost card4 = new CardLost(004, new Date(), "yxyl");
        card4.setLocation("浙江");


        Lost[] losts = LostUtil.selectByKeyword(new Lost[]{card1, card2, card3, card4}, "浙江");
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
            book.setLostTime(LostUtil.randomDate("1660-01-01", sdf.format(new Date())));
            losts[i] = book;
        }
        LostUtil.sortLost(losts);
        for (int i = 0; i < losts.length; i++) {
            System.out.println(losts[i].toString());
        }
    }
}
