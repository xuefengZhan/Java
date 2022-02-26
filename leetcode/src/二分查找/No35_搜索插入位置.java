package 二分查找;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * easy
 */
public class No35_搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;



        while(start <= end){
            int mid =  start + ((end - start) >> 1);  // mid >= start
            if(nums[mid] > target){
                end = mid - 1;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                return mid;
            }
        }


        //此时：start = end + 1 没找到

        //情况1  start = mid + 1 ->   start = end + 1  -> 说明 end = mid,   只有end = start的时候，才会有mid = end ,
        // 由于nums[mid] < target,才会有start = mid + 1,也就是说 nums[end] < target,所以在end后面插入


        // end = mid - 1 -> end = start - 1 => mid = start =>  要么 start = end 要么 end = start + 1


        // 简而言之：
        // 此时的状态是：start = end + 1
        // 如果是end = mid - 1导致的，那么nums[mid] > target,mid = start 所以选start
        // 如果是start = mid + 1导致的，那么nums[mid] < target ,mid = end,所以选start


        return start;

    }
}
