package 单调栈;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName leetcode_1475_商品折扣后的最终价格
 * @Author zxf
 * @Date 2023/11/9 17:49
 * @Questinon Describrition
 **/
public class leetcode_1475_商品折扣后的最终价格 {

    public int[] finalPrices(int[] prices) {
        LinkedList<Integer> stack = new LinkedList<>();

        int[] res = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            while( !stack.isEmpty() && prices[i] <= prices[stack.peek()]){
                res[stack.peek()] = prices[stack.peek()] - prices[i];
                stack.pop();
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            Integer i = stack.pop();
            res[i] = prices[i];
        }

        return res;
    }

}
