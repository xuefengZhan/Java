package BFS;

import java.util.*;

/**
 * @ClassName leetcode_310_最小高度树
 * @Author zxf
 * @Date 2023/9/21 9:42
 * @Questinon Describrition 击败 89.52%  BFS
 *
 * 参考思路：https://leetcode.cn/problems/minimum-height-trees/solutions/242910/zui-rong-yi-li-jie-de-bfsfen-xi-jian-dan-zhu-shi-x/
 **/
public class leetcode_310_最小高度树 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        ArrayList<Integer> res = new ArrayList<>();
        if(n == 1){
            res.add(0);
            return res;
        }
        ArrayList<Integer>[] map = new ArrayList[n];  //index是节点 list是子节点
        int[] arr = new int[n];

        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }



        for (int[] edge : edges) {
            int n1 = edge[0];
            int n2 = edge[1];


            map[n1].add(n2);
            map[n2].add(n1);

            arr[n1]++;
            arr[n2]++;
        }

        Queue<Integer> que = new LinkedList<>();

        //初始化将度为1的放进队列
        for (int i = 0; i < arr.length; i++) {
            //i是节点
            //arr[i]是度
            if(arr[i] == 1){
                que.offer(i);
            }
        }

        int size = que.size();

        while(! que.isEmpty()){
            if(size == 0){
                res = new ArrayList<>();
                size = que.size();
            }

            //把当前层加入
            Integer poll = que.poll();
            res.add(poll);
            size--;

            //获取子节点 子节点的度-1
            ArrayList<Integer> sons = map[poll];
            for (Integer son : sons) {
                arr[son]--;
                if(arr[son] == 1){
                    que.offer(son); //入队
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        leetcode_310_最小高度树 v = new leetcode_310_最小高度树();
        int n = 6;
        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};

        List<Integer> res = v.findMinHeightTrees(n, edges);

        System.out.println(res);
    }
}
