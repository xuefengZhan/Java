package 排序;

import java.util.Arrays;

public class QuickSort2 {


    public int[] sort(int[] arr){
        sort(arr,0,arr.length-1);
        return arr;
    }

    //让arr在[low,high]范围内分成两部分，前面一部分都比后面一部分小
    private void sort(int[] arr,int low,int high){
        if(high <= low) return;
        int mid = pivotIndex(arr,low,high);
        sort(arr,low,mid-1);
        sort(arr,mid+1,high);
    }

    private int pivotIndex(int[] array,int begin, int end){
        // 备份begin位置的元素
        //int start = begin;
        int pivot = array[begin];
        // end指向最后一个元素
        System.out.println("        prev        "+Arrays.toString(array));
        begin++;
        while(begin < end){
            while(begin < end){	// 从右往左扫描
                if( pivot <= array[end] ){ // 右边元素 > 轴点元素
                    end--;
                }else{
                    break;
                }
            }
            //array[end] < pivot
            while(begin < end){ // 从左往右扫描
                if( pivot >=  array[begin]){ // 左边元素 < 轴点元素
                    begin++;
                }else{
                    break;
                }
            }
            //pivot <  array[begin]

            if(begin < end){
                int tmp = array[end];
                array[end] = array[begin];
                array[begin] = tmp;
            }
        }
        // 将轴点元素放入最终的位置
        //array[start] = array[begin];
        //array[begin] = pivot;

        System.out.println("       after        "+Arrays.toString(array));
        // 返回轴点元素的位置
        return begin; // begin==end
    }





    public static void main(String[] args) {

        int[] input = {0,1,1,1,4,5,3,7,7,8,10,2,7,8,0,5,2,16,12,1,19,15,5,18,2,2,22,15,8,22,17,6,22,6,22,26,32,8,10,11,2,26,9,12,9,7,28,33,20,7,2,17,44,3,52,27,2,23,19,56,56,58,36,31,1,19,19,6,65,49,27,63,29,1,69,47,56,61,40,43,10,71,60,66,42,44,10,12,83,69,73,2,65,93,92,47,35,39,13,75};

        //int[] input = {10,5,6,10,16,10,20};
        QuickSort2 v = new QuickSort2();
        v.sort(input);
        System.out.println(Arrays.toString(input));
    }
}
