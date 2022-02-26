package 二分查找;

/**
 *  二分查找前提： 数组 有序、无重复值
 */
public class introduce {


    /**
     * 模板1 : 左闭右闭区间 []  => 区间特性：  nums[left] <= taget <= nums[right]
     * 注意事项: 区间的边界在迭代的时候，要维持区间特性
     */
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + ( (right - left) >> 1) ;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    /**
     * 模板1 : 左闭右开区间 [)  => 区间特性：  nums[left] <= taget < nums[right]
     * 注意事项: 区间的边界在迭代的时候，要维持区间特性
     */
    public int search2(int[] nums, int target) {

        int left = 0;
        int right = nums.length ;  //

        while(left < right){  //left == right 没有意义
            int mid = left + ( (right - left) >> 1) ;
            if(nums[mid] > target){
                right = mid ; // mid > target 符合 nums[right] > taget 所以right迭代成mid
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
