package 单调栈;

import java.util.*;

/**
 * @ClassName leetcode_2866_美丽塔Ⅱ
 * @Author zxf
 * @Date 2024/2/20 16:39
 * @Questinon Describrition
 **/
public class leetcode_2866_美丽塔Ⅱ {
    //O(n^2) 复杂度  超时
//    public long maximumSumOfHeights(List<Integer> maxHeights) {
//        int n = maxHeights.size();
//        int[] arr = new int[n];
//        long res = 0;
//        //第一层 枚举峰值
//        for (int i = 0; i < n; i++) {
//            int max = maxHeights.get(i);
//            long curRes = max;
//
//            arr[i] = max;
//
//            //峰值左边 非单调递增
//            for (int j = i - 1; j >= 0; j--) {
//                arr[j] = Math.min(arr[j+1],maxHeights.get(j));
//                curRes += arr[j];
//            }
//
//            //峰值右边 非单调递减
//            for (int k = i + 1; k < n; k++) {
//                arr[k] = Math.min(maxHeights.get(k),arr[k-1]);
//                curRes += arr[k];
//            }
//
//            res = Math.max(res,curRes);
//        }
//
//        return res;
//    }

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();

        long res = 0;
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();

        long[] arr1 = new long[n]; // 存放以i为结尾的单调非减和
        long[] arr2 = new long[n]; // 存放以i为开头的单调非增和


        //dp 正向单调非减序列
        //arr[i] = arr[prev] + a[i] * (i - prev) ;  prev是栈中下一个元素的索引
        for (int i = 0; i < n; i++) {

            while(!stack1.isEmpty() && maxHeights.get(i) < maxHeights.get(stack1.peek()) ){
                stack1.pop();
            }

            //此时栈为空或者 栈顶元素 >= get(i)
            //那么此时 栈为空，前序为0 ； 栈不为空 则为栈顶
            if(stack1.isEmpty()){
                arr1[i] = (long) maxHeights.get(i) * (i + 1) ;
            }else{
                arr1[i] = arr1[stack1.peek()] + (long) maxHeights.get(i) * (i - stack1.peek()) ;
            }

            stack1.push(i);
        }

        //2.反向单调非减序列
        for (int i = n-1; i >= 0; i--) {

            while(!stack2.isEmpty() && maxHeights.get(i) < maxHeights.get(stack2.peek()) ){
                stack2.pop();
            }

            //此时栈为空或者 栈顶元素 >= get(i)
            //那么此时 栈为空，前序为0 ； 栈不为空 则为栈顶
            if(stack2.isEmpty()){
                arr2[i] = (long) maxHeights.get(i) * (n - i) ;
            }else{
                arr2[i] = arr2[stack2.peek()] + (long) maxHeights.get(i) * (stack2.peek() - i) ;
            }
            stack2.push(i);

            res = Math.max(res,arr1[i] + arr2[i] - maxHeights.get(i));
        }
        return res;
    }
}


