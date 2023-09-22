package dp;

/**
 * @ClassName leetcode_96_不同的二叉搜索树
 * @Author zxf
 * @Date 2023/1/13 16:29
 *
 * 100%
 **/
public class leetcode_96_不同的二叉搜索树 {
    public int numTrees(int n) {
        int[] dp = new int[n+1];

        dp[1] = 1;


        //总结点个数
        for(int i = 1;i<=n;i++){
            //左边节点个数
            for(int l = 0;l< i;l++){
                int left = dp[l];
                int right = dp[i-l-1];

                if(l == 0 || l == i-1){
                    dp[i] += dp[i-1];
                }else{
                    dp[i] += left * right;
                }
            }
        }
        return dp[n];
    }
}
