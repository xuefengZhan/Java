package _06_Object_static_final;

//main方法所在类最先加载
public class _static03 {
    static{
        System.out.println("static03的静态代码块");
    }

    public static void main(String[] args) {
        mClass.test();
        mClass.test();
        mClass.test();
    }
}

class mClass{
    static{
        System.out.println("mClass的静态代码块");
    }
    public static void test(){
        System.out.println("静态方法");
    }
}
