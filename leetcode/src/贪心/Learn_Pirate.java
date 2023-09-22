package 贪心;

import java.util.Arrays;

public class Learn_Pirate {


    public static void main(String[] args) {
        int[] weights = new int[]{3,5,4,10,7,14,2,11};
        int capacity = 30;


        //每次取最小的
        Arrays.sort(weights);
        int weight = 0;
        int count = 0;

        for (int i = 0; i < weights.length; i++) {
            if(weight + weights[i] > capacity){
                break;
            }

            weight += weights[i];
            count++;
        }

        System.out.println("装了" + count + "件古董，总重量：" + weight);
    }
}
