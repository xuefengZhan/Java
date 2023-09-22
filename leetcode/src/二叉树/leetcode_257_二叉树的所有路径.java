package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class leetcode_257_二叉树的所有路径 {
    List<String> res = new ArrayList();
    public List<String> binaryTreePaths(TreeNode root) {

        if(root == null) return res;

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        dfs(sb,root);
        return res;
    }


    private void dfs(StringBuilder sb,TreeNode root){
        if(root.left == null && root.right == null){
            res.add(sb.toString());
            return;
        }
        int len = sb.length();
        if(root.left != null){
            sb.append("->").append(root.left.val);
            dfs(sb,root.left);
            sb.delete(len,sb.length());
        }

        if(root.right != null){
            sb.append("->").append(root.right.val);
            dfs(sb,root.right);
            sb.delete(len,sb.length());
        }
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("abcdefg");
        sb.delete(sb.length()-3,sb.length());
        System.out.println(sb);
    }
}
