package dp;

import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
        }

        if((sum & 1) == 1) return false;

        int half = sum / 2;

        //dp[i] 表示背包容量为i的时候的最大值
        //由于是一半，因此当容量为一半的时候，是最大值
        int[] dp = new int[half + 1];

        for(int i = 0;i<nums.length;i++){
            //当前背包容量为j的时候
            for(int j = half;j >= nums[i];j--){
                dp[j] = Math.max(dp[j - nums[i]] + nums[i] , dp[j]);
            }
        }


        System.out.println(Arrays.toString(dp));

        return dp[half] == sum / 2;
    }

    public static void main(String[] args) {
        Solution v = new Solution();
        int[] nums = new int[]{1,11,5,5};
        boolean b = v.canPartition(nums);
        System.out.println(b);
    }

}