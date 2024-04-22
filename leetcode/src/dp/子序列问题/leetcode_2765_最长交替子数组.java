package dp.子序列问题;

import java.util.Arrays;

/**
 * @ClassName leetcode_2765_最长交替子数组
 * @Author zxf
 * @Date 2024/1/23 16:23
 * @Questinon Describrition
 **/
public class leetcode_2765_最长交替子数组 {
    public int alternatingSubarray(int[] nums) {
        int prev = 0;
        int cur = 0;
        int[] dp = new int[nums.length];
        int res = -1;
        for (int i = 1; i < nums.length; i++) {
            cur = nums[i] - nums[i-1];

            if(cur == 1){
                //子序列起始条件
                if(prev != -1 || dp[i-1] == 0){
                    dp[i] = 2;
                    res = Math.max(dp[i],res);
                }else{
                    dp[i] = dp[i-1]+1;
                    res = Math.max(dp[i],res);
                }
            }else if(cur == -1){
                if(prev != 1){
                    dp[i] = 0;
                }else{
                    dp[i] = dp[i-1]+1;
                    res = Math.max(dp[i],res);
                }
            }else{
                dp[i] = 0;
            }

            prev = cur;
        }

        return res;
    }
}
