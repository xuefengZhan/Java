package StringTable;

/**
 * @author shkstart  shkstart@126.com
 * @create 2020  0:49
 */
public class StringTest4 {
    public static void main(String[] args) {
        System.out.println();//2670
        System.out.println("1");//2671
        System.out.println("2");//2672
        System.out.println("3");//2673
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("10");//2681

        //如下的字符串"1" 到 "10"不会再次加载
        System.out.println("1");//2681
        System.out.println("2");//2681
        System.out.println("3");//2681
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("10");//2681
    }
}
