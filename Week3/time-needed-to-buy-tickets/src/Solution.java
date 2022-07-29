/**
 * @program: BlueHill
 * @description: 买票需要的时间
 * @author: YxYL
 * @create: 2022-07-29 16:00
 **/

public class Solution {

    public static void main(String[] args) {
        int[] tickets = {2, 3, 2};//结果是：6
        int k = 2;
//        int[] tickets = {5,1,1,1};//结果是：8
//        int k = 0;
        int result = timeRequiredToBuy(tickets, k);
        System.out.println("结果是："+result);
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int i = 0;//轮数
        int time = 0;//时间
        if (tickets.length == 1) {//只有一个人买票
            time = tickets[0];//时间即票数
        }

        while (tickets[k] != 0) {//开始买票
            if (tickets[i] > 0) {
                time++;//时间+1
                tickets[i]--;//票数-1
            }
            i++;
            if (tickets.length == i) {//排到最后一名
                i = 0;//开始下一轮
            }
        }
        return time;
    }
}