package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode_89_格雷编码
 * @Author zxf
 * @Date 2023/8/14 9:20
 * @Questinon Describrition
 **/
public class leetcode_89_格雷编码 {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            ans.add(gray(i));
        }
        return ans;
    }

    /**
     * 计算第 n 个格雷码
     * 格雷码计算公式：G(n) = n xor (n >> 1)
     */
    public int gray(int n) {
        return n ^ (n >> 1);

        //8  1000
        //7  0100

        //   1100
    }

    public static void main(String[] args) {
        leetcode_89_格雷编码 v = new leetcode_89_格雷编码();
        List<Integer> integers = v.grayCode(4);
        System.out.println(integers);
    }
}
