package _10_常用类.字符串;

import org.junit.Test;

public class _01_ {
    
    //todo 1.字符串的不变性
    @Test
    public void test01(){
        String s1 = "hello";

        String s2 = "hello";
        System.out.println(s1==s1);

    }


    @Test
    public void test02(){
        String s1 = new String("hmp");
        String s2 = new String("hmp");
        System.out.println(s1 == s2);//false
        System.out.println(s1.hashCode() == s2.hashCode());//true  内容一样的String对象的hash值是一样的

    }

}
