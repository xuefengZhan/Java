package 排序算法.No1_冒泡;


import java.util.Arrays;

public class Bubble {
    private  static void swap(int[] arr,int i,int j ){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void sort(int[] arr){
        //end 存放当前轮最大值  最后一轮只有0和1  因此 end 为 1
        for(int end = arr.length-1;end>0;end--){
            // 索引从0到end - 1
            for(int i = 0;i<end;i++){
                if(arr[i] > arr[i + 1]){
                    swap(arr,i,i+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,5,2,8,1,34,25};
        sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
