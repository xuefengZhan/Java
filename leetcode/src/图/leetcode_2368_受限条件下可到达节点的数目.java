package 图;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @ClassName leetcode_2368_受限条件下可到达节点的数目
 * @Author zxf
 * @Date 2024/3/4 16:09
 * @Questinon Describrition
 **/
public class leetcode_2368_受限条件下可到达节点的数目 {

    ArrayList<Integer>[] map;
    int res = 0;
    boolean[] isrestricted ;  //用数组比set快

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        isrestricted = new boolean[n];

        for (int i : restricted) {
            isrestricted[i] = true;
        }

        map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            if (!isrestricted[x] && ! isrestricted[y]) {
                map[x].add(y); // 都不受限才连边
                map[y].add(x);
            }
        }



        dfs(0,-1);
        return res;
    }

    private void dfs(int cur ,int pre){
        if(isrestricted[cur]) return;
        res++;
        ArrayList<Integer> sons = map[cur];

        for (Integer son : sons) {
            if(son == pre) continue;
            dfs(son,cur);
        }
    }
}
