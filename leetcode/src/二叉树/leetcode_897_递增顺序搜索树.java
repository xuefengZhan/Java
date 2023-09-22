package 二叉树;

import com.sun.source.tree.Tree;

/**
 * @ClassName leetcode_897_递增顺序搜索树
 * @Author zxf
 * @Date 2023/1/11 20:09
 **/
public class leetcode_897_递增顺序搜索树 {

//    TreeNode newHead = new TreeNode(-1);
//    TreeNode prev = null;
//    public TreeNode increasingBST(TreeNode root) {
//        if(root == null) return null;
//
//        dfs(root);
//
//        return newHead.right;
//    }
//
//
//    private void dfs(TreeNode root){
//        if(root == null) return;
//
//        dfs(root.left);
//
//        if(prev == null){
//            prev = root;
//            newHead.right = prev;
//        }else{
//            prev.right = root;
//            root.left = null;
//            prev = root;
//        }
//
//        dfs(root.right);
//
//    }

//    public TreeNode increasingBST(TreeNode root) {
//        if(root == null) return null;
//
//        TreeNode res = increasingBST(root.left);
//        root.left = null;
//
//        TreeNode cur = res;
//        if(cur == null){
//            root.right = increasingBST(root.right);
//            return root;
//        }
//
//        while(cur.right != null){
//            cur = cur.right;
//        }
//        cur.right = root;
//
//        root.right = increasingBST(root.right);
//        return res;
//    }


//    TreeNode head = new TreeNode(-1);
//    TreeNode prev = head;
//    public TreeNode increasingBST(TreeNode root) {
//        if(root == null) return null;
//
//        increasingBST(root.left);
//
//        prev.right = new TreeNode(root.val);
//        prev = prev.right;
//
//
//        increasingBST(root.right);
//        return head.right;
//    }

    TreeNode head = new TreeNode(-1);
    TreeNode prev = head;
    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return head.right;
    }

    private void dfs(TreeNode node){
        if(node == null) return;

        dfs(node.left);
        prev.right = node;
        node.left = null;
        prev = prev.right;
        dfs(node.right);
    }
}
