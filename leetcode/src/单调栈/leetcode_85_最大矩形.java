package 单调栈;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName leetcode_85_最大矩形
 * @Author zxf
 * @Date 2024/2/27 15:12
 * @Questinon Describrition
 **/
public class leetcode_85_最大矩形 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] arr = new int[n];

        int res = 0;

        for (int i = 0; i < m; i++) {
            char[] chars = matrix[i];

            for (int j = 0; j < n; j++) {
                if(chars[j] == '0'){
                    arr[j] = 0;
                }else{
                    arr[j] += arr[j];
                }
            }
            res = Math.max(res,largestRectangleArea(arr));
        }


        return res;

    }


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
}
