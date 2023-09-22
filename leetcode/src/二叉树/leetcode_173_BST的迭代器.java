package 二叉树;

import java.util.LinkedList;

/**
 * @ClassName leetcode_173_BST的迭代器
 * @Author zxf
 * @Date 2023/2/6 13:08
 **/
public class leetcode_173_BST的迭代器 {


}

class BSTIterator{
        TreeNode cur;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        public BSTIterator(TreeNode root) {
                cur = root;
        }

        public int next() {
                int res = -1;
                while(cur != null || !stack.isEmpty()){
                        if(cur != null){
                                res = cur.val;
                                stack.push(cur);
                                cur = cur.left;
                                return res;
                        }else{
                                cur = stack.pop();
                                res = cur.val;
                                return res;
                        }
                }
                return res;

        }

        public boolean hasNext() {
                return cur != null || !stack.isEmpty();
        }
}
