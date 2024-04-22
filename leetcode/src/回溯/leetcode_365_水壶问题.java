package 回溯;

import java.util.ArrayList;

/**
 * @ClassName leetcode_365_水壶问题
 * @Author zxf
 * @Date 2024/3/26 16:41
 * @Questinon Describrition
 **/
public class leetcode_365_水壶问题 {

    boolean res;

    int[][] visited;

    public boolean canMeasureWater(int x, int y, int target) {
        visited = new int[x+1][y+1];

        visited[0][0] = 1;

        dfs(x,y,0,0,target);
        return res;
    }

    private void dfs(int x,int y,int a,int b,int target){
        if(a + b == target){
            res = true;
            return;
        }


        int[][] nextPoints = {
                              {0,b},{a,0},       //清空
                              {x,b},{a,y},       //加满
                              {x,b-x+a},{a+b,0}, //b往a倒入
                              {0,b+a},{a-y+b,y}  //a往b倒入
                              };

        for (int[] p : nextPoints) {
            if(p[0] < 0 || p[0] > x) continue;
            if(p[1] < 0 || p[1] > y) continue;

            if(visited[p[0]][p[1]] == 1) continue;

            visited[p[0]][p[1]] = 1;

            dfs(x,y,p[0],p[1],target);

            visited[p[0]][p[1]] = 0;
        }

    }
}
