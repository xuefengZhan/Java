package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode_94_二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();//第二次访问
                res.add(cur.val);
                // 第二次访问 左边都访问过了 此时右转
                cur = cur.right;
            }

        }

        return res;
    }
}
