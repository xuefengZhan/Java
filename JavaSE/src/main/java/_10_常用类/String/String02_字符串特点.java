package _10_常用类.String;

import org.junit.Test;

public class String02_字符串特点 {
    

    @Test
    public void test01(){
        String s1 = "abc";
        String s2 = s1.replace('a', 'm');
        System.out.println(s1);//abc
        System.out.println(s2);//mbc
    }

    @Test
     public void test02(){

            String s3 = new String("hi");
            String s4 = s3.intern();
            System.out.println(s3  == "hi");//false
            System.out.println(s4  == "hi");//true
     }
}
