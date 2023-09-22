package 二分查找;

/**
 * @ClassName leetcode_2540_最小公共值
 * @Author zxf
 * @Date 2023/3/2 9:27
 *
 *  思路：从小往大遍历nums1，在nums2找 找到第一个即答案
 **/

public class leetcode_2540_最小公共值 {
    public int getCommon(int[] nums1, int[] nums2) {
        for (int i : nums1) {
            if(find(nums2,i)) return i;
        }
        return -1;
    }



    private boolean find(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;

        while(right >= left){
            int mid = (right - left) / 2 + left;

            int tmp = nums[mid];
            if(tmp == target) return true;
            if(tmp > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return false;
    }
}
