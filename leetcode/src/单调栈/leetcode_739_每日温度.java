package 单调栈;

import java.util.Stack;

/**
 * @ClassName leetcode_739_每日温度
 * @Author zxf
 * @Date 2024/1/25 17:44
 * @Questinon Describrition
 **/
public class leetcode_739_每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        stack.push(0);
        for (int i = 0; i < temperatures.length; i++) {
            //当前节点位置
            int temperature = temperatures[i];

            if(stack.isEmpty()){
                stack.push(i);
            }else{
               //栈不为空 且 temp > temp[peek]
                while(!stack.isEmpty() && temperature > temperatures[stack.peek()]){
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }
}
