package 二叉树;

import java.util.Arrays;

/**
 * @ClassName leetcode_1530_好叶子节点对的数量
 * @Author zxf
 * @Date 2024/1/9 18:24
 * @Questinon Describrition
 **/
public class leetcode_1530_好叶子节点对的数量 {
    int  res = 0;
    int distiance ;
    public int countPairs(TreeNode root, int distance) {
        this.distiance = distance;
        dfs(root);
        return res;
    }


    //返回当前节点到所有叶子节点的距离
    private int[] dfs(TreeNode node){

        if(node == null) return null;

        int[] cur = new int[distiance+1];  //索引是距离  值是个数

        if(node.left == null && node.right == null){
            cur[0] = 1;
            return cur;
        }

        int[] lefts = dfs(node.left);
        int[] rights = dfs(node.right);

        //子树不为空 那么把子树的所有叶子节点维护到当前节点; 超过distance的就不要了
        if(lefts != null){
            for (int i = 0; i <  distiance; i++) {
                cur[i+1] += lefts[i];
            }
        }

        if(rights != null){
            for (int i = 0; i <  distiance; i++) {
                cur[i+1] += rights[i];
            }
        }

        //维护结果
        if(lefts != null && rights != null){
            for (int i = 0; i < lefts.length; i++) {
                for (int j = 0; j < rights.length; j++) {
                    if(lefts[i] == 0 || rights[j] == 0) continue;
                    if(i + j + 2 <= distiance) res += lefts[i] * rights[j];
                }
            }
        }

        return cur;
    }
}
