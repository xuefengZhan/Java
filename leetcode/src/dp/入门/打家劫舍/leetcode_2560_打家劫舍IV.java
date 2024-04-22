package dp.入门.打家劫舍;

import java.util.Arrays;

/**
 * @ClassName leetcode_2560_打家劫舍IV
 * @Author zxf
 * @Date 2023/9/19 9:09
 * @Questinon Describrition
 **/
public class leetcode_2560_打家劫舍IV {

    int[][] dp;

    //dp[i][j] 表示索引为i的时候，还要偷j家的最小窃取能力
    public int minCapability(int[] nums, int k) {
        dp = new int[nums.length][k+1];


        dfs(nums,0,k);

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.min(dp[i][k],res);
        }
        return res;
    }


    // nums.length - start 是个数   >= 2 * k - 1
    private int dfs(int[] nums,int start,int k){

        if(k == 0 || start > nums.length - 2*k + 1) return 0;

        if(dp[start][k] != 0) return dp[start][k];

        System.out.println("start" + start);
        System.out.println("k" + k);


        int res = Integer.MAX_VALUE;
        //当前可选项
        for (int i = start; i  <= nums.length - 2*k + 1 ; i++) {
            int choose = nums[i];
            int left = dfs(nums,start+2,k-1);

            int local = Math.max(choose,left);


            dp[i][k] = local;
            //res = Math.max(dp[start][k],res);
            res = Math.min(res,local);
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = {2,3,5,9};
        int k = 2;

        leetcode_2560_打家劫舍IV v = new leetcode_2560_打家劫舍IV();

        int res = v.minCapability(nums, k);

        System.out.println(res);
    }

}
