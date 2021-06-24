package _16_单例模式;

import org.junit.Test;

public class lazy {
    @Test
    public void test01(){
        lazy01 l1 = lazy01.INSTANCE;
        lazy01 l2 = lazy01.INSTANCE;
        System.out.println(l1 == l2);//true

        System.out.println(l1);
        System.out.println(l2);
    }

    @Test
    public void test02(){
        lazy02 l1 = lazy02.lz1;
        lazy02 l2 =  lazy02.lz1;
        System.out.println(l1 == l2);//true

        System.out.println(l1);
        System.out.println(l2);
    }
}

//todo 饿汉式：实现方式1-枚举
enum lazy01{
    INSTANCE("枚举实现饿汉一号");
    private String name;

    private lazy01(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "lazy01{" +
                "name='" + name + '\'' +
                '}';
    }
}
// todo 饿汉式 实现方式2-手动枚举类
class lazy02{
    private String name;
    public static final lazy02 lz1 = new lazy02("饿汉2号");


    private lazy02(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "lazy02{" +
                "name='" + name + '\'' +
                '}';
    }
}
// todo 饿汉式 实现方式3-手动枚举类
class lazy03{
    private String name;
    private static final lazy03 lz1 = new lazy03("饿汉3号");

    public static lazy03 getInstance(){
        return lz1;
    }

    private lazy03(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "lazy03{" +
                "name='" + name + '\'' +
                '}';
    }
}