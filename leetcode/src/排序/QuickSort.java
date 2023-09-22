package 排序;

import java.util.Arrays;

public class QuickSort {


    public int[] sort(int[] arr){
        sort(arr,0,arr.length-1);
        return arr;
    }

    //让arr在[low,high]范围内分成两部分，前面一部分都比后面一部分小
    private void sort(int[] arr,int low,int high){
        if(high <= low) return;
        int mid = partition(arr,low,high);
        sort(arr,low,mid-1);
        sort(arr,mid+1,high);
    }

    /**
     * 在[low,high] 中 找到一个点,该点的值为pivot，该点左边的所有元素 <= pivot,右边所有的元素>=pivot
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private int partition(int[] arr,int low,int high){
        //随机pivot
        int location = (int) Math.floor((high - low + 1) * Math.random()) + low;
        int tmp1 = arr[low];
        arr[low] = arr[location];
        arr[location] = tmp1;

        int pivot = arr[low];



        //left 和 right 不能跨过pivot
        int left = low+1;
        int right = high;

        while(left <= right){
            if(arr[left] <= pivot){
                left++;
            }else if(arr[right] >= pivot){
                right--;
            }else{
                // arr[left] > pivot && arr[right] < pivot
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        //left > right
        //arr[left] > pivot      arr[right] <= pivot

        int tmp = arr[right];
        arr[right] = pivot;
        arr[low] = tmp;
        return right;
//        int tmp = arr[left];
//        arr[left] = pivot;
//        arr[low] = tmp;
//        return left;

    }




    public static void main(String[] args) {

        int[] input = {0,1,1,1,4,5,3,7,7,8,10,2,7,8,0,5,2,16,12,1,19,15,5,18,2,2,22,15,8,22,17,6,22,6,22,26,32,8,10,11,2,26,9,12,9,7,28,33,20,7,2,17,44,3,52,27,2,23,19,56,56,58,36,31,1,19,19,6,65,49,27,63,29,1,69,47,56,61,40,43,10,71,60,66,42,44,10,12,83,69,73,2,65,93,92,47,35,39,13,75};

        QuickSort v = new QuickSort();
        v.sort(input);
        System.out.println(Arrays.toString(input));
    }
}
