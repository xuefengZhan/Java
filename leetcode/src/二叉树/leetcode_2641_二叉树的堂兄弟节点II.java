package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName leetcode_2641_二叉树的堂兄弟节点II
 * @Author zxf
 * @Date 2024/1/23 11:23
 * @Questinon Describrition
 **/
public class leetcode_2641_二叉树的堂兄弟节点II {

    //数组装每层的和
    ArrayList<Integer> arr = new ArrayList<>();

    public TreeNode replaceValueInTree(TreeNode root) {
        if(root == null) return null;
        root.val = 0;
        //初始化arr数组
        bfs(root);

        dfs(root,0);
        return root;
    }


    /**
     * 功能：将当前节点的自己点的值修改掉
     * @param node  当前节点
     * @param deepth 当前节点深度
     */
    private void dfs(TreeNode node,int deepth){
        if(node==null || deepth >= arr.size() - 1) return;

        Integer sum = arr.get(deepth+1);
        int left = 0;
        int right = 0;

        if(node.left != null){
            left = node.left.val;
        }
        if(node.right != null){
            right = node.right.val;
        }

        if(node.left != null){
            node.left.val = sum - left - right;
        }
        if(node.right != null){
            node.right.val = sum - left - right;
        }

        dfs(node.left,deepth+1);
        dfs(node.right,deepth+1);
    }

    private void bfs(TreeNode node){

        int levelSize = 1;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(node);

        while(! que.isEmpty()){
            int sum = 0;
            for (; levelSize > 0 ; levelSize--) {
                TreeNode poll = que.poll();
                sum += poll.val;

                if(poll.left != null){
                    que.offer(poll.left);
                }

                if(poll.right != null){
                    que.offer(poll.right);
                }
            }
            levelSize = que.size();
            arr.add(sum);
        }
    }
}
