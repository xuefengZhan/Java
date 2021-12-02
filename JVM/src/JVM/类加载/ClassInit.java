package 类加载;

public class ClassInit {
    private static int num = 1;

    static{
        num = 2;
        number = 20;
        System.out.println(num);
        //System.out.println(number);
    }
    private static int number = 10;

    public static void main(String[] args){
        System.out.println(ClassInit.num);//2
        System.out.println(ClassInit.number);//10
    }
}
