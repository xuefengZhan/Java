package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    List<List<String>> res = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {


        return res;
    }


    private void dfs(String s, int start,StringBuilder sb ,List<String> paths){
        if(start == s.length()){
            res.add(new ArrayList<>(paths));
            return;
        }


        char c = s.charAt(start);
        sb.append(c);

        //做出当前选择
        if(isSym(sb.toString())){
            //放入
            paths.add(sb.toString());
            dfs(s,start+1,new StringBuilder(),paths);

            //不放入
            paths.remove(paths.size() - 1);
            dfs(s,start+1,sb,paths);

        }else{
            dfs(s,start+1,sb,paths);
        }
    }




    private boolean isSym(String sb){
        int len = sb.length();

        for (int i = 0; i < len / 2; i++) {
            if(sb.charAt(i) != sb.charAt(len - 1 - i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Main v = new Main();
//        boolean a = v.isSym("abb");
//        System.out.println(a);
        String s = "aab";
        List<List<String>> partition = v.partition(s);
        System.out.println(partition);
    }
}
