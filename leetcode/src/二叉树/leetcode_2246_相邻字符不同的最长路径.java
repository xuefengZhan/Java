package 二叉树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName leetcode_2246_相邻字符不同的最长路径
 * @Author zxf
 * @Date 2023/11/21 10:21
 * @Questinon Describrition
 **/
public class leetcode_2246_相邻字符不同的最长路径 {

    int res = 0;
    HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

    public int longestPath(int[] parent, String s) {
        if(parent == null || parent.length == 0) return 0;
        if(parent.length == 1) return 1;

        for (int i = 0; i < parent.length; i++) {
            List<Integer> sons = map.computeIfAbsent(parent[i], k -> new ArrayList<>());
            sons.add(i);
        }

        System.out.println("map == " + map);
        dfs(parent,0,s);

        return res;
    }


    //返回当前节点的最大值
    private int dfs(int[] parent,int index,String s){

        System.out.println("========= index " + index + " ===========");
        List<Integer> sons = map.get(index);
        System.out.println(" parent = " + index);
        System.out.println("songs = " + sons);
        if(sons == null || sons.isEmpty()){
            return 1;
        }
        char farther = s.charAt(index);
        System.out.println("farther == " + farther);


        int max = 0;
        int second = 0;

        for (int i = 0; i < sons.size(); i++) {
            int son = sons.get(i);
            char sonC = s.charAt(son);
            System.out.println("sonC == " + sonC);
            int cur =  dfs(parent, son, s);


            if (sonC != farther) {
                if(cur > max){
                    second = max;
                    max = cur;
                }else if(cur > second){
                    second = cur;
                }
            }

        }


        res = Math.max(res,second+max+1);
        return max+1;
    }

    public static void main(String[] args) {
        leetcode_2246_相邻字符不同的最长路径 v = new leetcode_2246_相邻字符不同的最长路径();

//        int[] parent = {-1,0,0,1,1,2};
//        String s =  "abacbe";
        int[] parent = {-1,137,65,60,73,138,81,17,45,163,145,99,29,162,19,20,132,132,13,60,21,18,155,65,13,163,125,102,96,60,50,101,100,86,162,42,162,94,21,56,45,56,13,23,101,76,57,89,4,161,16,139,29,60,44,127,19,68,71,55,13,36,148,129,75,41,107,91,52,42,93,85,125,89,132,13,141,21,152,21,79,160,130,103,46,65,71,33,129,0,19,148,65,125,41,38,104,115,130,164,138,108,65,31,13,60,29,116,26,58,118,10,138,14,28,91,60,47,2,149,99,28,154,71,96,60,106,79,129,83,42,102,34,41,55,31,154,26,34,127,42,133,113,125,113,13,54,132,13,56,13,42,102,135,130,75,25,80,159,39,29,41,89,85,19};
        String s =  "ajunvefrdrpgxltugqqrwisyfwwtldxjgaxsbbkhvuqeoigqssefoyngykgtthpzvsxgxrqedntvsjcpdnupvqtroxmbpsdwoswxfarnixkvcimzgvrevxnxtkkovwxcjmtgqrrsqyshxbfxptuvqrytctujnzzydhpal";


        int i = v.longestPath(parent, s);

        System.out.println(i);
    }

}
