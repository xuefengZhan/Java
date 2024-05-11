package dp.No01_入门.最大子数组和;

/**
 * @ClassName leetcode_918_环形子数组的最大和
 * @Author zxf
 * @Date 2024/4/26 10:38
 * @Questinon Describrition
 *
 *
 * 参考题解：https://leetcode.cn/problems/maximum-sum-circular-subarray/solutions/1152143/wo-hua-yi-bian-jiu-kan-dong-de-ti-jie-ni-892u/
 **/
public class leetcode_918_环形子数组的最大和 {
    public int maxSubarraySumCircular(int[] nums) {

        //非空子数组
        int max = nums[0];
        int min = nums[0];

        int n = nums.length;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];

        dpMax[0] = max;
        dpMin[0] = min;
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            dpMax[i] = Math.max(dpMax[i-1]+nums[i],nums[i]);
            dpMin[i] = Math.min(dpMin[i-1]+nums[i],nums[i]);


            max = Math.max(max,dpMax[i]);
            min = Math.min(min,dpMin[i]);
        }


        if(max <= 0) return max;  //说明数组中最大的元素 <= 0

        //最大的元素>0
        return sum - min;
    }
}
