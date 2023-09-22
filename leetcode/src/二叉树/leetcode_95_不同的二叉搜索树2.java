package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode_95_不同的二叉搜索树2
 * @Author zxf
 * @Date 2023/2/2 13:21
 **/
public class leetcode_95_不同的二叉搜索树2 {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();

        return dfs(1,n);
    }

    private List<TreeNode> dfs(int start,int end){
        ArrayList<TreeNode> res = new ArrayList<>();

        //收敛条件
        if(start > end){
            res.add(null);
            return res;
        }

        for(int i = start;i<=end;i++){

            List<TreeNode> leftTrees = dfs(start,i-1);
            List<TreeNode> rightTrees = dfs(i+1,end);

            for(TreeNode left : leftTrees){
                for(TreeNode right : rightTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }

            }
        }

        return res;
    }
}
