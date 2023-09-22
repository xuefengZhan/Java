package 二分查找;

import java.util.Arrays;

/**
 * @ClassName leetcode_1608_特殊数组的特征值
 * @Author zxf
 * @Date 2023/3/1 17:37
 **/
public class leetcode_1608_特殊数组的特征值 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0;i<=nums[nums.length-1];i++){
            if(findSpecial(nums, 0, nums.length - 1, i)) return i;
        }
        return -1;
    }

    // 找一个位置 大于左边的  小于等于右边的
    //特征：左边界索引为 index   那么个数就是  length - index
    private boolean findSpecial(int[] nums,int start,int end,int goal){

        while(start <= end){
            int mid = (end - start) / 2 + start;

            if(nums[mid] < goal){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        // start = end + 1
        // nums[start] >= goal
        // nums[end] < goal
        return nums.length - start == goal;
    }


    public static void main(String[] args) {
        leetcode_1608_特殊数组的特征值 v = new leetcode_1608_特殊数组的特征值();

        //int[] nums = {3,5};
        //int[] nums = {0,0};

        int[] nums = {3,6,7,7,0};
        int i = v.specialArray(nums);
        System.out.println(i);
    }
}
