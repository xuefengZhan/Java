package 二分查找;

/**
 * @ClassName leetcode_153_寻找旋转排序数组中的最小值
 * @Author zxf
 * @Date 2023/3/7 10:07
 *
 * case 1 :   1  2  3     mid < right  说明最小值的index <= mid
 *
 * case 2 :   2  3  1     mid > right  说明最小值的index > mid
 *
 * case 3 :
 *
 * 找到index，index 比 index - 1要小 返回index
 **/
public class leetcode_153_寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){

            int mid = (right - left) / 2 + left;

            int pivot = nums[mid];
            //在mid右边  另一层含义：当left == right的时候，left右移
            if(pivot  >= nums[right]){
                left = mid + 1;
            }else{
                //为了不让right从最小值跨过去
                right = mid;
            }
        }

        return nums[right];
    }
}
