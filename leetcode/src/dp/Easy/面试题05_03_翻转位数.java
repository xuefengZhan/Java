package dp.Easy;

/**
 * @ClassName 面试题05_03_翻转位数
 * @Author zxf
 * @Date 2023/8/21 16:50
 * @Questinon Describrition
 **/
public class 面试题05_03_翻转位数 {
    public int reverseBits(int num) {
        int a = 0; //
        int b = 0; //

        int res = 0;
        int tmp = 0;

        for (int i = 0; i < 32; i++) {
            if( (num & 1) == 1 ){
                tmp++;
            }else{
                b = a; //上一次连续1个数
                a = tmp; //这一次连续1个数

                res = Math.max(b + a + 1, res);
                tmp = 0;
            }

            System.out.println("i == " + i);
            System.out.println("a == " + a);
            System.out.println("b == " + b);
            num = num >> 1;
        }

        //i=32的时候 也需要做一次
        b = a;
        a = tmp;

        res = a == 32 ? 32 : Math.max(b + a + 1, res);



        return res;
    }

    public static void main(String[] args) {
        面试题05_03_翻转位数 v = new 面试题05_03_翻转位数();
        int num = Integer.MAX_VALUE;
        int res = v.reverseBits(num);

        System.out.println(res);
    }
}
