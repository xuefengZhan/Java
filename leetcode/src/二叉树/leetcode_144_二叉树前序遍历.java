package 二叉树;


import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode_144_二叉树前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        TreeNode cur = root;

        LinkedList<TreeNode> stack = new LinkedList<>();

        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                //第一次访问 直接添加
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }else{
                //第二次访问
                TreeNode pop = stack.pop();
                cur = pop.right;
            }
        }

        return res;
    }
}
