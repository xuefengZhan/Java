package 二分查找;

/**
 * @ClassName leetcode_34_在排序数组中查找元素的第一个和最后一个位置
 * @Author zxf
 * @Date 2023/3/6 15:27
 *
 *
 * mid
 **/
public class leetcode_34_在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int[] res  = {-1,-1};
        if(nums == null || nums.length == 0) return res;

        int left = findLeft(nums,target);
        int right = findRight(nums,target);

        if(left == -1 || right == -1 || left > right) return res;
        return new int[]{left,right};

    }


    private int findLeft(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;

        int res = -1;

        while(left <= right){
            int mid = (right - left) / 2 + left;

            //right < target
            if(nums[mid] >= target){
                res = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return  res ;
    }

    private int findRight(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        while(left <= right){
            int mid = (right - left) / 2 + left;

            //find index > target
            if(nums[mid] <= target){
                res = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return  res ;
    }
}
