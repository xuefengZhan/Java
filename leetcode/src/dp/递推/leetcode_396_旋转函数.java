package dp.递推;

import java.util.Arrays;

/**
 * @ClassName leetcode_396_旋转函数
 * @Author zxf
 * @Date 2024/3/14 10:09
 * @Questinon Describrition
 **/
public class leetcode_396_旋转函数 {
    public int maxRotateFunction(int[] nums) {
        int a = 0;

        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            a += nums[i];
            dp[0] += i * nums[i];
        }

        System.out.println("a == " + a);
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            //dp[i] = dp[i-1] - (n-1) * nums[n-i] + a - nums[n-i];
            dp[i] = dp[i-1] - n * nums[n-i] + a;
            res = Math.max(res,dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }
}
