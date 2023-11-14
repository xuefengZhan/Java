package 单调栈;

import java.util.Stack;

/**
 * @ClassName leetcode_496_下一个更大的元素
 * @Author zxf
 * @Date 2023/11/9 16:44
 * @Questinon Describrition
 **/
public class leetcode_496_下一个更大的元素 {
    int[] map = new int[10001];
    Stack<Integer> stack = new Stack<>();

    int[] res;
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        res = new int[nums1.length];

        for (int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && nums2[i] > stack.peek()){
                int a = stack.pop();
                map[a] = nums2[i];
            }

            //stack空了  或者 <
            stack.push(nums2[i]);
        }

        for (Integer integer : stack) {
            map[integer] = -1;
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map[nums1[i]];
        }

        return res;
    }
}
