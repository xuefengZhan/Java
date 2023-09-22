package 二叉树;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 *
 * easy
 *
 */
public class leetcode_501_二叉搜索树中的众数 {

    HashSet<Integer> set = new HashSet<>();
    public int[] findMode(TreeNode root) {
        if(root == null) return null;
        dfs(root);

        int[] res = new int[set.size()];
        int i = 0;
        for (Integer integer : set) {
            res[i++] = integer;
        }
        return res;
    }


    int prev = 0;
    int count = 0;
    int maxCount = 0;


    private void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        if(prev != root.val){
            //第一个元素初始化
            prev = root.val;
            count = 1;
        }else{
            count++;
        }
        //只要count改变 就判断
        if(count > maxCount){
            maxCount = count;
            set.clear();
            set.add(root.val);
        }else if(count == maxCount){
            set.add(root.val);
        }

        dfs(root.right);
    }

}
