package 二叉树;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * @ClassName leetcode_2415_反转二叉树的奇数层
 * @Author zxf
 * @Date 2024/1/22 16:51
 * @Questinon Describrition
 **/
public class leetcode_2415_反转二叉树的奇数层 {
    public TreeNode reverseOddLevels(TreeNode root) {

        if(root == null) return null;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        int levelSize = 1;
        int level = 0;

        while(! que.isEmpty()){
            //用于存储上一层
            ArrayList<TreeNode> arr = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = que.poll();

                arr.add(poll);

                if(poll.left != null){
                    que.offer(poll.left);
                }
                if(poll.right != null){
                    que.offer(poll.right);
                }
            }

            //换值不还索引
            if((level & 1) == 1){
                for(int l = 0,r = arr.size() - 1;l < r;l++,r--){
                    int tmp = arr.get(l).val;
                    arr.get(l).val = arr.get(r).val;
                    arr.get(r).val = tmp;
                }
            }
            levelSize = que.size();
            level++;

        }

        return root;
    }
}
