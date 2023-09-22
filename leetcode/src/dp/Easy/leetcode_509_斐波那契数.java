package dp.Easy;

/**
 * @ClassName leetcode_509_斐波那契数
 * @Author zxf
 * @Date 2023/8/15 10:19
 * @Questinon Describrition
 **/
public class leetcode_509_斐波那契数 {
    public int fib(int n) {
        if(n <= 1) return n;

        int a = 0;
        int b = 1;

        for(int i = 2;i<=n;i++){
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
}
