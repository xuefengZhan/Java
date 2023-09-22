package 二分查找;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName leetcode_2089_找出数组等于目标的所有下标
 * @Author zxf
 * @Date 2023/3/1 18:23
 **/
public class leetcode_2089_找出数组等于目标的所有下标 {
    public List<Integer> targetIndices(int[] nums, int target) {

        Arrays.sort(nums);
        int left = findLeft(nums,0,nums.length-1,target);
        int right = findRight(nums,0,nums.length-1,target);

        //left  >= target
        //right <= target
        ArrayList<Integer> res =  new ArrayList<Integer>();

        //左边界大于有边界肯定不符合
        if(left > right) return res;
        //如果有等于target元素的 那么left就是左边界   right就是右边界
        for(int i = left;i<=right;i++){
            res.add(i);
        }
        return res;
    }

    //找左边界
    private int findLeft(int[] nums,int start,int end,int target){

        while(end >= start){

            int mid = (end - start) / 2 + start;

            int tmp = nums[mid];
            if(tmp < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        //start 必定 >= target
        return start;
    }

    //找右边界
    private int findRight(int[] nums,int start,int end,int target){

        while(end >= start){
            int mid = (end - start) / 2 + start;

            int tmp = nums[mid];
            if(tmp <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        //end 必定<= target
        return end;
    }


    public static void main(String[] args) {
        leetcode_2089_找出数组等于目标的所有下标 vb = new leetcode_2089_找出数组等于目标的所有下标();

        int[] nums = {1,2,5,2,3};
        int target = 2;

        List<Integer> res = vb.targetIndices(nums, target);

        System.out.println(res);
    }
}
