package dp;

/**
 * https://leetcode-cn.com/problems/maximum-difference-between-increasing-elements/
 * easy
 */
public class No2016_增量元素之间的最大差值 {
    public int maximumDifference(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) return -1;

        //todo 1.状态初始化
        int[] dp = new int[nums.length + 1] ;
        dp[1] = -1;

        //todo 2.状态转移方程：
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]){
                dp[i+1] = Math.max(dp[i],dp[i] + nums[i] - nums[i-1]);
            }else{
                dp[i + 1] = Math.max(-1,dp[i-1]);
            }
        }

        return -1;

    }

}
