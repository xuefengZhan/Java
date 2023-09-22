package 贪心;

import java.util.Arrays;

/**
 *  不限硬币个数
 */
public class Learn_CoinChange {


    public static void main(String[] args) {
        int[] coins = new int[]{25,20,5,1};

        Arrays.sort(coins);
        int target = 41;


        //硬币个数最少，先选大的
        int money = 0;
        int count = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            if(money + coins[i] > target){
                continue;
            }
            money += coins[i];
            count++;
            //硬币不限个数 ，当前硬币可以使用，下次还用
            i++;
        }

        System.out.println(count);  //输出错误答案5
    }
}
