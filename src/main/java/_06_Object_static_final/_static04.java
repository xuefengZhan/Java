package _06_Object_static_final;

/**
 *  父类先加载于子类, 静态方法不存在重写和动态绑定
 */
public class _static04 {
    public static void main(String[] args) {
       // Son s  = new Son();
        Farther f = new Son();
        System.out.println("---------");
        f.assign();
    }

}

class Farther{
    private static String info = assign();
    static{
        System.out.println("(1) 父类静态代码块");
    }
    public static String assign(){
        System.out.println("(3)  assign()方法");
        return "farther";
    }

}
class Son extends Farther{
    private static String info = assign();
    static{
        System.out.println("(2) 子类静态代码块");
    }

    public static String assign(){
        System.out.println("(4)  assign()方法");
        return "Son";
    }
}
