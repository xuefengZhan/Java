package _17_反射._01_类初始化触发机制;

public class TestClinit_07{

    //todo 访问类的非静态常量时，只会触发声明此静态常量的类的初始化
    public static void main(String[] args) {
        System.out.println(NC.MAX_VALUE);
        System.out.println(ND.MAX_VALUE);
        //NC
        //100
        //100
    }

}

class NC{
    public static int MAX_VALUE = 100;
    static{
        System.out.println("NC");
    }
}

class ND extends NC{
    static{
        System.out.println("ND");
    }
}
