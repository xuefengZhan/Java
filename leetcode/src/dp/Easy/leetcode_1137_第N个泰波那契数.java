package dp.Easy;

/**
 * @ClassName leetcode_1137_第N个泰波那契数
 * @Author zxf
 * @Date 2023/8/18 10:45
 * @Questinon Describrition
 **/
public class leetcode_1137_第N个泰波那契数 {
    public int tribonacci(int n) {


        if(n<=1) return n;
        if(n == 2) return 1;
        int a = 0;
        int b = 1;
        int c = 1;
        int d = 0;
        for (int i = 3; i <= n; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return d;
    }
}
