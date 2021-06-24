package _10_常用类.字符串;

import org.junit.Test;

import java.util.Arrays;

public class _04_ {

    //todo 字符串编码和解码

    //todo 1.编码：对于ASCII码范围内（0~127），无论用什么编码方式，一个字符对应的编码结果都是一样的
    //  对于其他的字符，编码结果不一定是几个字节，例如汉字
    //  平台默认UTF-8，汉字是三个字节，意味着一个汉字对应三个数
    @Test
    public void test01(){
        String str = "abc";
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));//[97, 98, 99]

        String str2 = "詹学丰";
        byte[] bytes2 = str2.getBytes();
        System.out.println(Arrays.toString(bytes2));//[-24, -87, -71, -27, -83, -90, -28, -72, -80]


    }
    @Test
    //读取文件后缀名
    public void test02(){
        String s1 = "Hello.java.txt";
        int i = s1.lastIndexOf('.');
        String s2 = s1.substring(i);
        System.out.println(s2);

    }
}
