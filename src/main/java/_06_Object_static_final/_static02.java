package _06_Object_static_final;

public class _static02 {
    static{
        System.out.println("TestStatic2静态代码块");
    }

    public static void main(String[] args) {

    }
}
class MyClass{
    static{
        System.out.println("MyClass静态代码块");
    }
    public static void test(){
        System.out.println("静态方法");
    }
}
