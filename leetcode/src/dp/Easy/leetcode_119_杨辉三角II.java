package dp.Easy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName leetcode_119_杨辉三角II
 * @Author zxf
 * @Date 2023/8/15 9:15
 * @Questinon Describrition
 **/
public class leetcode_119_杨辉三角II {
    public List<Integer> getRow(int rowIndex) {
        int[][] dp = new int[rowIndex + 1][];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[i + 1];

            for (int j = 0; j < dp[i].length; j++) {
                if(j == 0 || j == dp[i].length - 1){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i : dp[rowIndex]) {
            res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        leetcode_119_杨辉三角II v = new leetcode_119_杨辉三角II();
        List<Integer> res = v.getRow(3);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
