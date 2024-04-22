package dp.求子序列;

import java.util.Arrays;

/**
 * @ClassName leetcode_376_摆动序列
 * @Author zxf
 * @Date 2024/3/13 14:50
 * @Questinon Describrition
 **/
public class leetcode_376_摆动序列 {
    //O(n^2)
    //方式1 ： 这里状态定义的是
//    public int wiggleMaxLength(int[] nums) {
//        int n = nums.length;
//        //dp[i] 表示第i个元素作为摆动序列最后一个元素
//        // dp[i][0]   ：  nums[i]是上升
//        // dp[i][1]   ：  nums[i]是下降
//        int[][] dp = new int[n][2];
//
//        for (int[] dpi : dp) {
//            Arrays.fill(dpi,1);
//        }
//
//        int res = 1;
//
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if(nums[j] < nums[i]){
//                    dp[i][0] = Math.max(dp[j][1] + 1, dp[i][0]);
//                }else if(nums[j] > nums[i]){
//                    dp[i][1] = Math.max(dp[j][0] + 1, dp[i][1]);
//                }
//            }
//
//            res = Math.max(Math.max(dp[i][1],dp[i][0]),res);
//        }
//        System.out.println(Arrays.deepToString(dp));
//        return res;
//    }


    //方式2 ： O(n)

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        //dp[i] ：[0,i] 范围内最长摆动序列
        //dp[i][0] ： 表示第i个元素作为正向的长度
        //dp[i][1] ： 代表第i个元素作为负向的长度
        int[][] dp = new int[n][2];

        for (int[] dpi : dp) {
            Arrays.fill(dpi,1);
        }

        int res = 1;

        for (int i = 1; i < n; i++) {

            int j = i - 1;
            if(nums[j] < nums[i]){
                //比前一个大
                dp[i][0] = Math.max(dp[j][1] + 1, dp[j][0]);
                dp[i][1] = dp[j][1];
            }else if(nums[j] > nums[i]){
                dp[i][1] = Math.max(dp[j][0] + 1, dp[j][1]);
                dp[i][0] = dp[j][0];
            }else{
                dp[i][1] = dp[j][1];
                dp[i][0] = dp[j][0];
            }
            res = Math.max(Math.max(dp[i][1],dp[i][0]),res);
        }

        System.out.println(Arrays.deepToString(dp));
        return res;
    }
}
