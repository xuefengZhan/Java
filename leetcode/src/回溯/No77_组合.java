package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No77_组合 {

    List<List<Integer>> res = new ArrayList<>();

    //给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合
    public List<List<Integer>> combine(int n, int k) {
        int[] chooses = new int[n];

        for (int i = 0; i < chooses.length; i++) {
            chooses[i] = i + 1;
        }

        System.out.println(Arrays.toString(chooses));

        place(chooses,0 ,k,new ArrayList<Integer>());
        return res;
    }

    //给当前选择
    private void place(int[] chooses,int index ,int k,ArrayList<Integer> path){

        if(path.size() == k){
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = index; i < chooses.length; i++) {
            //当前元素的选择
            path.add(chooses[i]);
            //下一个元素的选择
            place(chooses,i+1,k,path);
            //
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        No77_组合 v = new No77_组合();
        int n = 4;
        int k = 2;
        List<List<Integer>> res = v.combine(n, k);

        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }
}
