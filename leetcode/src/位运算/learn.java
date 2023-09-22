package 位运算;

public class learn {
    public static void main(String[] args) {
        int a = 8;  //    0000 0000 0000 0000 0000 0000 0000 1000
        int b = -8; //    1000 0000 0000 0000 0000 0000 0000 1000
                    // 反：1111 1111 1111 1111 1111 1111 1111 0111
                    // 补：1111 1111 1111 1111 1111 1111 1111 1000

        //todo 1.正数测试
        // 原码
        String s1 = Integer.toBinaryString(a);  //原码 - 反码 - 补码：0000 0000 0000 0000 0000 0000 0000 1000
        System.out.println(s1);  // 1000

        //Integer.toBinaryString 打印补码
        String s2 = Integer.toBinaryString(~a);
        // ~a :
        // 补码：1111 1111 1111 1111 1111 1111 1111 0111
        // 反码：1111 1111 1111 1111 1111 1111 1111 0110
        // 原码：1000 0000 0000 0000 0000 0000 0000 1001  即 -9
        System.out.println(~a);       //-9
        System.out.println(s2);       //1111 1111 1111 1111 1111 1111 1111 0111

        System.out.println("=========================================");

        //todo 2.负数测试
        String f1 = Integer.toBinaryString(b);
        System.out.println(f1);   //-8的补：1111 1111 1111 1111 1111 1111 1111 1000

        String f2 = Integer.toBinaryString(~b);
        // 补：  1111 1111 1111 1111 1111 1111 1111 1000
        // 取反：                                    0111
        System.out.println(f2);   //111
        System.out.println(~b);   //7
        System.out.println(-b == ((~b) + 1));
    }
}
