import java.util.Stack;

/**
 * @program: BlueHill
 * @description: 计算器类
 * @author: YxYL
 * @create: 2022-07-18 18:00
 **/

public class Calculator {
    /**
     * 判断字符是否是运算符-> + - * /
     *
     * @param ex
     * @return
     */
    private static boolean isOperator(char ex) {
        return ex == '+' || ex == '-' || ex == '*' || ex == '/';
    }

    /**
     * 判断字符是否是数字-> 1,2...
     *
     * @param ex
     * @return
     */
    private static boolean isNum(char ex) {
        return ex >= '0' && ex <= '9' || ex == '.';
    }

    /**
     * 判断字符是否是括号-> ( )
     *
     * @param ex
     * @return
     */
    private static boolean isBrackets(char ex) {
        return ex == '(' || ex == ')';
    }

    /**
     * 判断运算符优先级-> * / 优先于 + -
     *
     * @param opt
     * @return * /返回2；= —返回1；非法返回0
     */
    private static int priority(char opt) {
        switch (opt) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    /**
     * @param ex   表达式
     * @param left 左边括号的下标
     * @return 左边括号 所对应的 右边括号 的下标
     */
    private static int queryRightParenthesis(char ex[], int left) {
        int flag = 1;
        int right = left + 1;
        for (; right < ex.length && flag > 0; right++) {
            if (ex[right] == '(') {
                flag++;
            } else if (ex[right] == ')') {
                flag--;
            }
        }
        return right - 1;//判断最后一次for之前的时候right++过，需要-1
    }


    /**
     * 计算
     *
     * @param num1
     * @param num2
     * @param opt
     * @return
     */
    private static double Arithmetic(double num1, double num2, char opt) {
        switch (opt) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2==0){
                    throw new RuntimeException("除数不能为0哟");
                }
                return num1 / num2;
            default:
                return 0;
        }
    }

    public static double Calculate(String subString) {
        char[] ex = subString.toCharArray();//转换字符数组
        int len = ex.length;//长度
        int flag = 0;//遍历目前的下标
        Stack<Double> numStack = new Stack<>();//数字栈
        Stack<Character> optStack = new Stack<>();//运算符栈
        while (true) {//扫描整个表达书，该压入栈的压入栈
            if (flag == len) {//如果下标越界，退出循环
                break;
            }

            if (isOperator(ex[flag])) {//若目前下标 -> 运算符
                if (optStack.isEmpty()) {//如果运算符栈为空，
                    //直接操作压入栈
                    optStack.push(ex[flag]);
                } else if (priority(ex[flag]) > priority(optStack.peek())) {//如果目前下标的运算符优先级>栈顶的话，
                    //将其压入栈顶
                    optStack.push(ex[flag]);
                } else if (priority(ex[flag]) <= priority(optStack.peek())) {//如果目前下标的运算符优先级<=栈顶的话，
                    //取出栈顶的运算符，先计算压入数字栈中，再将目前下标的运算符压入栈
//                    Double num1 = numStack.pop();   这个地方没有考虑栈先进后出的顺序，傻逼了
//                    Double num2 = numStack.pop();
                    Double num2 = numStack.pop();
                    Double num1 = numStack.pop();
                    Character opt = optStack.pop();
                    numStack.push(Arithmetic(num1, num2, opt));
                    optStack.push(ex[flag]);
                }
                
            } else if (isNum(ex[flag])) {//若目前下标 -> 数字
                String num = String.valueOf(ex[flag]);
                int digitsOfNum = 1;//数字的位数
                while (digitsOfNum + flag < len && isNum(ex[flag + digitsOfNum])) {//整个数字不能越界
                    num += ex[flag + digitsOfNum];//数字"拼接"
                    digitsOfNum++;
                }
                flag += digitsOfNum - 1;//下标随之要变
                numStack.push(Double.valueOf(num));//将整个数字压入栈
                
                
            } else if (isBrackets(ex[flag])) {//若目前下标 -> 括号
                int rightParenthesis = queryRightParenthesis(ex, flag);//右边括号的下标
                //ex:***( 1+2 )
                //    flag   right 
                char newex[] = new char[rightParenthesis - flag - 1];//整个括号里的表达式
                System.arraycopy(ex, flag + 1, newex, 0, rightParenthesis - flag - 1);
                double res = Calculate(String.valueOf(newex));
                numStack.push(res);
                flag = rightParenthesis;//移动下标
            }
            flag++;
        }

        while (!optStack.isEmpty()) {
            Double num1 = numStack.pop();
            Double num2 = numStack.pop();
            Character opt = optStack.pop();
            double tempRes = Arithmetic(num2, num1, opt);
            numStack.push(tempRes);
        }

        return numStack.pop();
    }
}
