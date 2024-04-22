package dp.背包问题.零一背包;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName leetcode_2915_和为目标值的最长子序列的长度
 * @Author zxf
 * @Date 2024/3/29 9:31
 * @Questinon Describrition
 *
 *
 * 至少capacity问题
 **/
public class leetcode_2915_和为目标值的最长子序列的长度 {
//    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
//        int m = nums.size();
//
//        //i是目标和 [0,target]
//        //j是数组索引 [0,m]  这里+1的目的是 索引为0表示不取值（空子序列）
//        int[][] dp = new int[target+1][m+1];
//
//        //初始化为-1 表示目标和为i取不到
//        //和为0 初始化为0 空子序列
//        for (int i = 1; i < dp.length; i++) {
//            Arrays.fill(dp[i],-1);
//        }
//
//        //和
//        for (int i = 1; i <= target; i++) {
//            //索引
//            for (int j = 1; j <= m; j++) {
//                Integer cur = nums.get(j-1);
//                dp[i][j] = dp[i][j-1];
//                //和大于当前值
//                if(i >= cur){
//                    if(dp[i - cur][j-1] != -1)  dp[i][j] = Math.max(dp[i][j],dp[i - cur][j-1] + 1);
//                }
//            }
//        }
//
//        //System.out.println(Arrays.deepToString(dp));
//        return dp[target][m];
//    }



    //优化 一维数组
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int m = nums.size();

        int[] dp = new int[target+1];

        //初始化为-1 表示目标和为i取不到
        //和为0 初始化为0 空子序列

        Arrays.fill(dp,-1);
        dp[0] = 0;



            //索引
            for (int j = 1; j <= m; j++) {
                //和
                for (int i = target; i >= 1; i--) {

                Integer cur = nums.get(j-1);

                //和大于当前值
                if(i >= cur){
                    if(dp[i - cur] != -1)  dp[i] = Math.max(dp[i],dp[i - cur] + 1);
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[target];
    }
}
