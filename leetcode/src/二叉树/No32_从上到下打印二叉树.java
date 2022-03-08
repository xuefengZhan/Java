package 二叉树;


import java.util.ArrayList;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 *
 * mid
 * 97.67%
 */
public class No32_从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[]{};

        LinkedList<TreeNode> que = new LinkedList<>();

        que.offer(root);

        ArrayList<Integer> res =  new ArrayList<>();

        while(!que.isEmpty()){
            TreeNode poll = que.poll();
            res.add(poll.val);

            if(poll.left != null){
                que.offer(poll.left);
            }
            if(poll.right != null){
                que.offer(poll.right);
            }


        }

        int[] res1 = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            res1[i] = res.get(i);
        }

        return res1;
    }
}
