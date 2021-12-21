package 排序算法.No6_快速;

import 排序算法.No5_归并.Merge;

import java.util.Arrays;

public class Quick {

    public static void sort(int[] arr){

        quickSort(arr,0,arr.length-1);

    }


    private static void quickSort(int[] arr,int low,int high){

        if(low >= high) return;

        int mid = findIndex(arr,low,high);
        quickSort(arr,low,mid-1); //注意：中间的元素不再参与排序！
        quickSort(arr,mid+1,high);
    }


    private static int findIndex(int[] arr,int low,int high){
        if(low == high) return low;

        int pivot = arr[low];
        int left = low + 1;
        int right = high;


       while(left <= right){
           if(arr[left] <= pivot){
               left ++;
           }
           //到这里 arr[left] > pivot
           else if(arr[right] > pivot){
               right --;
           }
           //到这里 arr[left] > pivot && arr[right] <= pivot
           else{
               int tmp = arr[left];
               arr[left] = arr[right];
               arr[right] = tmp;

              // arr[left] <= pivot && arr[right] > pivot

           }
       }

       //left > right
        int tmp = arr[right];
        arr[right] = pivot;
        arr[low] = tmp;

        return right;

    }



    public static void main(String[] args) {
        int[] arr =  new int[40];

        //[0,100)
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(arr));
        int index = findIndex(arr, 0, arr.length - 1);
        System.out.println(index);

        Quick.sort(arr);
        System.out.println(Arrays.toString(arr));





    }
}
