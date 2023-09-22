package 二分查找;

/**
 * @ClassName leetcode_153_寻找旋转排序数组中的最小值
 * @Author zxf
 * @Date 2023/3/7 10:07
 *
 *
 * 找到index，index 比 index - 1要小 返回index
 **/
public class leetcode_154_寻找旋转排序数组中的最小值2 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        //在[low,high]范围内查找最小值
        while(low <= high){
            int mid = (high - low) / 2 + low;

            int pivot = nums[mid];

            if(pivot > nums[high]){
                low = mid + 1;
            }else if(pivot < nums[high]){
                high = mid;
            }else{
                high --;
            }
        }
        //low = high + 1 有两种情况：
        //1. high = 最小值
        //2. high = -1 全局都是同一个数
        return nums[low];
    }
}
