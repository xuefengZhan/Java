package 贪心.Easy;

public class leetcode_409_最长回文子串 {

    public int longestPalindrome(String s) {
        //A  65  Z  90      a  97  z 122
        //122 - 65 + 1 = 58
        int[] map = new int[58];

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'A']++;
        }

        //标识是否存在奇数
        boolean flag = false;

        int res = 0;
        for (int i = 0; i < map.length; i++) {
            res += map[i] - (map[i] & 1);  //奇数的话 - 1   偶数则保留
        }

        return res < s.length()? res+1 : res;
    }

    public static void main(String[] args) {
        leetcode_409_最长回文子串 v = new leetcode_409_最长回文子串();
        String s = "abccccdd";
        int i = v.longestPalindrome(s);

        System.out.println(i);
    }
}
