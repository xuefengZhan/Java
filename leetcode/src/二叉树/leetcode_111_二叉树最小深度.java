package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_111_二叉树最小深度 {
    public int minDepth(TreeNode root) {

        if(root == null) return 0;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int levelSize = 1;
        int height = 1;

        while(! que.isEmpty()){
            TreeNode poll = que.poll();


            if(poll.left == null && poll.right == null){
                return height;
            }

            if(poll.left != null){
                que.offer(poll.left);
            }

            if(poll.right != null){
                que.offer(poll.right);
            }

            //层遍历完了 上高度
            if(--levelSize == 0){
                levelSize = que.size();
                height ++;
            }

        }

        return height;

    }
}
