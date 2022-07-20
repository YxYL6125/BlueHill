/**
 * @program: BlueHill
 * @description: 测试类
 * @author: YxYL
 * @create: 2022-07-20 16:29
 **/

public class Test {
    private static MyDoubleList<String> list = new MyDoubleList<>();


    public static void main(String[] args) {
        System.out.println("-----------添加------------");
        list.add("重庆邮电大学");
        list.add("重庆医科大学");
        list.add("三峡医专");
        list.add("中国");
        list.add("漂亮国");
        list.add("毛子国");
        list.add("法国");
        print();
        
        System.out.println("-----------删除------------");
//        for (int i = 0; i < 5; i++) {
//            list.remove(i);
//        }//这里不能循环遍历删除，因为每次删除过后，List里index都是会变得，而for里i不会以此变化还是i++
        list.remove(1);
        print();

        System.out.println("-----------翻转------------");
        list.reserve(list);
        print();

    }

    private static void print() {
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }
    }

}
