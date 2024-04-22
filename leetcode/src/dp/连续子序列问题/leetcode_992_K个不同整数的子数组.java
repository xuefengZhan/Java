package dp.连续子序列问题;

/**
 * @ClassName leetcode_992_K个不同整数的子数组
 * @Author zxf
 * @Date 2024/3/20 10:25
 * @Questinon Describrition
 **/
public class leetcode_992_K个不同整数的子数组 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return mostK(nums,k) - mostK(nums,k-1);
    }


    private int mostK(int[] nums,int k){
        int res = 0;

        int n = nums.length;

        int[] visited = new int[n+1];

        int prevIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果这个数字当前没有记录
            if(visited[nums[i]] == 0){
                k--;
            }

            visited[nums[i]] ++ ;

            //如果k<0了，说明以当前元素作为尾部的子序列的整数个数超过k个了
            //假设序列是 1 1 2 1 1 3 ; 则要删到2
            //如何判断要删除到2 当k = 0的时候就好

            while(k<0){
                int prev = nums[prevIndex];

                //删除后为0了 说明当前元素已经完全删除了
                if(--visited[prev] == 0){
                    k++;
                }

                prevIndex++;
            }

            res += i - prevIndex + 1;

        }

        return res;
    }
}
