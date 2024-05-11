package dp.No01_入门.最大子数组和;

/**
 * @ClassName leetcode_1191_k次串联后最大子数组之和
 * @Author zxf
 * @Date 2024/4/24 15:22
 * @Questinon Describrition
 *
 *
 *
 **/
public class leetcode_1191_k次串联后最大子数组之和 {
    public int kConcatenationMaxSum(int[] arr, int k) {
//        未完成
//        long max = 0;
//        int n = arr.length;
//
//        int mod = 1000000007;
//
//        long[] dp = new long[n+1];
//
//        for (int i = 1; i <= n; i++) {
//            dp[i] = Math.max( (dp[i-1]+arr[i-1]) % mod, arr[i-1] );
//
//            max = Math.max(max,dp[i]);
//        }
//
//
//        if(dp[n] <= 0 || k == 1) return (int) max;
//
//        //dp[n] > 0 && k > 1
//
//        long max2 = 0;
//
//        dp[0] = dp[n];
//        for (int i = 1; i <= n; i++) {
//            dp[i] = Math.max(dp[i-1]+arr[i-1],arr[i-1]);
//            max2 = Math.max(max2,dp[i]);
//        }
//
//        int diff = (int) (max2 - max);
//        if(dp[n] != dp[0]) return (int) (max + (k-1) * diff);
//        return (int) max2;
        return -1;
    }
}
