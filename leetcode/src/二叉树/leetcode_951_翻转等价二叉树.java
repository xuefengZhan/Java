package 二叉树;

/**
 * @ClassName leetcode_951_翻转等价二叉树
 * @Author zxf
 * @Date 2023/10/23 19:52
 * @Questinon Describrition
 *
 * 0ms
 **/
public class leetcode_951_翻转等价二叉树 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;

        boolean equal1 = equal(root1.left,root2.left) && equal(root1.right, root2.right);
        boolean equal2 =  equal(root1.right,root2.left) && equal(root1.left,root2.right);

        if(equal1){
            return flipEquiv(root1.left,root2.left) && flipEquiv(root1.right,root2.right);
        }else if(equal2){
            return flipEquiv(root1.right,root2.left) && flipEquiv(root1.left,root2.right);
        }

        return false;

    }

    //判断两个节点是否相等
    private boolean equal(TreeNode node1,TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        return node1.val == node2.val;
    }
}
