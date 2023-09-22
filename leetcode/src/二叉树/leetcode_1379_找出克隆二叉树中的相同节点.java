package 二叉树;

/**
 * @ClassName leetcode_1379_找出克隆二叉树中的相同节点
 * @Author zxf
 * @Date 2023/1/12 11:06
 **/
public class leetcode_1379_找出克隆二叉树中的相同节点 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null) return null;

        if(original.val == target.val){
            return cloned;
        }


        TreeNode left = getTargetCopy(original.left,cloned.left,target);
        TreeNode right = getTargetCopy(original.right,cloned.right,target);

        return left == null ? right : left;

    }
}
