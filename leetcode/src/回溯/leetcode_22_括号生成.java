package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode_22_括号生成
 * @Author zxf
 * @Date 2023/8/10 11:31
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 **/
public class leetcode_22_括号生成 {

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n == 0) return null;
        dfs(n,0,0,new StringBuilder());

        return res;
    }


    private void dfs(int n,int left,int right,StringBuilder sb){
        if(right == left && right == n){
            res.add(sb.toString());
            return;
        }

        if(right > left || left > n) return;

        //左边
        sb.append('(');
        left++;
        dfs(n,left,right,sb);
        sb.deleteCharAt(sb.length() - 1);
        left--;

        //右边
        sb.append(')');
        right++;
        dfs(n,left,right,sb);
        sb.deleteCharAt(sb.length() - 1);
        right--;

    }
}
