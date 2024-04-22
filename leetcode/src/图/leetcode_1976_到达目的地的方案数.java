package 图;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @ClassName leetcode_1976_到达目的地的方案数
 * @Author zxf
 * @Date 2024/3/5 11:26
 * @Questinon Describrition
 **/
public class leetcode_1976_到达目的地的方案数 {
//    v1 版本
//    //装图的连接关系
//    ArrayList<long[]>[] map ;
//    //装已经确定的节点
//    HashSet<Integer> visited = new HashSet<>();
//    //装每个节点的最短距离
//    long[] dp ;
//    //装每个节点最短路径个数
//    long[] time;
//
//    public int countPaths(int n, int[][] roads) {
//
//        dp = new long[n];
//        Arrays.fill(dp,-1);
//        time = new long[n];
//
//        //todo 1.初始化图
//        map = new ArrayList[n];
//        for (int i = 0; i < n; i++) {
//            map[i] = new ArrayList<>();
//        }
//
//        for (int[] road : roads) {
//            int from = road[0];
//            int to = road[1];
//            long time = road[2];
//
//            map[from].add(new long[]{road[0], road[2]});
//            map[to].add(new long[]{road[1], road[2]});
//        }
//
//
//        //初始化
//        visited.add(0);
//        dp[0] = 0;
//        time[0]=1;
//
//
//        while(visited.size() < n){
//            long min = Long.MAX_VALUE;  //存储接下来的最短节点到0的长度
//            HashSet<Integer> wait = new HashSet<>(); //装本次能确定的节点
//
//            System.out.println("==============================================");
//            System.out.println(" visited == " + visited);
//
//            //遍历已经确定的节点
//            for (Integer v : visited) {
//
//                ArrayList<long[]> sons = map[v];
//
//                System.out.println("--------上游节点 v == " + v + "--------" );
//                for (long[] son : sons) {
//                    int nextV = (int) son[0];
//                    long distance = son[1];
//
//                    if(visited.contains(nextV)) continue;
//
//                    if(min > dp[v] + distance ){
//                        //重新维护
//                        wait.clear();
//
//
//                        min = dp[v] + distance;
//                        time[nextV] = time[v];
//                        dp[nextV] = min;
//
//                        wait.add(nextV);
//                    }else if(min == dp[v] + distance){
//                        //如果之前的路径长度大
//                        if(dp[nextV] > min){
//                            time[nextV] = time[v];
//                        }else{
//                            time[nextV] = (time[nextV] + time[v] ) % (1000000007);
//                        }
//                        wait.add(nextV);
//                    }
//                    System.out.println("nextV " + nextV + " time " + time[nextV]);
//                }
//            }
//            visited.addAll(wait);
//            for (Integer integer : wait) {
//                dp[integer] = min;
//            }
//        }
//        System.out.println(Arrays.toString(dp));
//        System.out.println(Arrays.toString(time));
//        return (int) time[n-1];
//    }


    //装图的连接关系
    ArrayList<long[]>[] map ;
    //装已经确定的节点
    HashSet<Integer> visited = new HashSet<>();
    //装每个节点的最短距离
    long[] dp ;
    //装每个节点最短路径个数
    long[] time;

    public int countPaths(int n, int[][] roads) {

        dp = new long[n];
        Arrays.fill(dp,-1);
        time = new long[n];

        //todo 1.初始化图
        map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            long time = road[2];

            map[from].add(new long[]{road[0], road[2]});
            map[to].add(new long[]{road[1], road[2]});
        }


        //初始化
        visited.add(0);
        dp[0] = 0;
        time[0]=1;


        while(visited.size() < n){
            long min = Long.MAX_VALUE;  //存储接下来的最短节点到0的长度
            HashSet<Integer> wait = new HashSet<>(); //装本次能确定的节点

            System.out.println("==============================================");
            System.out.println(" visited == " + visited);

            //遍历已经确定的节点
            for (Integer v : visited) {

                ArrayList<long[]> sons = map[v];

                System.out.println("--------上游节点 v == " + v + "--------" );
                for (long[] son : sons) {
                    int nextV = (int) son[0];
                    long distance = son[1];

                    if(visited.contains(nextV)) continue;

                    if(min > dp[v] + distance ){
                        //重新维护
                        wait.clear();


                        min = dp[v] + distance;
                        time[nextV] = time[v];
                        dp[nextV] = min;

                        wait.add(nextV);
                    }else if(min == dp[v] + distance){
                        //如果之前的路径长度大
                        if(dp[nextV] > min){
                            time[nextV] = time[v];
                        }else{
                            time[nextV] = (time[nextV] + time[v] ) % (1000000007);
                        }
                        wait.add(nextV);
                    }
                    System.out.println("nextV " + nextV + " time " + time[nextV]);
                }
            }
            visited.addAll(wait);
            for (Integer integer : wait) {
                dp[integer] = min;
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(time));
        return (int) time[n-1];
    }


    public static void main(String[] args) {
        leetcode_1976_到达目的地的方案数 v = new leetcode_1976_到达目的地的方案数();

        int n = 7;
        int[][] roads = new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};

        int res = v.countPaths(n, roads);

        System.out.println(res);
    }
}
