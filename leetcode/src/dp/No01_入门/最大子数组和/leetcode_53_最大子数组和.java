package dp.No01_入门.最大子数组和;

/**
 * @ClassName leetcode_53_最大子数组和
 * @Author zxf
 * @Date 2024/4/22 17:43
 * @Questinon Describrition
 **/
public class leetcode_53_最大子数组和 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];

        int res = dp[0];

        for (int i = 1; i < n; i++) {
            if(dp[i-1] < 0){
                dp[i] = nums[i];
            }else{
                dp[i] = dp[i-1] + nums[i];
            }

            res = Math.max(dp[i],res);
        }

        return res;
    }
}
