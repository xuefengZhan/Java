package dp.No01_入门.最大子数组和;

/**
 * @ClassName leetcode_1749_任意子数组和的绝对值的最大值
 * @Author zxf
 * @Date 2024/4/24 14:02
 * @Questinon Describrition
 **/
public class leetcode_1749_任意子数组和的绝对值的最大值 {
//    public int maxAbsoluteSum(int[] nums) {
//        int res = Integer.MIN_VALUE;
//        int n = nums.length;
//
//        int[] max = new int[n+1];
//        int[] min = new int[n+1];
//
//        for (int i = 1; i <= n; i++) {
//            max[i] = Math.max(max[i-1] + nums[i-1],nums[i-1]);
//            min[i] = Math.min(min[i-1] + nums[i-1],nums[i-1]);
//
//            int cur = Math.max(Math.abs(max[i]),Math.abs(min[i]));
//            res = Math.max(res,cur);
//        }
//
//        return res;
//    }

//    public int maxAbsoluteSum(int[] nums) {
//        int res = Integer.MIN_VALUE;
//        int n = nums.length;
//
//        int  mx = 0 ;
//        int  mn = 0 ;
//
//        for (int i = 1; i <= n; i++) {
//            mx = Math.max(mx + nums[i-1],nums[i-1]);
//            mn = Math.min(mn + nums[i-1],nums[i-1]);
//
//            int cur = Math.max(Math.abs(mx),Math.abs(mn));
//            res = Math.max(res,cur);
//        }
//
//        return res;
//    }


    //max(|preSum[i,j)|) = max(|preSum[j] - preSum[i]|)
    //前缀和中最大的减去前缀和的最小值
    public int maxAbsoluteSum(int[] nums) {
        int res = Integer.MIN_VALUE;

        int max = 0;
        int min = 0;

        int prev = 0;
        for (int i = 0; i < nums.length; i++) {

            prev = prev + nums[i];
            max = Math.max(max,prev);
            min = Math.min(min,prev); //


        }

        res = max - min;

        return res;
    }
}
