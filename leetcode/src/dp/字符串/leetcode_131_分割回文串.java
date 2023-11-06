package dp.字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode_131_分割回文串
 * @Author zxf
 * @Date 2023/2/8 9:12
 **/
public class leetcode_131_分割回文串 {

    ArrayList<List<String>> res = new ArrayList<>();
    boolean[][] dp ;

    private void fill(boolean[][] dp,String s){

        int len = dp.length;

        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i+1; j < len; j++) {
                boolean b = s.charAt(i) == s.charAt(j);
                if(j == i + 1){
                    dp[i][j] = b;
                }else{
                    dp[i][j] = dp[i+1][j-1] && b;
                }
            }
        }
    }


    private void dfs(String s,int index,ArrayList<String> path) {
        if(index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if(dp[index][i]){
                path.add(s.substring(index,i+1));
                dfs(s,i+1,path);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        dp = new boolean[s.length()][s.length()];
        fill(dp,s);
        dfs(s,0,new ArrayList<String>());
        return res;
    }




    public static void main(String[] args) {
        leetcode_131_分割回文串 v = new leetcode_131_分割回文串();
        String s = "aba";
        List<List<String>> partition = v.partition(s);
        System.out.println(partition);
    }
}
