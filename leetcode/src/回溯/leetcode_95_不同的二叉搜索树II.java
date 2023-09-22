package 回溯;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode_95_不同的二叉搜索树II
 * @Author zxf
 * @Date 2023/8/25 9:33
 * @Questinon Describrition
 **/
public class leetcode_95_不同的二叉搜索树II {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return dfs(1,n);
    }

    private List<TreeNode> dfs(int start,int end){
        ArrayList<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }

        for(int i = start;i<=end;i++){

            List<TreeNode> lefts = dfs(start,i-1);
            List<TreeNode> rights = dfs(i+1,end);

            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
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
