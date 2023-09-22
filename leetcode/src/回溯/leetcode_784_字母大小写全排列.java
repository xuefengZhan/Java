package 回溯;

import java.util.ArrayList;
import java.util.List;

public class leetcode_784_字母大小写全排列 {
    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
            dfs(s,0,new StringBuilder());
            return res;
    }


    private void dfs(String s, int index,StringBuilder path){
        if(index == s.length()){
            res.add(path.toString());
            return;
        }

        char c = s.charAt(index);

        if('A' <= c && c <= 'Z' || 'a' <= c && c <= 'z' ){
            path.append(Character.toLowerCase(c));
            dfs(s,index+1,path);
            path.deleteCharAt(index);

            path.append(Character.toUpperCase(c));
            dfs(s,index+1,path);
            path.deleteCharAt(index);
        }else{
            path.append(c);
            dfs(s,index+1,path);
            path.deleteCharAt(index);
        }


    }

    public static void main(String[] args) {
        leetcode_784_字母大小写全排列 v = new leetcode_784_字母大小写全排列();
        String s  = "a1b2";

        List<String> strings = v.letterCasePermutation(s);

        System.out.println(strings);
    }
}
