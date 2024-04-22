package 单调栈;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName leetcode_1504_统计全1子矩形
 * @Author zxf
 * @Date 2024/2/27 17:31
 * @Questinon Describrition
 **/
public class leetcode_1504_统计全1子矩形 {
    public int numSubmat(int[][] mat) {
        for (int i = 1; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] != 0){
                    mat[i][j] += mat[i-1][j] ;
                }
            }
        }

        System.out.println(Arrays.deepToString(mat));

        int res = 0;

        for (int i = 0; i < mat.length; i++) {

            int[] cnt = new int[mat[0].length]; // 用于存储每个位置的矩形数

            // 单调递增栈
            LinkedList<Integer> stack = new LinkedList<>();
            stack.push(-1);

            for (int j = 0; j < mat[i].length; j++) {
                while( stack.peek() != -1 && mat[i][stack.peek()] >= mat[i][j]){
                    stack.pop();
                }

                //此时栈为空 或者 栈顶 <= mat[i][j]

                //part1. j - p 范围内 h * (j-p)
                int a = mat[i][j] * (j - stack.peek());
                //part2. j - p 范围外 cnt[i][p];
                int b = stack.peek() == -1 ? 0 : cnt[stack.peek()];

                System.out.println("i == " + i);
                System.out.println("j == " + j);
                System.out.println("a == " + a + " b == " + b);

                cnt[j] = a+b;
                res += cnt[j];

                stack.push(j);
            }
        }

        return res;
    }
}
