package 二分查找;

/**
 * @ClassName leetcode_852_山脉数组的峰顶索引
 * @Author zxf
 * @Date 2023/3/9 12:07
 *
 *
 *  找到索引index  满足  index - 1 < index > index + 1
 *
 **/
public class leetcode_852_山脉数组的峰顶索引 {
    public int peakIndexInMountainArray(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        int mid = 0;

        //迭代到mid 是为了保持距离
        while( (mid = (right - left) / 2 + left) > 0 && mid < arr.length - 1){
            if(arr[mid - 1] < arr[mid]  && arr[mid] > arr[mid + 1]){
                return mid;
            }else if(arr[mid - 1] < arr[mid]  && arr[mid] < arr[mid + 1]){
                left = mid;
            }else{
                right = mid;
            }
        }

        return -1;
    }



}
