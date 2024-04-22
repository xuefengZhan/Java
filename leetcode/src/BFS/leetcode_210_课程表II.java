package BFS;

import java.util.*;

/**
 * @ClassName leetcode_210_课程表II
 * @Author zxf
 * @Date 2024/3/14 17:08
 * @Questinon Describrition
 **/
public class leetcode_210_课程表II {

    int[] map;//存储每个节点的入度

    ArrayList<Integer>[] arr;//存储每个节点的下游

    int[] res ; //存储答案
    int n ; //存储res数组的下标
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res = new int[numCourses];
        map = new int[numCourses];

        //初始化图
        arr = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int[] prerequisite : prerequisites) {
            int prev = prerequisite[1];
            int aft = prerequisite[0];
            map[aft]++; //顺便把每个节点的入度初始化
            arr[prev].add(aft);
        }

        System.out.println(Arrays.toString(map));

        //按照层序遍历的模式 将度为0的出队 下游节点入度减1  只有入度为0的下游节点才能放进队列
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if(map[i] == 0){
                que.offer(i);
                res[n++] = i;
            }
        }

        while(! que.isEmpty()){
            Integer poll = que.poll();

            ArrayList<Integer> arrayList = arr[poll];

            for (Integer o : arrayList) {
                if(-- map[o] == 0){
                    res[n++] = o;
                    que.offer(o);
                }
            }
        }

        //个数正好的时候 答案才是对的
        if(n == numCourses){
            return res;
        }

        return new int[0];
    }

    public static void main(String[] args) {
        leetcode_210_课程表II v = new leetcode_210_课程表II();

        int num = 2;
        int[][] arr = new int[0][];

        int[] order = v.findOrder(num, arr);

        System.out.println(Arrays.toString(order));
    }
}
