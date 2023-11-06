package dp.子序列问题;

import java.util.Arrays;

public class leetcode_300_最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = 1;
        int res = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = 1; //给默认值
            for(int j = i-1;j>=0;j--){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
