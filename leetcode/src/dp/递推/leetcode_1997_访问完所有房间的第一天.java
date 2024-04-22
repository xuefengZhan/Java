package dp.递推;

/**
 * @ClassName leetcode_1997_访问完所有房间的第一天
 * @Author zxf
 * @Date 2024/3/28 11:23
 * @Questinon Describrition
 **/
public class leetcode_1997_访问完所有房间的第一天 {


    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        int[] dp = new int[n]; //到达i-1号房间的天数

        int mod = 1000000007;

        for (int i = 1; i < n; i++) {
            //第一次到i-1 : f[i-1]
            //i-1 到 next[i-1] :  1
            //next[i-1] 到 i - 1 : f[i-1] - f[next[i-1]]   因为又是从奇数开始  所以等于又重来了一次
            //i-1 到 i : 1
            dp[i] = (dp[i-1] * 2 - dp[nextVisit[i-1]] + 2 + mod) % mod;
        }

        return dp[n-1];
    }
}
