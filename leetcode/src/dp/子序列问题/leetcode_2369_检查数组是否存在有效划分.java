package dp.子序列问题;

import java.util.Arrays;

/**
 * @ClassName leetcode_2369_检查数组是否存在有效划分
 * @Author zxf
 * @Date 2024/3/5 9:35
 * @Questinon Describrition
 **/
public class leetcode_2369_检查数组是否存在有效划分 {

    boolean[] dp ;
    public boolean validPartition(int[] nums) {

        int n = nums.length ;
        dp = new boolean[n];

        dp[1] = isValid(nums,0,1);

        if(n ==2) return dp[1];

        dp[2] = isValid(nums,0,2);

        for (int i = 3; i < n; i++) {
            dp[i] = dp[i-2] && isValid(nums,i-1,i);
            dp[i] = dp[i] || (dp[i-3] && isValid(nums,i-2,i));
        }


        return dp[n-1];
    }



    private boolean isValid(int[] nums,int start,int end){
        if(start < 0) return false;

        if(end - start == 1){
            return  nums[start] == nums[end];
        }else if(end - start == 2){
            boolean a = nums[start] == nums[end] && nums[start] == nums[start+1] ;
            boolean b = nums[start] + 1== nums[start+1] && nums[start+1] + 1 == nums[end];

            return a || b;

        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        leetcode_2369_检查数组是否存在有效划分 v = new leetcode_2369_检查数组是否存在有效划分();

        int[] nums = {4,4,4,5,6};

        boolean res = v.validPartition(nums);

        System.out.println(res);
    }
}
