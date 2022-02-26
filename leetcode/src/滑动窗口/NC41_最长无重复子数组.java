package 滑动窗口;

import java.util.HashMap;

public class NC41_最长无重复子数组 {
    public int maxLength (int[] arr) {

        if(arr==  null || arr.length == 0) return 0;

        // write code here
        HashMap<Integer, Integer> valueIndex = new HashMap<Integer, Integer>();

        int left = 0;
        int right = 0;

        valueIndex.put(arr[right],right);
        int res = 1;

        while(right < arr.length - 1){

            right ++;
            if(!valueIndex.containsKey(arr[right])){
                valueIndex.put(arr[right],right);
            }else{
                // 如果包含了
                res = Math.max(res,valueIndex.size());

                // 获取重复元素的位置
                Integer duplicateElementIndex = valueIndex.get(arr[right]);
                // hashMap中移除到重复位置的所有元素
                for(int i = left;i<=duplicateElementIndex;i++){
                    valueIndex.remove(arr[i]);
                }
                // left 移动重复元素的右边一位
                left = duplicateElementIndex+1;
                // 更新right
                valueIndex.put(arr[right],right);
            }
        }
        res = Math.max(res,valueIndex.size());
        return res;
    }


    public static void main(String[] args) {
        NC41_最长无重复子数组 v = new NC41_最长无重复子数组();
        int[] arr = {2,2,3,4,8,99,3};
        int i = v.maxLength(arr);
        System.out.println(i);
    }
}
