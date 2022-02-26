package 字符串;

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class 剑指Offer05_替换空格 {
    public String replaceSpace(String s) {

        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();

        for(char c : chars){
            if(c == ' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }


        return sb.toString();
    }


    public static void main(String[] args) {
        剑指Offer05_替换空格 v = new 剑指Offer05_替换空格();
        String s =  "We are happy.";
        String res = v.replaceSpace(s);


        System.out.println(res);
    }
}
