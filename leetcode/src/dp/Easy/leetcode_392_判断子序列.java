package dp.Easy;

/**
 * @ClassName leetcode_392_判断子序列
 * @Author zxf
 * @Date 2023/8/15 9:16
 * @Questinon Describrition
 **/
public class leetcode_392_判断子序列 {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        //初始化  如果不存在值为m 因为m取不到 代替正无穷
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            //f[add][s.charAt(i) - 'a']  add=0时，表示从t的0号位置开始，第一个s.charAt(i)字符的位置
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            //从t的s.charAt(i)字符的位置的下一个位置开始
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        leetcode_392_判断子序列 v = new leetcode_392_判断子序列();
        boolean subsequence = v.isSubsequence("abc", "ahbgdc");
        System.out.println(subsequence);
    }

}
