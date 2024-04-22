package 二叉树;

import java.util.Arrays;

/**
 * @ClassName leetcode_2049_统计最高分的节点数目
 * @Author zxf
 * @Date 2024/1/16 11:53
 * @Questinon Describrition
 **/
public class leetcode_2049_统计最高分的节点数目 {

    int total;

    TreeNode[] tree ;
    int res = 0;
    long max = 0;

    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;


        tree = new TreeNode[n];

        //构建二叉树
        tree[0] = new TreeNode(0);
        for (int i = 1; i < parents.length; i++) {

            //当前节点
            if(tree[i] == null){
                tree[i] = new TreeNode(i);
            }
            TreeNode node = tree[i];

            //获取父节点 将当前节点挂在父节点下
            if(tree[parents[i]] == null){
                tree[parents[i]] = new TreeNode(parents[i]);
            }

            if(tree[parents[i]].left == null){
                tree[parents[i]].left = node;
            }else{
                tree[parents[i]].right = node;
            }
        }

        //构建好二叉树 dfs 给arr数组进行初始化
        total = n;

        dfs(tree[0]);

        return res;
    }


    private int dfs(TreeNode node){
        if(node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        int farther = total - 1 - left - right;


        long tmp = (long) Math.max(1,farther) * Math.max(1,left) * Math.max(1,right);  //注意这里一定要手动向上转型！！  耽误太多验证时间
        if(tmp > max){

            max = tmp;
            res = 1;
        }else if (tmp == max){

            res++;
        }

        return left+right+1;
    }
}
