package 单调栈;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName leetcode_2104_子数组范围和
 * @Author zxf
 * @Date 2024/2/22 16:10
 * @Questinon Describrition
 **/
public class leetcode_2104_子数组范围和 {

//    public long subArrayRanges(int[] nums) {
//        int n = nums.length;
//
//        int[] lmin = new int[n];
//        int[] rmin = new int[n];
//        int[] lmax = new int[n];
//        int[] rmax = new int[n];
//
//        LinkedList<Integer> stack = new LinkedList<>();
//
//
//        //求左边更小的值 => 从右往左遍历，维护单调递增栈，遇到小于等于栈顶的，出栈
//        //左边的元素和当前元素相等时，左边元素当做区间最小值
//        stack.push(n-1);
//
//        for (int i = n-2; i >= 0; i--) {
//            while(!stack.isEmpty() && nums[i] <= nums[stack.peek()]){
//                lmin[stack.pop()] = i;
//            }
//            stack.push(i);
//        }
//
//        while(!stack.isEmpty()){
//            lmin[stack.pop()] = -1;
//        }
//
//        // 求左边更大的值=> 从右往左遍历，维护单调递减栈，遇到大于栈顶的，出栈
//        stack = new LinkedList<>();
//
//        stack.push(n-1);
//        for (int i = n-2; i >= 0; i--) {
//            while(!stack.isEmpty() && nums[i] >  nums[stack.peek()]){
//                lmax[stack.pop()] = i;
//            }
//            stack.push(i);
//        }
//
//        while(!stack.isEmpty()){
//            lmax[stack.pop()] = -1;
//        }
//
//        // 求右边更小的值
//        stack = new LinkedList<>();
//
//        stack.push(0);
//        for (int i = 1; i < n; i++) {
//            while(!stack.isEmpty() && nums[i] < nums[stack.peek()]){
//                rmin[stack.pop()] = i;
//            }
//            stack.push(i);
//        }
//
//        while(!stack.isEmpty()){
//            rmin[stack.pop()] = n;
//        }
//
//
//        // 求右边更大值
//        stack = new LinkedList<>();
//
//        stack.push(0);
//        for (int i = 1; i < n; i++) {
//            while(!stack.isEmpty() && nums[i] >= nums[stack.peek()]){
//                rmax[stack.pop()] = i;
//            }
//            stack.push(i);
//        }
//
//        while(!stack.isEmpty()){
//            rmax[stack.pop()] = n;
//        }
//
//        // System.out.println(Arrays.toString(lmin));
//        // System.out.println(Arrays.toString(lmax));
//        // System.out.println(Arrays.toString(rmin));
//        // System.out.println(Arrays.toString(rmax));
//
//        long  ans = 0;
//        for (int i = 0; i < n; i++) {
//            ans += (long) nums[i] * (i - lmax[i]) * (rmax[i] - i);
//            ans -= (long) nums[i] * (i - lmin[i]) * (rmin[i] - i);
//        }
//
//        return ans;
//    }


    //这种写法更巧妙，知道当前元素的结果的时候入栈，栈中都是已知结果的
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        int[] lsmall = new int[n];
        int[] rsmall = new int[n];
        int[] llarge = new int[n];
        int[] rlarge = new int[n];


        LinkedList<Integer> s = new LinkedList<>();


        // 从左往右单调增栈 不能出栈的时候栈顶就是当前元素左侧最近的小于当前元素的节点
        s.push(-1);
        for (int i = 0; i < n; i++) {
            while (s.peek() != -1 && nums[s.peek()] >= nums[i]) {
                s.pop();
            }
            lsmall[i] = s.peek();
            s.push(i);
        }

        // 从右往左单调增栈 不能出栈的时候栈顶就是当前元素右侧最近的小于当前元素的节点
        s = new LinkedList<>();
        s.push(n);
        for (int i = n - 1; i >= 0; i--) {
            while (s.peek() != n && nums[s.peek()] > nums[i]) {
                s.pop();
            }
            rsmall[i] = s.peek();
            s.push(i);
        }

        // 从左往右单调减栈 不能出栈的时候栈顶就是当前元素左侧最近的大于当前元素的节点
        s = new LinkedList<>();
        s.push(-1);
        for (int i = 0; i < n; i++) {
            while (s.peek() != -1 && nums[s.peek()] <= nums[i]) {
                s.pop();
            }
            llarge[i] = s.peek();
            s.push(i);
        }

        // 从右往左单调增栈 不能出栈的时候栈顶就是当前元素右侧最近的大于当前元素的节点
        s = new LinkedList<>();
        s.push(n);
        for (int i = n - 1; i >= 0; i--) {
            while (s.peek() != n && nums[s.peek()] < nums[i]) {
                s.pop();
            }
            rlarge[i] = s.peek();
            s.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) nums[i] * (i - llarge[i]) * (rlarge[i] - i);
            ans -= (long) nums[i] * (i - lsmall[i]) * (rsmall[i] - i);
        }
        System.out.println(Arrays.toString(lsmall));
        System.out.println(Arrays.toString(llarge));
        System.out.println(Arrays.toString(rsmall));
        System.out.println(Arrays.toString(rlarge));
        return ans;
    }







    public static void main(String[] args) {
        int[] nums = {1,3,3};
        leetcode_2104_子数组范围和 v = new leetcode_2104_子数组范围和();
        long res = v.subArrayRanges(nums);

        System.out.println(res);
    }
}
