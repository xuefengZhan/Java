public class Solution {
    public int maxPower(String s) {
        if(s == null) return 0;
        int maxPower = 1;
        char[] chars = s.toCharArray();

        int i = 0;
        int power = 1;
        for(int j = i +1;j<chars.length;j++){
            if(chars[j] == chars[i]){
                power++;
                if(j == chars.length -1) return power;
            }else{
                if(power > maxPower) maxPower = power;
                i = j;
                power = 1;
            }
        }
        return maxPower;
    }

    public static void main(String[] args) {
        int leetcode = new Solution().maxPower("cc");
        System.out.println(leetcode);
    }
}
