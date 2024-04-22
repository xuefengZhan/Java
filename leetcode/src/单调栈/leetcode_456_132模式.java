package 单调栈;

import java.util.LinkedList;

/**
 * @ClassName leetcode_456_132模式
 * @Author zxf
 * @Date 2024/2/2 10:11
 * @Questinon Describrition
 **/
public class leetcode_456_132模式 {


    public boolean find132pattern(int[] nums) {

        //单调递增栈
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int n = nums.length - 1;

        //声明一个变量存储第三个元素（2）
        int rightMax  = Integer.MIN_VALUE;

        //i j k ; 这里的i是第二个元素（3）
        for (int i = n ; i >= 0; i--) {

            //todo 1. 小于的情况
            //如果比2还小则返回true  如果比2大则放进栈中就好
            if(nums[i] < rightMax){
                return true;
            }

            //todo 大于的情况
            while(!stack.isEmpty() && nums[i] > stack.peek()){
                rightMax = stack.pop();  //栈顶 右边最大的
            }

            stack.push(nums[i]); //栈顶元素
        }

        return false;
    }
}