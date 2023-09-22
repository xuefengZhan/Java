package 二分查找;

/**
 * @ClassName leetcode_162_寻找峰值
 * @Author zxf
 * @Date 2023/6/19 17:35
 *
 * 100%
 **/
public class leetcode_162_寻找峰值 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = (right - left) / 2 + left;


            if(nums[mid] > nums[mid+1]){
                //mid可能是峰值
                right = mid;
            }else{
                //mid < mid + 1   mid+1 可能是峰值
                left = mid + 1;
            }
        }

        //left > 或者 = right
        //left = mid + 1 当right = mid的时候才会存在
        //right = mid ,那么left 也要 = mid 才会有 新的mid = right

        return right;
    }
}
