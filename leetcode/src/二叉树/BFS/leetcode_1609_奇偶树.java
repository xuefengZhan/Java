package 二叉树.BFS;

import 二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName leetcode_1609_奇偶树
 * @Author zxf
 * @Date 2024/1/10 11:04
 * @Questinon Describrition
 **/
public class leetcode_1609_奇偶树 {
    public boolean isEvenOddTree(TreeNode root) {

        if(root == null || (root.val & 1) == 0) return false;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        boolean odd = false;
        int levelSize = 1;

        TreeNode prev = null;
        while(! que.isEmpty()){

            levelSize = que.size();
            prev = null;

            while(levelSize > 0){
                TreeNode poll = que.poll();
                levelSize--;
                //检查是否符合单调规则  检查是否符合奇偶性
                if(!check(poll,prev,odd)){
                    return false;
                }

                prev = poll;
                if(poll.left != null){
                    que.offer(poll.left);
                }

                if(poll.right != null){
                    que.offer(poll.right);
                }
            }

            //levelSize == 0
            odd = !odd;
            System.out.println("\n==========");
        }

        return true;
    }


    private boolean check(TreeNode cur,TreeNode prev,boolean odd){
        //奇数层
        if(odd){
            //如果前一个节点不为null 就必须大于当前节点
            if(prev != null){
                if(prev.val <= cur.val) return false;
            }
            //是否符合奇偶
            return (cur.val & 1) == 0;
        }else{
            //如果前一个节点不为null 就必须小于当前节点
            if(prev != null){
                if(prev.val >= cur.val) return false;
            }
            //是否符合奇偶
            return (cur.val & 1) == 1;
        }
    }
}
