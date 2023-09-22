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
public class leetcode69_x的平方根 {
    public int mySqrt(int x) {
        if(x <= 1) return x;
        long a = x;

        while(a > x/a){
            a = (x/a + a) / 2;  //如果a是类型 这里可能越界
        }

        // a * a <= x

        return (int) a ;
    }
}
