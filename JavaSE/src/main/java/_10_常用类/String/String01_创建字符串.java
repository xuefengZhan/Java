package _10_常用类.String;

import org.junit.Test;

public class String01_创建字符串 {
    

    @Test
    public void test01(){
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = new String("hello");

        System.out.println(s1==s2);  //true
        System.out.println(s1 == s3); //false
        System.out.println(s3 == s4); //false
        System.out.println(s3.equals(s4)); //true

    }
}
