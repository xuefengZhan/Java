package 二分查找;

/**
 * 示例 1：
 *
 * 输入：x = 4
 * 输出：2
 * 示例 2：
 *
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No69_x的平方根 {
    public int mySqrt(int x) {
        if(x <= 1) return x;


        //假设长边 L = x  也就是1 * x 的长方形
        //要想让长方形向正方形靠拢
        // L -> 根号A   迭代：L => (L + A/L) >> 1;
        int l = x;
        while(l * l > x){
            l = (l + x/l) >> 1;
        }

        return l;
    }
}
