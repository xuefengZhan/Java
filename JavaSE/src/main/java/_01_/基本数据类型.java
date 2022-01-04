package _01_;

import org.junit.Test;

public class 基本数据类型 {
    @Test
    public void test01(){
        int a = 261; //2^8 + 5  32位：0***1 0000 0101
        byte b = (byte)a;  //取低8位  0000 0101
        System.out.println(b);//3


        int c = 5+128+256;  //2^8 + 3  32位：0***1 1000 0101
        byte d = (byte) c;  // 1000 0101
        System.out.println(d); //-125  1100 0000


        System.out.println(0b11111011);
    }
}
