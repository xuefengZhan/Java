package 数组;


import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/submissions/
 *
 * 100%
 */

public class 剑指Offer29_顺时针打印矩阵 {


   int[] res;
   int size;

    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[]{};

        res = new int[matrix.length * matrix[0].length];

        dfs(matrix,0);

        return res ;
    }

    private void dfs(int[][] matrix,int level){
        if(size >= matrix.length * matrix[0].length) return;

        int rowStart = level;
        int rowEnd = matrix[0].length - 1 - level;

        int colStart = level;
        int colEnd = matrix.length - 1 - colStart;

        int[] row1 = matrix[rowStart];
        for(int j = rowStart;j<=rowEnd;j++){
            res[size++] = row1[j];
        }

        for(int i = colStart + 1; i <= colEnd;i++){
            res[size++] = matrix[i][rowEnd];
        }

        if(colEnd != colStart){
            for(int j = rowEnd - 1;j>= rowStart;j--){
                res[size++] = matrix[colEnd][j];
            }
        }

      if(rowStart != rowEnd){
          for(int i = colEnd - 1;i>colStart;i--){
              res[size++] = matrix[i][rowStart];
          }
      }

      dfs(matrix,level+1);
    }

    public static void main(String[] args) {
        剑指Offer29_顺时针打印矩阵 v = new 剑指Offer29_顺时针打印矩阵();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        int[] ints = v.spiralOrder(matrix);

        System.out.println(Arrays.toString(ints));
    }
}
