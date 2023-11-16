package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2023/11/16 1:13
 * @Author 詹学丰
 * @Name leetcode_971_翻转二叉树以匹配先序遍历
 * @QUESTION DESCRIPTION
 * @TAG
 * @RESULT
 *
 * 本题和297题类似
 **/

public class leetcode_971_翻转二叉树以匹配先序遍历 {
    int i = 0;
    List<Integer> res = new ArrayList<>();
    boolean stop = false;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        dfs(root,voyage);
        return res;
    }



    private void dfs(TreeNode node , int[] voyage){
        if(i == voyage.length || node == null || stop) return;

        if( node.val != voyage[i++]){
            res = new ArrayList<>();
            res.add(-1);
            stop = true;
            return;
        }



        //这段也是对的
        if(node.left != null){
            if(node.left.val != voyage[i]){
                res.add(node.val);
                dfs(node.right,voyage);
                dfs(node.left,voyage);
            }else{
                dfs(node.left,voyage);
                dfs(node.right,voyage);
            }
        }else{
            //node.left == null
            dfs(node.right,voyage);
        }


        //这段也是对的
//        if(node.left != null && node.left.val != voyage[i]){
//                res.add(node.val);
//                dfs(node.right,voyage);
//                dfs(node.left,voyage);
//        }else{
//            //node.left == null || node.left.val == voyage[i]
//                dfs(node.left,voyage);
//                dfs(node.right,voyage);
//        }
    }
}
