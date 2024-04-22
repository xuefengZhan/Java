package 数字;

/**
 * @ClassName 数字.leetcode_2834_找出美丽数组的最小和
 * @Author zxf
 * @Date 2024/3/8 17:12
 * @Questinon Describrition
 **/
public class leetcode_2834_找出美丽数组的最小和 {


    int mod = 1_000_000_007;

    //两部分：
    //第一部分：在target内部,数组中可以包含 [1,target/2] ,如果n < target / 2 那么就是[1,n]
    //第二部分：那肯定是target / 2 < n了 , 此时还剩 n - target / 2 个

    //本题考察的就是等差数列求和
    public int minimumPossibleSum(int n, int k) {

//        long m = Math.min(target / 2, n);
//        int res = (int) (( m * (1 + m)  + (n - m) * (target + target + n - m - 1))  / 2 % mod);
//
//        return res;
        long m = Math.min(k / 2, n);
        return (int) ((m * (m + 1) + (n - m - 1 + k * 2) * (n - m)) / 2 % 1_000_000_007);
    }


    public static void main(String[] args) {
        leetcode_2834_找出美丽数组的最小和 v = new leetcode_2834_找出美丽数组的最小和();
        int n = 1000000000;
        int target = 1000000000;

        int res = v.minimumPossibleSum(n, target);

        System.out.println(res);
    }
}
