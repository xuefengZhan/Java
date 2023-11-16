package _01_;

import org.junit.Test;

public class 运算符 {

    @Test
    public void test01(){
        System.out.println(5/2.0);//2.5
        System.out.println(5.0/2);//2.5
        System.out.println(5.0/2.0); //2.5

        float f1 = 2.5f;
        float f2 = 5;
        System.out.println(f2/f1);//2.0
    }


    @Test
    public void test02(){


        System.out.println(5/2);//2
        System.out.println(5/-3);//-1
        System.out.println(5%2);//1
        System.out.println(5%-3);//2

        System.out.println(-7/2);//-3
        System.out.println(-7/-3);//2
        System.out.println(-7%2);//-1
        System.out.println(-7%-2);//-1

        System.out.println(27 % 3);

        //取模的符号跟左边对其
    }

    @Test
    public void test03(){

        //todo 1. << 左移补0  补码运算
        int a = 8;

        //a的二进制：24个零 0000 1000
        //a<<2
        //24个零 0010 0000
        System.out.println(a << 2); //32

        //a的二进制：24个零 0000 1000
        //a>>2
        //24个零 000000 10
        System.out.println(a >> 2);//2

        int b = -8;
        //b的二进制：
        //原码:  1 23个0 0000 1000
        //反码:  1 23个1 1111 0111
        //补码:  1 23个1 1111 1000
        //补码左移b<<2，右边补0
        //补码:  1 23个1 1110 0000  【可以看出实际的运算是补码】
        //反码： 1 23个1 1101 1111
        //原码： 1 23个0 0010 0000  -32
        System.out.println(b << 2);//-32

        //todo 2. >> 右移补最高位  补码运算
        //b的二进制：
        //原码：1 23个0 0000 1000
        //反码：1 23个1 1111 0111
        //补码：1 23个1 1111 1000
        //右移：b>>2，左边补什么，看最高位，
        //补码：1 23个1 111111 10
        //反码：1 23个1 111111 01
        //原码：1 23个0 0000 0010  -2
        System.out.println(b >> 2);

        //todo 3. >>> 无符号右移 不看最高位，左边直接补0 补码运算
        //b的二进制：
        //原码 1 23个0 0000 1000
        //反码：1 23个1 1111 0111
        //补码：1 23个1 1111 1000
        //无符号右移：b >>> 2,不看最高位，左边直接补0
        //00 1 23个1 1111 10
        System.out.println(b >>> 2);

        System.out.println("-----------------------------");


        //todo $ 按位与  补码运算
        //a的二进制：24个零 0000 1000
        //b的二进制：
        //原码 1 23个0 0000 1000
        //反码：1 23个1 1111 0111
        //补码：1 23个1 1111 1000
        //24个零 0000 1000 & 1 23个1 1111 1000
        //24个零 0000 1000 -》 8
        System.out.println(a & b);

        //24个零 0000 1000 | 1 23个1 1111 1000
        //1 23个1 1111 1000 ->-8
        System.out.println(a | b);

        //24个零 0000 1000 | 1 23个1 1111 1000
        //24个1 1111 0000补码
        //反码：24个1 1110 1111
        //原码：1 23个0 0001 0000 -》 -16
        System.out.println(a ^ b);

        //a的二进制：24个零 0000 1000
        //~a
        //24个1 1111 0111补码
        //反码：24个1 1111 0110
        //原码：1 23个0 0000 1001
        System.out.println(~a);
    }
}
