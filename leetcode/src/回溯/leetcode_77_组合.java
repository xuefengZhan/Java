package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode_77_组合
 * @Author zxf
 * @Date 2023/8/11 9:56
 *
 * @Questinon Describrition
 *  给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *  你可以按 任何顺序 返回答案。
 **/
public class leetcode_77_组合 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        if(k > n) return null;
        dfs(n,1,new ArrayList<Integer>(),k);

        return res;
    }

    private void dfs(int n,int start,List<Integer> path,int k){

        if(n - start + 1 < k) return;

        if(k  == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            //剪枝
            //if(n - i + 1 < k) break;//当前要选出k个数 1,2,3,4 k=4的时候还行，4 - 1 + 1 = 4 = k

            path.add(i);

            dfs(n,i+1,path,k-1);

            path.remove(path.size() - 1);
        }
    }
}
