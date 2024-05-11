package dp.No02_网格图dp;

import java.util.List;

/**
 * @ClassName leetcode_1301_最大得分的路径数目
 * @Author zxf
 * @Date 2024/5/8 19:16
 * @Questinon Describrition
 **/
public class leetcode_1301_最大得分的路径数目 {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int mod = 1000000007;

        char[][] martix = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = board.get(i);
            martix[i] = s.toCharArray();
        }

        long[][] dp1 = new long[n][n];
        long[][] dp2 = new long[n][n];

        for (int i = 0; i < n; i++) {

            System.out.println("========== i = " + i + " ==========");
            for (int j = 0; j < n; j++) {

                if(i == 0 && j == 0){
                    dp2[0][0] = 1;
                    continue;
                }
                System.out.println("==== j = " + j + " ===");

                //左上角是否可用
                boolean a = i > 0 && j> 0 && martix[i-1][j-1] !='X';
                //上是否可用
                boolean b = i > 0 && 'X' != martix[i-1][j];
                //左是否可用
                boolean c = j > 0 && 'X' != martix[i][j-1];

                if(!a && !b && !c){
                    martix[i][j] = 'X';
                    continue;
                }


                long va = a? dp1[i-1][j-1] : 0;
                long pa = a? dp2[i-1][j-1] : 0;

                long vb = b? dp1[i-1][j] : 0;
                long pb = b? dp2[i-1][j] : 0;

                long vc = c? dp1[i][j-1] : 0;
                long pc = c? dp2[i][j-1] : 0;


                long maxV = Math.max(Math.max(va,vb),vc);
                long paths = 0;

                if(maxV == va){
                    paths += pa;
                }
                if(maxV == vb){
                    paths += pb;
                }
                if(maxV == vc){
                    paths += pc;
                }

                int cur;
                if(martix[i][j] == 'E' || martix[i][j] == 'S'){
                    cur = 0;
                }else{
                    cur = martix[i][j] - '0';
                }

                System.out.println("cur = " + cur);

                dp1[i][j] = (maxV +  cur) % mod;
                dp2[i][j] = paths % mod ;


                System.out.println(dp1[i][j] + "," + dp2[i][j]);
            }
        }


        int n1 = (int) (dp1[n-1][n-1] % mod);
        int n2 = (int) (dp2[n-1][n-1] % mod);

        return new int[]{n1,n2};
    }
}
