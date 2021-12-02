package _17_反射._01_类初始化触发机制;

public class TestClinit_02 extends farther{
    //一个类要初始化，会先初始化其父类
    static{
        System.out.println("1");
    }

    public static void main(String[] args) {

    }
}

class farther{
    static{
        System.out.println("farther");
    }
}
