package 单调栈;

import java.util.LinkedList;

/**
 * @ClassName leetcode_926_最大宽坡度
 * @Author zxf
 * @Date 2024/1/29 10:25
 * @Questinon Describrition
 **/
public class leetcode_962_最大宽坡度 {
    public int maxWidthRamp(int[] nums) {
        int res = 0;

        //1.维护一个单调递减栈
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[stack.peek()]){
                stack.push(i);
            }
        }

        for (int i = nums.length - 1; i >= res; i--) {
            if(!stack.isEmpty() && nums[i] >= nums[stack.peek()]){
                res = Math.max(res,i - stack.peek());
                stack.pop();
            }
        }

        return res;
    }
}
