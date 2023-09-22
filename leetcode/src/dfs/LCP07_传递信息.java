package src.dfs;

import java.util.ArrayList;

public class LCP07_传递信息 {
    ArrayList<Integer>[] map ;
    int res = 0;
    public int numWays(int n, int[][] relation, int k) {

        //1. 初始化 map    key是玩家编号，value是一个list序列，存储该玩家可以直达的玩家编号
        map = new ArrayList[n];

        for(int i = 0;i<relation.length;i++){
            int[] rel = relation[i];
            if(map[rel[0]] == null) {
                map[rel[0]] = new ArrayList<Integer>();
            }
            map[rel[0]].add(rel[1]);
        }

        //2. 深搜
        dfs(0,n-1,k);

        return res;
    }



    private void dfs(int source,int destination,int k){

        if(k == 0){
            if(source == destination){
                res++;
            }
            return;
        }

        //准备路径
        ArrayList<Integer> path = map[source];
        for(int i = 0;i<path.size();i++){
            int newSource = path.get(i);
            dfs(newSource,destination,k-1);
        }
    }
}
