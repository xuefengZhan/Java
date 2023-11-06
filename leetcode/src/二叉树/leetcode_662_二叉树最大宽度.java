package 二叉树;

import 二叉树.TreeNode;

import java.util.*;

/**
 * @ClassName leetcode_662_二叉树最大宽度
 * @Author zxf
 * @Date 2023/10/7 14:45
 * @Questinon Describrition
 *
 * 优化思路，能够仅用 int 即 ac
 * ① 找到本层第一个有子节点的节点的index，记为first
 * ② 向下一层传坐标index时，以first为起点，先减去first再执行 *2 或 *2 +1 操作
 **/
public class leetcode_662_二叉树最大宽度 {
    public int widthOfBinaryTree(TreeNode root) {

        int res = 0;

        // key 是节点
        // value是索引
        Map<TreeNode,Integer> map = new HashMap<>();

        List<TreeNode> que = new LinkedList<>();

        map.put(root,0);
        que.add(root);




        while(! que.isEmpty() ){

            List<TreeNode> line = new LinkedList<>();

            for (TreeNode poll : que) {
                int index = map.get(poll);


                if(poll.left != null){
                    map.put(poll.left,2 * index);
                    line.add(poll.left);
                }

                if(poll.right != null){
                    map.put(poll.right,2 * index + 1);
                    line.add(poll.right);
                }

            }

            res = Math.max(res, map.get( que.get(que.size()-1) ) - map.get(que.get(0)) + 1);
            que = line;
        }

        return res;
    }
}
