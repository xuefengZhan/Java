package dp.背包问题.完全背包;

import java.util.Arrays;

import java.util.Objects;

/**
 * @ClassName leetcode_1449_数位成本和为目标值的最大数字
 * @Author zxf
 * @Date 2024/4/12 9:28
 * @Questinon Describrition
 **/
public class leetcode_1449_数位成本和为目标值的最大数字 {
    public String largestNumber(int[] cost, int target) {

        String[] dp = new String[target+1];

        Arrays.fill(dp,"-1");
        dp[0] = "";

        Comparator comparator = new Comparator();

        /**
         *  这里必须先target 后选项
         *  也就是211 和112是不同的，组合的最大值
         */
        //i是选择的数字 可选1-9
        for (int j = 1; j <= target; j++) {
            for (int i = 1; i <= 9; i++) {
                int cur = cost[i-1]; //cur是花销
                System.out.println(cur + " (" + i +") : ");

                if(j >= cur && !Objects.equals(dp[j - cur], "-1")){
                    String tmp = dp[j-cur]  + i;
                    if(comparator.compare(dp[j],tmp) < 0){
                        dp[j] = tmp;
                    }
                }
            }
        }


        return dp[target];
    }

    private class Comparator implements java.util.Comparator<String>{

        @Override
        public int compare(String o1, String o2) {

            if(Objects.equals(o1, "-1")) return -1;
            if(Objects.equals(o2, "-1")) return 1;


            if(o1.length() == o2.length()){
                for (int i = 0; i < o1.length(); i++) {
                    if(o1.charAt(i) > o2.charAt(i)){
                        return 1;
                    }else if(o1.charAt(i) < o2.charAt(i)){
                        return -1;
                    }
                }
                return 0;
            }else{
                return o1.length() < o2.length() ? -1 : 1;
            }
        }
    }

    public static void main(String[] args) {
        leetcode_1449_数位成本和为目标值的最大数字 v = new leetcode_1449_数位成本和为目标值的最大数字();
        int[] cost = {1,1,1,1,1,1,1,3,2};
        int target = 10;

        String s = v.largestNumber(cost, target);
        System.out.println(s);
    }
}
