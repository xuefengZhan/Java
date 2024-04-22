package 单调栈;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName leetcode_84_柱状图中最大的矩形
 * @Author zxf
 * @Date 2024/2/26 17:33
 * @Questinon Describrition
 **/
public class leetcode_84_柱状图中最大的矩形 {
    public int largestRectangleArea(int[] heights) {
        int[] lefts = new int[heights.length];
        int[] rights = new int[heights.length];

        Arrays.fill(rights,heights.length);

        //每个元素左边界
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);

        for (int i = 0; i < heights.length; i++) {
            while(stack.peek() != -1 && heights[stack.peek()] > heights[i]){
                rights[stack.pop()] = i;
            }
            //stack.peek() == -1 || heiths[stack.peek()] <= heights[i];
            lefts[i] = stack.peek();
            stack.push(i);
        }

        int res = 0;

        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, heights[i] * (rights[i] - lefts[i] - 1));
        }

        System.out.println(Arrays.toString(lefts));
        System.out.println(Arrays.toString(rights));
        return res;
    }


    public static void main(String[] args) {
        leetcode_84_柱状图中最大的矩形 v = new leetcode_84_柱状图中最大的矩形();
        int[] a = {2,1,5,6,2,3};

        int res = v.largestRectangleArea(a);

        System.out.println(res);
    }
}
