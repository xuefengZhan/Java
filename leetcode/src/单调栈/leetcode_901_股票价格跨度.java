package 单调栈;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ClassName leetcode_901_股票价格跨度
 * @Author zxf
 * @Date 2024/2/1 11:58
 * @Questinon Describrition
 **/
public class leetcode_901_股票价格跨度 {

    class StockSpanner {
        LinkedList<Integer> stack ;
        ArrayList<Integer> arr ;
        int index;

        public StockSpanner() {
            stack =  new LinkedList<>();
            arr = new ArrayList<>();
        }

        public int next(int price) {
            arr.add(price);
            //todo 当price大于栈顶元素的时候
            while(!stack.isEmpty() && price >= arr.get(stack.peek()) ){
                stack.pop();
            }
            // 此时price < 栈顶 或者栈为空
            int res ;
            if(stack.isEmpty()){
                res = index + 1;
            }else{
                res = index - stack.peek();
            }

            //放进新的元素
            stack.push(index++);
            return res;
        }
    }
}
