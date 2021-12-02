package _10_常用类.包装类;

import org.junit.Test;

public class _05_缓存问题 {
    @Test
    public void test01() {
        int a = 1;
        int b = 1;
        System.out.println(a==b);  //true

        int c = 130;
        int d = 130;
        System.out.println(c == d ); //true

    }


    //todo
    // Byte.  Short.  Integer Long 等都有缓存对象
    // 缓存范围为-128~127
    @Test
    public void test02(){

        Integer e = 1;
        Integer f = 1;
        System.out.println(e==f);//true   比较的是地址

        Integer h = 130;
        Integer i = 130;
        System.out.println(h == i );//false  比较的是地址
    }


    // 仅限于装箱
    @Test
    public void test03(){

        Integer h1 = new Integer(120);
        Integer h2 = new Integer(120);
        System.out.println(h1 == h2);  //false


        Integer a1 = Integer.valueOf("2");
        Integer a2 = Integer.valueOf("2");
        System.out.println(a1 == a2); //true
    }


}
