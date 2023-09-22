package 数字;

/**
 * @ClassName leetcode_1281_整数的各位积和之差
 * @Author zxf
 * @Date 2023/8/9 14:42
 **/
public class leetcode_1281_整数的各位积和之差 {
    public int subtractProductAndSum(int n) {
        int left = 0;
        int m = 1;
        int l = 0;

        while(n != 0){

            left = n % 10;

            m *= left;
            l += left;
            n = n / 10;

            System.out.println("m == " + m);
            System.out.println("n == " + n);
        }

        return m - l;
    }


    public static void main(String[] args) {
        int i = new leetcode_1281_整数的各位积和之差().subtractProductAndSum(705);
        System.out.println(i);
    }
}
