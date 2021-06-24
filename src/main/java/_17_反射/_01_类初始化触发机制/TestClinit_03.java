package _17_反射._01_类初始化触发机制;

public class TestClinit_03{

    static{
        System.out.println("1");
    }

    public static void main(String[] args) {
        A a = new A();
    }
}

class A{
    static{
        System.out.println("A");
    }
}


