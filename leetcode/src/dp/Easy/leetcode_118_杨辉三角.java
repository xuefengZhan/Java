package dp.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_118_杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        Integer[][] dp = new Integer[numRows][];
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0;i < numRows;i++){
            Integer[] line = new Integer[i+1];
            for(int j = 0; j<i+1 ;j++){
                if(j==0 || j == i){
                    line[j] = 1;
                }else{
                    line[j] = dp[i-1][j-1]+dp[i-1][j];
                }
            }
            dp[i] = line;
            List<Integer> integers = new ArrayList<Integer>(Arrays.asList( line));
            res.add(integers);
        }
        return  res;
    }
}
