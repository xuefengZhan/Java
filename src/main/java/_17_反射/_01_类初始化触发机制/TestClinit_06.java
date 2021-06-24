package _17_反射._01_类初始化触发机制;

public class TestClinit_06 {

    //todo 访问类的静态常量不会触发此类的初始化
    public static void main(String[] args) {
        System.out.println(NB.MAX_VALUE);
        System.out.println(NV.MAX_VALUE);
    }

}
class NB{
    public final static int MAX_VALUE = 100;
    static{
        System.out.println("NB");
    }
}

class NV extends NB{
    static{
        System.out.println("nv");
    }
}
