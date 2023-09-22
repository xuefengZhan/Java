package 二叉树;

/**
 * @ClassName leetcode_114_二叉树展开为链表
 * @Author zxf
 * @Date 2023/2/6 10:53
 **/
public class leetcode_114_二叉树展开为链表 {


    public void flatten(TreeNode root) {
        TreeNode cur = root;

        while(cur != null){
            TreeNode right = cur.right;
            TreeNode next = cur.left;
            TreeNode prev = findPrev(cur);

            if(prev != null){
                prev.right = right;
                cur.left = null;
                cur.right = next;
            }

            cur = cur.right;
        }
    }

    private TreeNode findPrev(TreeNode node){
        if(node.left == null) return null;

        TreeNode cur = node.left;
        while(cur.right != null){
            cur = cur.right;
        }

        return cur;
    }
}
