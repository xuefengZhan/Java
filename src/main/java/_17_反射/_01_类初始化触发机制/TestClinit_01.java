package _17_反射._01_类初始化触发机制;

public class TestClinit_01 {
    //main方法所在的类会触发此类的初始化
    static{
        System.out.println("1");
    }

    public static void main(String[] args) {

    }
}
