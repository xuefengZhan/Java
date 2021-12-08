import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class _22 {

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     */

    List<String> res = new ArrayList<>();
    char[] options = new char[]{'(',')'};

    public List<String> generateParenthesis(int n) {
        if( n == 0) return res;

        place(new StringBuilder(),options,0,n);

        return res;
    }

    /**
     *
     * @param path
     * @param options      '(' ')'
     * @param num           path中)个数
     */
    private void place(StringBuilder path,char[] options,int num,int n){
        if(num == n && path.length() == (n<<1)){
            String s = path.toString();
            res.add(s);
            return;
        }

        if(num > path.length() - num){
           return;
        }

        for (char option : options) {
            if(num == n && option == ')') continue;
            if(path.length() - num == n && option == '(') continue;

            path.append(option);
            if(option == ')'){
                num ++;
            }
            place(path,options,num,n);

            int length = path.length();
            if(path.charAt(length -1) == ')') num--;
            path.deleteCharAt(length - 1);

        }
    }

    public static void main(String[] args) {
        _22 v = new _22();
        List<String> strings = v.generateParenthesis(3);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
