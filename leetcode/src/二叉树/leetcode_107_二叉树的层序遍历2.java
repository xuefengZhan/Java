package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName leetcode_107_二叉树的层序遍历2
 * @Author zxf
 * @Date 2023/2/6 18:04
 **/
public class leetcode_107_二叉树的层序遍历2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        LinkedList<TreeNode> que = new LinkedList<>();
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

        que.offer(root);
        int levelSize = 1;
        ArrayList<Integer> list;
        while(! que.isEmpty()){
            list = new ArrayList<>();
            while(levelSize > 0){
                TreeNode poll = que.poll();
                list.add(poll.val);


                if(poll.left != null){
                    que.offer(poll.left);
                }

                if(poll.right != null){
                    que.offer(poll.right);
                }

                levelSize--;
            }

            if(levelSize == 0){
                levelSize = que.size();
                res.add(0,list);
            }
        }

        return res;
    }
}
