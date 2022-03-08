package 滑动窗口;

/**
 * https://leetcode-cn.com/problems/2VG8Kg/
 *
 * mid  99.95%
 */
public class 剑指Offer008_和大于等于target的最短子数组 {
    public int minSubArrayLen(int target, int[] nums) {

        if(nums[0] >= target) return 1;


        //定义窗口： 窗口内元素和 < target
        int left = 0;
        int right = 0;

        int sum = 0;
        int res = Integer.MAX_VALUE;

        while(right <  nums.length ){
            sum += nums[right];
            //todo 如果满足条件
            if(sum >= target){
                //移动左指针 到窗口不满足条件
                while(sum >= target){
                    sum -= nums[left++];
                }
                //更新最小值
                //此时窗口不满足条件 right - left + 1 是窗口大小， left再往左边移动一个就满足了
                // 所以 窗口size + 1
                res = Math.min(right - left + 2,res);
            }
            right++;
        }

        //2 3 1 2
        //
        return res == Integer.MAX_VALUE? 0 : res;
    }


    public static void main(String[] args) {
        剑指Offer008_和大于等于target的最短子数组 v = new 剑指Offer008_和大于等于target的最短子数组();
        int[] nums = {1,1,1,1,1,1,1,1};
        int target = 11;

        System.out.println(v.minSubArrayLen(target,nums));
    }
}
