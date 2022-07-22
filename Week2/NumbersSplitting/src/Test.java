import java.util.Scanner;

/**
 * @program: BlueHill
 * @description: 自然数的拆分问题(bushi)
 * @author: YxYL
 * @create: 2022-07-22 15:49
 **/

public class Test {
    /**
     * 太菜了
     * 这里是头发头扣没了还做不出来，姑且照搬网上源码了
     */

    static int n;
    static int res[] = new int[10];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(0, 0, 0);
    }

    public static void dfs(int ans, int num, int min) {
        if (ans == n) {
            for (int i = 1; i < num; i++) {
                System.out.print(res[i] + "+");
            }
            System.out.println(res[num]);
        }

        for (int i = 1; i < n; i++) {
            if ((ans + i) <= n && i >= min) {
                res[num + 1] = i;
                num++;
                dfs(ans + i, num, i);
                num--;
            }
        }

    }

}