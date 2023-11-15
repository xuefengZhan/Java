package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName leetcode_958_二叉树的完全性检验
 * @Author zxf
 * @Date 2023/11/15 11:28
 * @Questinon Describrition
 *
 * 100%
 **/
public class leetcode_958_二叉树的完全性检验 {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        boolean status = false;

        while(! que.isEmpty()){
            TreeNode poll = que.poll();

            if(status && (poll.left != null || poll.right != null)) return false;

            //每个节点有四种状态
            //1. 叶子节点
            //2. 有左无右
            //后面的节点不能再有子节点
            //3. 有右无左 false
            //4. 有左有右
            if(poll.left == null && poll.right != null) return false;

            if(poll.left != null && poll.right != null){
                que.offer(poll.left);
                que.offer(poll.right);
            }else{
                //有左无右  or  叶子节点
                status = true; //
                if(poll.left != null){
                    que.offer(poll.left);
                }
            }
        }

        return true;
    }
}
