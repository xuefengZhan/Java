package 单调栈;

import java.util.Stack;

/**
 * @ClassName leetcode_1475_商品折扣后的最终价格
 * @Author zxf
 * @Date 2023/11/9 17:49
 * @Questinon Describrition
 **/
public class leetcode_1475_商品折扣后的最终价格 {

//    public int[] finalPrices(int[] prices) {
//        //这里有重复数据 所以栈只能放索引
//        Stack<Integer> stack = new Stack<Integer>() ;
//        //map同理放索引  key为索引即可
//        int[] map = new int[500];
//        int[] res =  new int[prices.length];
//
//        for (int i = 0; i < prices.length; i++) {
//            while(! stack.isEmpty() && prices[i] <= prices[stack.peek()]){
//                Integer pop = stack.pop();
//                map[pop] = prices[i];
//            }
//
//            //stack为空
//            stack.push(i);
//        }
//
//        while (!stack.isEmpty()) {
//            map[stack.pop()] = 0;
//        }
//
//        for (int i = 0; i < prices.length; i++) {
//            res[i] = prices[i] -  map[i] ;
//        }
//
//
//        return res;
//    }

        public int[] finalPrices(int[] prices) {
        //这里有重复数据 所以栈只能放索引
        Stack<Integer> stack = new Stack<Integer>() ;
        for (int i = 0; i < prices.length; i++) {
            while(! stack.isEmpty() && prices[i] <= prices[stack.peek()]){
                Integer pop = stack.pop();
                prices[i] -= prices[i];
            }
            //stack为空
            stack.push(i);
        }
        return prices;
    }

}
