package _06_Object_static_final;

public class _static {
    public static void main(String[] args) {
        Demo d = new Demo();
    }
}


class Demo{
    {
        System.out.println("(1) Demo的非静态代码块1");
    }
    static {
        System.out.println("(2) Demo的静态代码块1");
    }
    private static String info = assign();
    private String message = getMessage();

    static{
        System.out.println("(3) Demo静态代码块2");
    }
    {
        System.out.println("(4) Demo非静态代码块2");
    }

    public Demo(){
        System.out.println("(5) Demo 无参构造");
    }

    public static String assign(){
        System.out.println("(6) assign()方法");
        return "hello";
    }

    public String getMessage(){
        System.out.println("(7) getMessage()方法");
        return "hello";
    }

}