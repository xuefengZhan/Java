package 单调栈;

import java.util.LinkedList;

/**
 * @ClassName leetcode_42_接雨水
 * @Author zxf
 * @Date 2024/2/23 14:18
 * @Questinon Describrition
 **/
public class leetcode_42_接雨水 {
    public int trap(int[] height) {
        LinkedList<Integer> stack = new LinkedList<>();

        stack.push(0);

        int res = 0;
        for (int i = 1; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int h = height[stack.pop()];
                if(stack.isEmpty()){
                    continue;
                }

                int left = height[stack.peek()];
                int min = Math.min(left,height[i]);

                res += (min - h) * (i - stack.peek() - 1);
            }

            stack.push(i);
        }
        return res;
    }
}
