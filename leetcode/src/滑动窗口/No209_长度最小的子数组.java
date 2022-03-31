package 滑动窗口;

/**
 *  滑动窗口 最短模板典型
 */
public class No209_长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        // todo 1.初始化窗口  窗口大小为0
        int left = 0;
        int right = 0;
        int windowSum = 0;


        int res =  Integer.MAX_VALUE;


        //todo 2. 当右指针没有到结尾
        while(right < nums.length){
            //todo 3.加入right对应的元素，窗口扩大
            windowSum += nums[right];
            //todo 4.当窗口满足条件，移除left元素，left右移 缩小窗口
            if(windowSum >= target){
                while(windowSum >= target){
                    windowSum -= nums[left++];
                }
                //todo 5.窗口缩小后是不满足条件的大小
                // [left,right] 中windSum < target，right -left + 1是窗口大小
                res = Math.min(res,right - left + 2);
            }

            //todo 6.经过第四步后，进入下一个循环的 窗口肯定是不满足条件的，因此right++ 回到
            //第三步 扩大窗口
            right++;
        }

        return res == Integer.MAX_VALUE? 0 : res;
    }

    public static void main(String[] args) {
        No209_长度最小的子数组 v = new No209_长度最小的子数组();
        int target = 7;
        int[] nums = {2,3,1,2,4,3};

        int res = v.minSubArrayLen(7, nums);
        System.out.println(res);
    }

}
