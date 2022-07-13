import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: BlueHill
 * @description: 工具类
 * @author: YxYL
 * @create: 2022-07-13 16:01
 **/

public class LostUtil {

    /**
     * 失物排序方法
     *
     * @param lostArray 待排序的失物数组
     */
    public static void sortLost(Lost[] lostArray) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Date> list = new ArrayList<>();

        for (int i = 0; i < lostArray.length; i++) {
            list.add(lostArray[i].getLostTime());
        }

        Collections.sort(list);
        for (int i = 0; i < lostArray.length; i++) {
            lostArray[i].setLostTime(list.get(i));
        }
    }

    /**
     * 按关键字搜索失物的方法，这里假设按照失物的领取地点进行搜索
     *
     * @param lostArray 失物数组
     * @param keyword   用户输入的关键字
     * @return 返回查找到的失物
     */
    public static Lost[] selectByKeyword(Lost[] lostArray, String keyword) {
        List<Lost> list = new ArrayList();


        Set<String> set = new HashSet<>();
        for (Lost lost : lostArray) {
            set.add(lost.getLocation());
        }
        for (int i = 0; i < lostArray.length; i++) {
            if (set.contains(keyword) && lostArray[i].getLocation().equals(keyword)) {
                list.add(lostArray[i]);
            }
        }


        Lost[] losts = new Lost[lostArray.length];
        for (int i = 0; i < list.size(); i++) {
            losts[i] = list.get(i);
        }
        return losts;
    }

    /**
     * 获取随机日期
     *
     * @param beginDate 起始日期，格式为：yyyy-MM-dd
     * @param endDate   结束日期，格式为：yyyy-MM-dd
     * @return
     */

    public static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);
            Date end = format.parse(endDate);

            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime());

            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));

        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }

}
