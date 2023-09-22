package 二分查找;

import java.util.Arrays;

/**
 * @ClassName lcp_18_早餐组合
 * @Author zxf
 * @Date 2023/3/2 15:35
 **/
public class lcp_18_早餐组合 {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {

        Arrays.sort(staple);
        Arrays.sort(drinks);


        int prev = 0;
        int sum = 0;

        for (int i = 0; i < staple.length; i++) {
            if(i > 0 && staple[i] == staple[i - 1]){
                sum += prev;
            }else{
                prev = find(x-staple[i],drinks);
                sum+= prev;
            }
            //System.out.println("当前staple["+i+"]对应的早餐" + staple[i] + "可以买的饮料个数为" +  prev);
        }

        return sum;
    }


    //todo 在nums中找到index,使得index-1 <= target ,index>target
    private int find(int target,int[] nums) {

        int left = 0;
        int right = nums.length - 1;


        while (right >= left) {
            int mid = (right - left) / 2 + left;

            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        lcp_18_早餐组合 v = new lcp_18_早餐组合();
        int[] staple = {10,20,5};
        int[] drinks = {5,5,2};

        int x = 15;

        int res = v.breakfastNumber(staple, drinks, x);

        System.out.println(res);
    }
}
