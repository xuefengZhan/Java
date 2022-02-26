package 数组;

public class No917_仅仅反转字母 {

    private boolean inRange(char c){
        return (65 <= c && c <= 90) || (97 <= c && c <= 122);
    }

    public String reverseOnlyLetters(String s) {
        if(s == null || s.length() == 1) return s;

        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() -1;

        while(true){

            while(left < s.length() && !inRange(chars[left])){
                left++;
            }

            while (right >= 0 && !inRange(chars[right])){
                right--;
            }

            if(left >= s.length() || right < 0) break;

            char tmp = s.charAt(left);
            chars[left] = s.charAt(right);
            chars[right] = tmp;

            left++;
            right--;

        }

        return new String(chars);
    }


    public static void main(String[] args) {
        No917_仅仅反转字母 v = new No917_仅仅反转字母();
        String s =  "7_28]";
        String s1 = v.reverseOnlyLetters(s);

        System.out.println(s1);
    }
}
