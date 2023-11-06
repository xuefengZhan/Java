package 二叉树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName leetcode_508_出现次数最多的子树元素和
 * @Author zxf
 * @Date 2023/11/3 9:39
 * @Questinon Describrition
 **/
public class leetcode_508_出现次数最多的子树元素和 {
    HashMap<Integer,Integer> map = new HashMap<>();
    int max = 0;

    ArrayList<Integer> res = new ArrayList<>();

    public int[] findFrequentTreeSum(TreeNode root) {

        dfs(root);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if(value == max){
                res.add( key );
            }
        }

        int[] arr = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }

        System.out.println(map);
        System.out.println(res);
        System.out.println(Arrays.toString(arr));
        return arr;
    }


    private int dfs(TreeNode node){
        if(node == null) return 0;

        int val = node.val +  dfs(node.left) + dfs(node.right);
        int num = map.getOrDefault(val,0) + 1;
        max = Math.max(num,max);

        map.put(val,num);

        return val;

    }
}
