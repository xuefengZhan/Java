package 二叉树;

import java.util.*;

/**
 * @ClassName leetcode_894_所有可能的真二叉树
 * @Author zxf
 * @Date 2023/11/15 9:11
 * @Questinon Describrition
 **/
public class leetcode_894_所有可能的真二叉树 {


    Map<Integer,List<TreeNode>> map = new HashMap();
    public List<TreeNode> allPossibleFBT(int n) {
        ArrayList<TreeNode> res = new ArrayList<>();
        if(n % 2 == 0) return res;

        if(n == 1){
            res.add(new TreeNode(0));
            return res;
        }

        if(map.get(n) != null){
            return map.get(n);
        }

        // i 是左子树的节点数
        for (int i = 1; i < n-1; i+=2) {
            List<TreeNode> lefts = allPossibleFBT(i);
            List<TreeNode> rights = allPossibleFBT(n-1-i);

            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }

        map.put(n,res);
        return res;
    }
}
