package 二叉树;

/**
 * @ClassName leetcode_938_二叉搜索树的范围和
 * @Author zxf
 * @Date 2023/1/12 9:24
 **/
public class leetcode_938_二叉搜索树的范围和 {

    int res = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return -1;
        }
        if(root.val > low){
            rangeSumBST(root.left,low,high);
        }

        if(root.val >= low){
            res += root.val;
        }
        if(root.val < high){
            rangeSumBST(root.right,low,high);
        }
        return res;
    }
}
