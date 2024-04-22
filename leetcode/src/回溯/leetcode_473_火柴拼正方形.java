package 回溯;

import java.util.Arrays;

/**
 * @ClassName leetcode_473_火柴拼正方形
 * @Author zxf
 * @Date 2024/3/22 16:26
 * @Questinon Describrition
 **/
public class leetcode_473_火柴拼正方形 {
    int edge;

    int[] square = new int[4]; // 存储正方形的四条边
    public boolean makesquare(int[] matchsticks) {
        for (int matchstick : matchsticks) {
            edge+=matchstick;
        }

        if(edge % 4 != 0) return false;
        edge = edge / 4;

        Arrays.sort(matchsticks);
        if(matchsticks[matchsticks.length - 1] > edge) return false;

        return dfs(matchsticks, matchsticks.length - 1);
    }


    private boolean dfs(int[] chooses,int index) {
        if (index == -1) return true;

        //给当前火柴选边
        for (int j = 0; j < 4; j++) {
            if(square[j] + chooses[index] > edge) continue;

            square[j] += chooses[index];
            if(dfs(chooses, index - 1)) return true;
            square[j] -= chooses[index];
        }
        return false;
    }

    public static void main(String[] args) {
        leetcode_473_火柴拼正方形 v = new leetcode_473_火柴拼正方形();
        int[] arr = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,102};

        boolean makesquare = v.makesquare(arr);

        System.out.println(makesquare);
    }


}
