package 二分查找;

/**
 * @ClassName leetcode_35_搜索插入位置
 * @Author zxf
 * @Date 2023/4/18 9:16
 **/
public class leetcode_35_搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = (right - left) / 2 + left;

            if(nums[mid] == target) return mid;

            if(nums[mid] > target) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        //right的元素是小于target的，所以插入在left
        return left;
    }

    public static void main(String[] args) {
        leetcode_35_搜索插入位置 v = new leetcode_35_搜索插入位置();
        int[] nums = {1,3,5,6};
        int target = 2;

        int i = v.searchInsert(nums, target);
        System.out.println(i);
    }
}
