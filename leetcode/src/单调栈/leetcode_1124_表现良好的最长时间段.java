package 单调栈;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName leetcode_1124_表现良好的最长时间段
 * @Author zxf
 * @Date 2024/2/1 16:27
 * @Questinon Describrition
 **/
public class leetcode_1124_表现良好的最长时间段 {

    public int longestWPI(int[] hours) {
        int[] s = new int[hours.length + 1];
        //todo 1.初始化单调递减栈
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);  //0号元素肯定是push进去的

        for (int i = 1; i < s.length; i++) {
            int cur = hours[i-1] > 8 ? 1 : -1;
            s[i] = s[i-1] + cur;
            if( s[stack.peek()] > s[i]){
                stack.push(i);
            }
        }

        //todo 2
        int res = 0;
        for (int i = s.length - 1; i >= 0; i--) {
            //这段的元素和大于0
            while(!stack.isEmpty() && s[i] - s[stack.peek()] > 0){
                res = Math.max(res,i-stack.peek());
                stack.pop();
            }
        }

        return res;
    }
}
