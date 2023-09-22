package 二分查找;

/**
 * @ClassName leetcode_33_搜索旋转排序数组
 * @Author zxf
 * @Date 2023/5/8 13:01
 *
 * tag: 部分有序
 *
 * 思路： 一分为二 存在三种情况 [4,5,6,7,1,2,3]
 *      1.左边有序 右边无序   [4,5,6] [7,1,2,3]
 *      2.左边无序 右边有序   [4,5,6,7,1] [2,3]
 *      3.两边都有序         [4,5,6,7] [1,2,3]
 **/
public class leetcode_33_搜索旋转排序数组 {
    public int search(int[] nums, int target) {



        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return target == nums[0] ? 0 : -1;


        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = (right - left) / 2 + left;

            if(target == nums[mid]) return mid;

            // [left,mid] 有序
            if(nums[left] < nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                //左边无序 右边有序
                if(nums[mid] <= target && target < nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3};
        //int res = search(nums,3);
    }

}
