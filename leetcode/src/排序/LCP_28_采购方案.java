package 排序;

import java.util.Arrays;

/**
 * @ClassName LCP_28_采购方案
 * @Author zxf
 * @Date 2023/3/6 13:49
 **/
public class LCP_28_采购方案 {
    public int purchasePlans(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        Arrays.sort(nums);

        int res = 0;

        while (start < end) {
            int left = nums[start];
            int right = nums[end];

            if (left + right > target) {
                end--;
            } else {
                res  = (res + end - start) % 1000000007;
                start++;
            }
        }
        return res;
    }

}
