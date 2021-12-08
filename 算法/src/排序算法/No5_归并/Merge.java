package 排序算法.No5_归并;

import 排序算法.No3_选择.Select;

import java.util.Arrays;

public class Merge {

    public static void sort(int[] arr){
        mergeSort(arr,0,arr.length-1);
    }

    private static void  mergeSort(int[] arr,int low,int high){


        if(low == high) return;

        int mid = (low + high) >> 1;

        mergeSort(arr,low,mid);
        mergeSort(arr,mid + 1,high);

        merge(arr,low,mid,high);
    }


    private static void merge(int[] arr,int low,int mid,int high){
        int[] leftArr = new int[mid - low + 1];
        for(int i = low;i<= mid;i++){
            leftArr[i - low] = arr[i];
        }

        int left = 0;
        int right = mid + 1;

        for (int i = low; i <= high; i++) {
            if((left < leftArr.length && right <= high && leftArr[left] < arr[right]) || right > high){
                arr[i] = leftArr[left];
                left ++;
            }else{
                arr[i] = arr[right];
                right++;
            }
        }

    }


    public static void main(String[] args) {
        int[] arr =  new int[40];

        //[0,100)
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }


        Merge.sort(arr);
        System.out.println(Arrays.toString(arr));
        //System.out.println(Arrays.toString(Arrays.copyOf(arr, 3)));
    }
}
