package 排序;

import java.util.ArrayList;
import java.util.Arrays;

public class NC119_最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList();
        if(k==0 || input == null) return res;

        Sort(input);


        for(int i = 0;i<k;i++){
            res.add(input[i]);
        }

        return res;

    }

    private void Sort(int[] arr){
        Sort(arr,0,arr.length-1);
    }

    private void Sort(int[] arr,int start,int end){

        if(start >= end) return;

        int mid = getPoint(arr,start,end);
        Sort(arr,start,mid-1);
        Sort(arr,mid+1,end);
    }


    private int getPoint(int[] arr,int start,int end){
        int pivot = arr[start];

        int left = start + 1;
        int right = end;


        System.out.println("pivot==" + pivot);
        while(left <= right){
            if(arr[left] <= pivot){
                left++;
            }else if(arr[right] > pivot){
                //arr[left] > pivot
                right--;
            }else{
                //arr[left] > pivot && arr[right] <= pivot
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
            System.out.println(Arrays.toString(arr));
        }
        //left = right + 1   arr[left] > pivot   arr[right] <= pivot

        // 将pivot放到中间位置
        int tmp = arr[right];
        arr[right] = pivot;
        arr[start] = tmp;
        System.out.println(Arrays.toString(arr));
        return right;

    }


    public static void main(String[] args) {
        NC119_最小的K个数 v = new NC119_最小的K个数();
        int[] input = {0,1,1,1,4,5,3,7,7,8,10,2,7,8,0,5,2,16,12,1,19,15,5,18,2,2,22,15,8,22,17,6,22,6,22,26,32,8,10,11,2,26,9,12,9,7,28,33,20,7,2,17,44,3,52,27,2,23,19,56,56,58,36,31,1,19,19,6,65,49,27,63,29,1,69,47,56,61,40,43,10,71,60,66,42,44,10,12,83,69,73,2,65,93,92,47,35,39,13,75};
        int k = 75;

        ArrayList<Integer> integers = v.GetLeastNumbers_Solution(input, k);
        System.out.println(integers);


//        System.out.println(v.getPoint(new int[]{5,6,7,8,9},0,4));
    }
}
