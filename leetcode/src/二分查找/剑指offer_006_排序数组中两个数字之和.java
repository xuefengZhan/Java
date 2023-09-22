package 二分查找;

/**
 * @ClassName 剑指offer_006_排序数组中两个数字之和
 * @Author zxf
 * @Date 2023/3/30 13:54
 **/
public class 剑指offer_006_排序数组中两个数字之和 {

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];

        for(int i = 0;i<numbers.length;i++){
            int x = find(numbers,i,target - numbers[i]);

            if (x != -1){
                res[0] = i;
                res[1] = x;

                return res;
            }
        }

        return res;
    }


    private int find(int[] numbers,int start,int i){

        int left = start + 1;
        int right = numbers.length - 1;

        while(left <= right){
            int mid = (right - left) / 2 + left;

            if(numbers[mid] == i) return mid;

            if(numbers[mid] > i){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }

        return -1;
    }
}
