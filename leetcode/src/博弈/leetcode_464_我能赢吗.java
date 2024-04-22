package 博弈;

import java.util.HashSet;

/**
 * @ClassName leetcode_464_我能赢吗
 * @Author zxf
 * @Date 2024/3/15 15:08
 * @Questinon Describrition
 **/
public class leetcode_464_我能赢吗 {
    HashSet<Integer> set = new HashSet<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        for (int i = 1; i <= maxChoosableInteger; i++) {
            set.add(i);
        }


        return dfs(0,set,desiredTotal);

    }

    // 判断当前玩家是否稳赢
    private boolean dfs(int total , HashSet<Integer> set , int target ){
        for (Integer i : set) {
            //和大于target 则当前赢了
            if(total + i >= target){
                return true;
            }

            //
            HashSet<Integer> set2 = new HashSet<>(set);

            dfs(total+i,set2,target);
        }

        return false;
    }

    public static void main(String[] args) {
        leetcode_464_我能赢吗 v = new leetcode_464_我能赢吗();
        int max = 10;
        int a = 11;

        boolean b = v.canIWin(max, a);
        System.out.println(b);
    }
}
