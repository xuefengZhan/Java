package _10_常用类.字符串;

import org.junit.Test;

// day18_09.String对象的个数和拼接结果
public class _02_ {


    @Test
    public void test02(){
        String s;//变量未初始化
        String st = null;//null
        String str = "";//空字符串常量
        String str1 = new String();//空字符串对象
        String str2 = new String("");//创建了两个对象

        System.out.println(str == str1);//false
        System.out.println(str == str2);//false
        System.out.println(str1 == str2);//false
    }

}
