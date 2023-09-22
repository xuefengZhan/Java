package 二分查找;

/**
 * @ClassName leetcode_2529_正整数和负整数的最大计数
 * @Author zxf
 * @Date 2023/3/2 9:12
 *
 *
 * easy
 *
 * 思路：找到索引index , index-1 位置为负数  index 为正数
 **/
public class leetcode_2529_正整数和负整数的最大计数 {
    public int maximumCount(int[] nums) {



        int left = findLeft(nums) + 1;
        int right = nums.length - findRight(nums);

        return Math.max(left,right);
    }
    private int findLeft(int[] nums){
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = (end - start) / 2 + start;

            //确保start >= 0
            // end < 0
            if(nums[mid] < 0){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return end;
    }

    private int findRight(int[] nums){
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = (end - start) / 2 + start;

            //确保start > 0
            // end <= 0
            if(nums[mid] <= 0){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return start;
    }


    public static void main(String[] args) {
        leetcode_2529_正整数和负整数的最大计数 v = new leetcode_2529_正整数和负整数的最大计数();

        int[] nums = {5,20,66,1314};

        int res = v.maximumCount(nums);

        System.out.println(res);

    }
}
