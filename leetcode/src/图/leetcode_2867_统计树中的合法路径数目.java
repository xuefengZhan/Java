package 图;

import java.util.*;

/**
 * @ClassName leetcode_2867_统计树中的合法路径数目
 * @Author zxf
 * @Date 2024/2/28 14:32
 * @Questinon Describrition
 **/
public class leetcode_2867_统计树中的合法路径数目 {

    //1. 存储是否是质数
    // 埃氏筛
    private static final int N = 100001;
    private static boolean[] isPrime = new boolean[N];
    static {
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = 2; i * i < N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }


    //1. 存储结果
    long res = 0;
    //2. 存储图
    ArrayList<Integer>[] graph;

    //3 存储每个非质数节点的最大联通量（联通的最大非质数节点个数）
    long[] count;

    public long countPaths(int n, int[][] edges) {
        //todo 1.构造图
        graph = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }


        //todo 2.遍历所有节点 每个质数节点获取结果
        count = new long[n+1];
        for (int i = 1; i <= n; i++) {
            if(isPrime[i]){
                long plus = 0;
                long total = 0;

                //i是质数节点 从其子节点开始遍历
                for (Integer son : graph[i]) {
                    //size存储当前son连接的最大非质数节点个数
                    long size = 0;
                    //如果该子节点的联通树大小知道了 直接返回
                    if(count[son] != 0){
                        size = count[son];
                    }else{
                        ArrayList<Integer> nodes = new ArrayList<>();  //存储当前子节点联通的非质数节点
                        dfs(nodes,son,i);
                        size = nodes.size();
                        //将非质数节点的联通树大小存储起来 用于剪枝
                        for (Integer node : nodes) {
                            count[node] = size;
                        }
                    }
                    //计算当前质数节点i提供的结果
                    //假设子树非质数节点分别为a b c
                    //则结果为 a + b + c + a * b + a * c + b * c
                    //第一次为 a                      total = a plus = a
                    //第二次为 a + b + b * a          total = a + b * (1 + a)   plus = a + b
                    //第三次为                        total = a + b * (1 + a) + c + c * plus
                    total += size * (1 + plus);  //total是总数
                    plus += size;                //a + b + c
                }
                res += total;
            }
        }
        return res;
    }


    private void dfs(ArrayList<Integer> nodes,int cur,int pre){
        //如果当前是质数节点则返回0
        if(isPrime[cur]) return;

        nodes.add(cur);

        //遍历子节点
        for (Integer son : graph[cur]) {
            if(son == pre) continue; //防止回头
            dfs(nodes,son,cur);
        }
    }



    public static void main(String[] args) {
//        int n = 5;
//        int[][] edges = {{1,2},{1,3},{2,4},{2,5}};
        int n = 6;
        int[][] edges = {{1,2},{1,3},{2,4},{3,5},{3,6}};

//        int n = 4;
//        int[][] edges = {{1,2},{4,1},{3,4}};
//        int n = 2;
//        int[][] edges = {{2,1}};

        leetcode_2867_统计树中的合法路径数目 v = new leetcode_2867_统计树中的合法路径数目();

        long sout = v.countPaths(n, edges);

        System.out.println(sout);
    }


}


