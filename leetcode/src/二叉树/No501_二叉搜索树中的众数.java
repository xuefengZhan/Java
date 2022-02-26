package 二叉树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 *
 * easy
 *
 */
public class No501_二叉搜索树中的众数 {
    HashMap<Integer,Integer> map = new HashMap();

    public int[] findMode(TreeNode root) {
        travel(root);

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        int max = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer value = entry.getValue();
            Integer key = entry.getKey();

            if(value < max) continue;

            if(value == max){
                list.add(key);
            }else{
                max = value;
                list.clear();
                list.add(key);
            }
        }

        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private void travel(TreeNode root){
        if(root == null) return;

        map.merge(root.val, 1, Integer::sum);

        travel(root.left);
        travel(root.right);

    }


}
