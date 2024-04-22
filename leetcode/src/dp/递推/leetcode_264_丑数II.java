package dp.递推;

import java.util.HashSet;

/**
 * @ClassName leetcode_264_丑数II
 * @Author zxf
 * @Date 2024/3/11 17:11
 * @Questinon Describrition
 **/
public class leetcode_264_丑数II {
    // 超时
//    public int nthUglyNumber(int n) {
//        //dp[i] = 1 表示i是丑数
//        HashSet<Float> set = new HashSet<>();
//
//        if(n == 1) return 1;
//        set.add(1.0f);
//
//        int i = 1;
//        float cur = 2.0f;
//        while(i < n){
//            float a = cur / 2.0f;
//            float b = cur / 3.0f;
//            float c = cur / 5.0f;
//
//            if(set.contains(a) || set.contains(b) || set.contains(c)){
//                set.add(cur);
//                System.out.println(cur);
//                i++;
//            }
//            cur ++;
//        }
//
//        return (int) (cur-1.0f);
//    }

    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
