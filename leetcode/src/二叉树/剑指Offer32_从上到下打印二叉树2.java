package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * easy
 */
public class 剑指Offer32_从上到下打印二叉树2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList();
        if(root == null) return res;

        LinkedList<TreeNode> que = new LinkedList<>();
        que.offer(root);

        int levelSize = 1;

        ArrayList<Integer> line = new ArrayList<>();
        while(!que.isEmpty()){
            TreeNode poll = que.poll();
            line.add(poll.val);

            if(poll.left != null){
                que.offer(poll.left);
            }

            if(poll.right != null){
                que.offer(poll.right);
            }

            if(--levelSize == 0){
                levelSize = que.size();
                res.add(line);
                line = new ArrayList<>();
            }
        }

        return res;
    }
}
