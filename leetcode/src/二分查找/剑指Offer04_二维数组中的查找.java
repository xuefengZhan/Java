package 二分查找;

/**
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/submissions/
 *
 * 100%
 */
public class 剑指Offer04_二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if(matrix == null || matrix.length == 0) return false;
        if(matrix[0].length == 0) return false;


        for (int[] ints : matrix) {
            if(ints[ints.length - 1] < target) continue;
            if(ints[ints.length - 1] ==  target) return true;

            if(find(ints,target)) return true;

        }

        return false;
    }



    private boolean find(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;


        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(arr[mid] == target) return true;
            if(arr[mid] > target){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        剑指Offer04_二维数组中的查找 v = new 剑指Offer04_二维数组中的查找();
        int[][] arr =  {
        {1,   4,  7, 11, 15},
         {2,  5,  8, 12, 19},
        {3,   6,  9, 16, 22},
        {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}
        };


        boolean b = v.findNumberIn2DArray(arr, 20);

        System.out.println(b);

    }
}
