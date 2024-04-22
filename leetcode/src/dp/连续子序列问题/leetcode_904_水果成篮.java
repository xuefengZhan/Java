package dp.连续子序列问题;

import java.util.Arrays;

/**
 * @ClassName leetcode_904_水果成篮
 * @Author zxf
 * @Date 2024/3/19 16:11
 * @Questinon Describrition
 *
 * 题意：最长只包含两个元素的子串
 **/
public class leetcode_904_水果成篮 {



    public int totalFruit(int[] fruits) {
        int n = fruits.length;

        int[] a = new int[n]; // 存储i结尾的单个水果连续长度
        int[] dp = new int[n]; //存储i结尾的只有两个元素的长度
        int f1;
        int f2 = -1;

        a[0] = 1;
        dp[0] = 1;
        int res = 1;

        f1 = fruits[0];
        for (int i = 1; i < fruits.length; i++) {
            //如果水果和之前一样
            if(fruits[i] == fruits[i-1]){
                a[i] = a[i-1] + 1;
                dp[i] = dp[i-1] + 1;
            }else{
                //水果和之前不一样
                a[i] = 1;

                //如果第二种水果不存在
                if(f2 == -1){
                    f2 = fruits[i];
                    dp[i] = dp[i-1] + 1;
                }else if(fruits[i] != f1){
                    //第二种存在 但是第一种不一样 （第三种水果）
                    dp[i] = a[i-1] + 1;
                    f1 = f2;
                    f2 = fruits[i];
                }else{
                    //第二种存在 和第一种一样
                    dp[i] = dp[i-1] + 1;
                    f1 = f2;
                    f2 = fruits[i];
                }
            }
            res = Math.max(dp[i],res);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }


    //k是水果个数
    public int totalFruit2(int[] fruits,int k) {
        int res = 0;
        int index = 0;

        int n = fruits.length;

        int[] win = new int[n]; //存储水果个数

        for (int i = 0; i < n; i++) {
            // 当前水果个数为0 则表示这是新的水果 还能收k-1种水果
            if(win[fruits[i]] == 0){
                k--;
            }

            // 当前水果个数+1
            win[fruits[i]] += 1;

            // 如果k < 0 了 . 表示当前水果是第k+1种 超了 需要将序列的第一个从果篮中删了
            while(k < 0){
                win[fruits[i]] --;

                if(win[fruits[i]] == 0){
                    k++;
                }

                i++;
            }

            res = Math.max(res,i - index + 1);
        }

        return res;


    }
}
