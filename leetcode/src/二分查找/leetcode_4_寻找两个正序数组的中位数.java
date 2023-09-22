package 二分查找;

import java.util.Arrays;

/**
 * @ClassName leetcode_4_寻找两个正序数组的中位数
 * @Author zxf
 * @Date 2023/3/10 10:50
 **/
public class leetcode_4_寻找两个正序数组的中位数 {

//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int[] merge = merge(nums1, nums2);
//
//        int mid = ( merge.length - 1) / 2;
//
//        if( (merge.length & 1) == 1) return merge[mid];
//        return (merge[mid] + merge[mid + 1]) / 2.0;
//    }
//
//
//    private int[] merge(int[] arr1,int[] arr2){
//        int[] res = new int[arr1.length + arr2.length];
//
//        int r = 0;
//        int l = 0;
//
//        for (int i = 0; i < res.length; i++) {
//            if(l < arr1.length && (r >= arr2.length || (arr1[l] <= arr2[r]))){
//                res[i] = arr1[l++];
//            }else{
//                res[i] = arr2[r++];
//            }
//        }
//
//        return res;
//    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int mid = (n + m) / 2;
        //n + m 为奇数时，比如7 那么找第3个
        if((n+m) % 2 ==1) return  findK(nums1,0,n-1,nums2,0,m-1, mid);

        return findK(nums1,0,n-1,nums2,0,m-1, mid) + findK(nums1,0,n-1,nums2,0,m-1, mid +1) * 0.5 ;

    }


    private int findK(int[] nums1,int start1,int end1, int[] nums2,int start2,int end2,int len){
            int n = end1 - start1 +  1;
            int m = end2 - start2 + 1;

            return 0;

    }









    public static void main(String[] args) {
        leetcode_4_寻找两个正序数组的中位数 v = new leetcode_4_寻找两个正序数组的中位数();

        int[] nums1 = {1,2};
        int[] nums2 = {3,4};


//        int[] merge = v.merge(nums1, nums2);
//        System.out.println(Arrays.toString(merge));


        double medianSortedArrays = v.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

}
