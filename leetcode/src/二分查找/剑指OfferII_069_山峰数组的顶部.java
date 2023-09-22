package 二分查找;

/**
 * @ClassName 剑指OfferII_069_山峰数组的顶部
 * @Author zxf
 * @Date 2023/3/31 16:18
 *
 *
 * 翻译：找数组中 比左边和右边都大的数字的索引
 **/
public class 剑指OfferII_069_山峰数组的顶部 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int mid = (right - left) / 2   + left ;

            if(mid == 0 || mid == arr.length - 1) return -1;
            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1] ){
                return mid;
            }
            if(arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1] ){
                left = mid ;
            }else{
                right = mid ;
            }

        }
        return -1;
    }
}
