package 单调栈;

import java.util.LinkedList;

/**
 * @ClassName leetcode_503_下一个更大元素II
 * @Author zxf
 * @Date 2024/1/26 14:53
 * @Questinon Describrition
 **/
public class leetcode_503_下一个更大元素II {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        LinkedList<Integer> stack = new LinkedList<Integer>();
        //单调递减栈
        for (int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                res[stack.peek()] = nums[i];
                stack.pop();
            }
            stack.push(i);
       }

        //当栈中还有剩余元素 这些元素肯定是递减的 在遍历一下nums数组
        while(!stack.isEmpty()){
            int i = stack.pop();
            //先赋值
            res[i] = -1;
            for (int j = 0; j < i; j++) {
                if(nums[j] > nums[i]){
                    res[i] = nums[j];
                    break;
                }
            }
        }
        return res;
    }
}


