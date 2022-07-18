import java.util.Scanner;

/**
 * @program: BlueHill
 * @description: 测试类
 * @author: YxYL
 * @create: 2022-07-18 19:29
 **/

public class Test {
    public static void main(String[] args) {
        System.out.println("----------请输入表达式吧：----------");
        Scanner sc = new Scanner(System.in);
        String ex = sc.next();
        System.out.println("结果是：" + Calculator.Calculate(ex));//结果是：18.333333333333336
//        System.out.println(1+2+3/4+8*2-2);
    }
}
