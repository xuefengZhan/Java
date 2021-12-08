package 排序算法.No2_插入;

import java.util.Arrays;

public class Insert {

    private  static void swap(int[] arr,int i,int j ){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void sort(int[] arr){
         for(int start = 1;start  < arr.length;start++){
             for(int i = start;i>0;i--){
                 if(arr[i] < arr[i-1]){
                     swap(arr,i,i-1);
                 }
             }
         }
    }

    public static void main(String[] args) {
        int[] arr = {3,5,2,8,1,34,25};
        Insert.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
