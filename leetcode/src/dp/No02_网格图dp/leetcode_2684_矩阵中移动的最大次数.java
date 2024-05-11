package dp.No02_网格图dp;

/**
 * @ClassName leetcode_2684_矩阵中移动的最大次数
 * @Author zxf
 * @Date 2024/5/6 16:12
 * @Questinon Describrition
 **/
public class leetcode_2684_矩阵中移动的最大次数 {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp1 = new int[m];
        int[] dp2 = new int[m];

        int res = 0;

        //i是列
        for (int i = 1; i < n; i++) {
            //System.out.println("============" + i + "============" );
            //j是行
            for (int j = 0; j < m; j++) {

                //System.out.println("=====" + j + "=====");
                int cur = grid[j][i];

                //System.out.println("cur " + cur);
                int tmp = 0;
                int flag = 0;

                if(j > 0 && grid[j-1][i-1] < cur){
                    //System.out.println("dp2[j-1] " + dp2[j-1]);
                    tmp = Math.max(tmp,dp2[j-1]);
                    flag = 1;
                }

                if(grid[j][i-1] < cur){
                    //System.out.println("dp2[j] " + dp2[j]);
                    tmp = Math.max(tmp,dp2[j]);
                    flag = 1;
                }

                if(j < m - 1 && grid[j+1][i-1] < cur){
                    //System.out.println("dp2[j+1] " + dp2[j+1]);
                    tmp = Math.max(tmp,dp2[j+1]);
                    flag = 1;
                }

                //System.out.println("tmp == " + tmp);
                //tmp = 0
                // flag = 1 说明比前面的大
                if(flag == 1){
                    //如果tmp = 0
                    if(tmp == 0 && i > 1){
                        dp1[j] = 0;
                    }else{
                        dp1[j] = tmp + 1;
                    }
                }else{
                    //没有比前面大
                    dp1[j] = 0;
                }

                //System.out.println(dp1[j]);

                res = Math.max(res,dp1[j]);
            }
            //
            dp2 = dp1;
            dp1 = new int[m];
            //System.out.println(Arrays.toString(dp2));
        }

        return res;
    }


}
