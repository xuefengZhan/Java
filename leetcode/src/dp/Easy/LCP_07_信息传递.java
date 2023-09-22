package dp.Easy;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName LCP_07_信息传递
 * @Author zxf
 * @Date 2023/8/18 11:33
 * @Questinon Describrition
 **/
public class LCP_07_信息传递 {
    public int numWays(int n, int[][] relation, int k) {

        int res = 0;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] tuple : relation) {
           int key = tuple[0];
            List<Integer> integers = map.get(key);
            if(integers == null){
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(tuple[1]);
                map.put(key,arr);
            }else{
                integers.add(tuple[1]);
            }
        }

        ArrayList<Integer> chooses = new ArrayList<>();
        chooses.add(0);

        while(k > 0){
            ArrayList<Integer> nextChooses = new ArrayList<Integer>();
            for (Integer choose : chooses) {

                List<Integer> nexts = map.get(choose);
                if(nexts == null) continue;
                nextChooses.addAll(nexts);
            }
            chooses = nextChooses;
            k--;
        }

        for (Integer choose : chooses) {
            if(choose == n - 1) res++;
        }



        //k == 0

        return res;
    }

    public static void main(String[] args) {
        int[][] relation = new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};

        int n = 5;

        int k = 3;

        LCP_07_信息传递 v = new LCP_07_信息传递();
        int i = v.numWays(n, relation, k);

        System.out.println(i);
    }

}
