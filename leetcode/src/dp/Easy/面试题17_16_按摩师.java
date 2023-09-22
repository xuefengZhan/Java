package dp.Easy;

import java.util.Arrays;

/**
 * @ClassName 面试题17_16_按摩师
 * @Author zxf
 * @Date 2023/8/23 11:48
 * @Questinon Describrition
 *
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 **/
public class 面试题17_16_按摩师 {
    public int massage(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int n = nums.length+1 ;
        int[] dp = new int[n];


        dp[0] = 0;
        dp[1] = nums[0];

        //dp[i] 对应 nums[i-1]
        for(int i = 2;i<n;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i - 1]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] nums = {2,1,4,5,3,1,1,3};

        面试题17_16_按摩师 v = new 面试题17_16_按摩师();

        int massage = v.massage(nums);
        System.out.println(massage);
    }
}
