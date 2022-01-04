package StringTable;

import org.junit.Test;

/**
 * String的基本使用:体现String的不可变性
 */public class StringTest1 {
    @Test
    public void test1() {
        String s1 = "abc";//字面量定义的方式，"abc"存储在字符串常量池中
        String s2 = "abc";//s1,s2指向同一个abc
        s1 = "hello";//s1指向字符串常量池新开辟了的hello，不影响原有的abc

        System.out.println(s1 == s2);// false
        System.out.println(s1);//hello
        System.out.println(s2);//abc
    }

    @Test
    public void test2() {
        String s1 = "abc";
        String s2 = "abc";
        s2 += "def";//s2 = s2+"def"
        System.out.println(s2);//abcdef
        System.out.println(s1);//abc
    }
}