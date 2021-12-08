package 排序算法.No3_选择;

import 排序算法.No2_插入.Insert;

import java.util.Arrays;

public class Select {
    private  static void swap(int[] arr,int i,int j ){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void sort(int[] arr){
        for(int end = arr.length - 1;end > 0;end--){
            int maxIndex = 0;
            for(int i = 0;i <= end;i++){
                if(arr[i] > arr[maxIndex]){
                    maxIndex = i;
                }
            }
            swap(arr,maxIndex,end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,5,2,8,1,34,25};
        Select.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
