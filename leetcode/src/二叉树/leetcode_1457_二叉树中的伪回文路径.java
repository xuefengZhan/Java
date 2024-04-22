package 二叉树;

import java.util.HashSet;

/**
 * @ClassName leetcode_1457_二叉树中的伪回文路径
 * @Author zxf
 * @Date 2024/1/9 10:57
 * @Questinon Describrition
 **/
public class leetcode_1457_二叉树中的伪回文路径 {
    int res = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root,0);
        return res;
    }

    private void dfs(TreeNode node,int cnt){
        if(node == null) return;

        cnt ^= 1 << node.val;

        if(node.left == null && node.right == null){
            //如果cnt为0或者只有1位为1 则该路径是回文的
            if(cnt == (cnt & -cnt)) res++;
            return;
        }

        dfs(node.left,cnt);
        dfs(node.right,cnt);
    }
}
