package dp.Mid;

import java.util.Arrays;

/**
 * @ClassName leetcode_45_跳跃游戏II
 * @Author zxf
 * @Date 2023/8/24 9:30
 * @Questinon Describrition
 **/
public class leetcode_45_跳跃游戏II {
//    public int jump(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n];
//
//        dp[0] = 0;
//
//        for (int i = 1; i < n; i++) {
//            dp[i] = Integer.MAX_VALUE;
//        }
//
//        for (int i = 0; i < n; i++) {
//            int len = nums[i];
//            for(int j = i + 1;j <= Math.min(i + len,n-1);j++){
//                dp[j] = Math.min(dp[i] + 1,dp[j]);
//            }
//        }
//
//        System.out.println(Arrays.toString(dp));
//
//        return dp[n-1];
//    }


    //{2,3,0,1,4}
    //阶段1 ： index = 0; maxIndex = 2;
    //阶段2 ： index = [1,2]; maxIndex = 1 + 3 = 4
    //阶段3 ： index = [1,4]
    public int jump(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;
        int end = 0;
        int res = 0;

        for (int i = 0; i < n - 1;i++) {

            // 当前可以达到的最大位置
            maxIndex = Math.max(maxIndex,i+nums[i]);

            // end记录的是每个阶段的节点
            if(i == end){
                end = maxIndex;
                res++;
            }
        }


        return res;
    }


    public static void main(String[] args) {
        leetcode_45_跳跃游戏II v = new leetcode_45_跳跃游戏II();
        int[] nums = {2,3,0,1,4};

        int jump = v.jump(nums);

        System.out.println(jump);
    }
}
