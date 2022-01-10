package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class No119_杨辉三角2 {
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
        No119_杨辉三角2 v = new No119_杨辉三角2();
        List<Integer> res = v.getRow(3);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
