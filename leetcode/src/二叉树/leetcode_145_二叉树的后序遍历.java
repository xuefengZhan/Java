package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode_145_二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        LinkedList<TreeNode> stack = new LinkedList<>();


        TreeNode cur = root;
        TreeNode lastPop = null;
        while(cur != null || ! stack.isEmpty()){

            if(cur != null){
                //第一次访问
                stack.push(cur);
                cur = cur.left;
            }else{

                TreeNode peek = stack.peek();
                if(peek.right == null || lastPop == peek.right){
                    TreeNode pop = stack.pop();
                    res.add(pop.val);
                    lastPop = pop;
                    cur = stack.peek();
                }else{
                    cur = peek.right;
                }
            }
        }
        return res;
    }
}
