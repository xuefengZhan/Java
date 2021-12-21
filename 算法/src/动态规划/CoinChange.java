package 动态规划;

public class CoinChange {


    //todo 1.暴力递归
    public int coins(int n){
        if(n < 1) return Integer.MAX_VALUE;
        if(n == 25 || n == 20 || n == 5 || n ==1){
            return 1;
        }
        int min1 = Math.min(coins(n-25),coins(n-20))  ;
        int min2 = Math.min(coins(n-5),coins(n-1))  ;

        return Math.min(min1,min2) + 1;

    }

    //todo 2.记忆化搜索
    public int coins2(int n){
        if(n < 1) return Integer.MAX_VALUE;

        //todo step1. 声明一个dp数组，dp[i]表示i枚硬币所需最小硬币数
        int[] dp = new int[n+1];

        //todo step2. 初始化dp数组：对于已有面值的 只需要1枚硬币
        int[] faces = { 1, 5, 20, 25 };

        for (int face : faces) {
            if (face > n) break; //用不到的面值不用初始化
            dp[face] = 1;
        }

        return coins2(n,dp);
    }

    private int coins2(int n ,int[] dp){
        // 递归基
        if (n < 1) return Integer.MAX_VALUE;

        if (dp[n] == 0) { // 记忆化搜索, dp[n] == 0 表示以前没有算过, 那便初始化一下
            int min1 = Math.min(coins2(n - 5, dp), coins2(n - 1, dp));
            int min2 = Math.min(coins2(n - 25, dp), coins2(n - 20, dp));
            dp[n] = Math.min(min1, min2) + 1;
        }
        return dp[n];
    }


    //todo 3.递推 自底向上
    static int coins3(int n) {
        if (n < 1) return -1; // 处理非法数据
        int[] dp = new int[n + 1];

        // 自底向上的递推
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            if (i >= 1) min = Math.min(min, dp[i - 1]); //dp[1] = dp[0] + 1 = 1;
            if (i >= 5) min = Math.min(min, dp[i - 5]); //dp[5] = dp[0] + 1 = 1;
            if (i >= 20) min = Math.min(min, dp[i - 20]);//dp[20] = dp[0] + 1 = 1;
            if (i >= 25) min = Math.min(min, dp[i - 25]);//dp[25] = dp[0] + 1 = 1;
            dp[i] = min + 1;
        }
        return dp[n];
    }



    public static void main(String[] args) {
        System.out.println(new CoinChange().coins3(41));
    }
}
