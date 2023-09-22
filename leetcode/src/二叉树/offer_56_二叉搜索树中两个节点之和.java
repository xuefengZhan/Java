package 二叉树;

import java.util.HashSet;

/**
 * @ClassName offer_56_二叉搜索树中两个节点之和
 * @Author zxf
 * @Date 2023/1/13 13:10
 **/
public class offer_56_二叉搜索树中两个节点之和 {
    HashSet<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        if(set.contains(k - root.val)) return true;

        set.add(root.val);

        return findTarget(root.left,k) || findTarget(root.right,k);
    }
}
