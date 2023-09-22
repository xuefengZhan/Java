package dp.Mid;

/**
 * @ClassName leetcode_96_不同的二叉搜索树
 * @Author zxf
 * @Date 2023/8/25 9:48
 * @Questinon Describrition
 **/
public class leetcode_96_不同的二叉搜索树 {
    public int numTrees(int n) {

        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        //i是节点个数
        for (int i = 2; i <= n; i++) {
            //j是左子树节点个数
            for(int j = 0;j<i;j++){
                if(j == 0 || j == i - 1){
                    dp[i] += dp[i-1];
                }else{
                    dp[i] += dp[j] * dp[i - j - 1]; //i - j - 1 右子树个数
                }
            }
        }

        return dp[n];
    }
}
