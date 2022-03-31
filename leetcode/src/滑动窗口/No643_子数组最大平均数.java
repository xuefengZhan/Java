package 滑动窗口;

/**
 * 平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 */
public class No643_子数组最大平均数 {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int windowSum = 0;
        double max = 0;

        for(int i = 0;i< k;i++){
            windowSum += nums[i];
        }

        for(int i = k;i< nums.length;i++){
            int tmp = windowSum - nums[i - k + 1] + nums[k];
            windowSum = tmp;
            max = Math.max(tmp,windowSum);
        }

        return  max / k;

    }
}
