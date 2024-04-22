package 博弈;

import java.util.Arrays;

/**
 * @ClassName leetcode_486_预测赢家
 * @Author zxf
 * @Date 2024/3/25 15:55
 * @Questinon Describrition
 **/
public class leetcode_486_预测赢家 {

//    public boolean predictTheWinner(int[] nums) {
//        return dfs(nums, 0,nums.length - 1,true) >= 0;
//    }
//
//
//
//    private int dfs(int[] nums,int left,int right,boolean turn){
//        if(left == right) return nums[left];
//
//        int a = nums[left];
//        int b = nums[right];
//
//        //dfs(true)   为1号角色（当前分数为正，取最大的）
//        //dfs(false)  是2号角色的最大分数（当前分数为负数，尽可能小）
//        if(turn){
//            return Math.max(a+dfs(nums,left+1,right,false),b+dfs(nums,left,right-1,false));
//        }else{
//            return Math.min(dfs(nums,left+1,right,true)-a,dfs(nums,left,right-1,true)-b);
//        }
//    }


    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] memo = new int[len][len];

        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        return dfs(nums, 0, len - 1, memo) >= 0;
    }

    private int dfs(int[] nums, int i, int j, int[][] memo) {
        //此时只有一种选择，选的人赢对方nums[i]，且没有剩余可选，结束递归
        if (i == j) {
            return nums[i];
        }

        //记忆化搜索
        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }

        //nums[i]是当前选择左边界,是当前+的分数, dfs是后续输掉的分数
        int chooseLeft = nums[i] - dfs(nums, i + 1, j, memo);
        int chooseRight = nums[j] - dfs(nums, i, j - 1, memo);

        //存储记忆
        memo[i][j] = Math.max(chooseLeft, chooseRight);
        return memo[i][j];
    }


}
