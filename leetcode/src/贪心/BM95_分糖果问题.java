package 贪心;

import java.util.Arrays;

/**
 * https://www.nowcoder.com/practice/76039109dd0b47e994c08d8319faa352?tpId=295&tqId=1008104&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
 */
public class BM95_分糖果问题 {

    public int candy (int[] arr) {
        // write code here

        if(arr == null || arr.length == 0) return 0;
        if(arr.length == 1) return 1;

        int[] tmp = new int[arr.length];
        tmp[0] = 1;

        int res = 0;


        for (int i = 1; i < arr.length; i++) {

            tmp[i] = 1;

            if(arr[i] > arr[i-1]){
                tmp[i] = tmp[i-1] + 1;
            } else if(arr[i] == arr[i-1]){
                tmp[i] = 1;
            } else{ //arr[i] < arr[i-1]
                int j = i - 1;
                while(j >= 0){
                    if(arr[j] > arr[j+1]){
                        tmp[j] = tmp[j] = Math.max(tmp[j+1] + 1,tmp[j]);;
                        j--;
                    }else{
                        break;
                    }
                }
            }
        }

        for(int t : tmp){
            res += t;
        }

        //System.out.println(Arrays.toString(tmp));
        return res;
    }

    /**
     *  100%
     */

}
