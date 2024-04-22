package dp.递推;

/**
 * @ClassName leetcode_357_统计各位数字都不同的数字个数
 * @Author zxf
 * @Date 2024/3/12 13:50
 * @Questinon Describrition
 **/
public class leetcode_357_统计各位数字都不同的数字个数 {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        if(n == 1) return 10;

        int res = 10;
        int cur = 9;

        for (int i = 2; i <= n; i++) {
            cur = cur * (11 - i);
            res += cur;
        }

        return res;
    }
}
