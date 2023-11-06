package dp.路径问题;

/**
 * @ClassName leetcode_1289_下降路径最小和II
 * @Author zxf
 * @Date 2023/8/10 13:41
 *
 **/
public class leetcode_1289_下降路径最小和II_v2 {
    public int minFallingPathSum(int[][] grid) {

        int n = grid.length;

        //上一层
        int minIndex = -1;
        int minValue = 0;
        int secondMinValue = 0;


        //层
        for (int i = 0; i < n; i++) {

            //当前层
            int cur_minIndex = -1;
            int cur_minValue = Integer.MAX_VALUE;
            int cur_second_minValue = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
               int cur_sum  = j == minIndex?  secondMinValue + grid[i][j]  :  minValue + grid[i][j] ;

               if(cur_sum < cur_minValue){
                   cur_second_minValue = cur_minValue;
                   cur_minValue = cur_sum;
                   cur_minIndex = j;
               }else if(cur_sum < cur_second_minValue){
                   cur_second_minValue = cur_sum;
               }
            }

            minIndex = cur_minIndex;
            minValue = cur_minValue;
            secondMinValue = cur_second_minValue;
        }

        return minValue;
    }
}
