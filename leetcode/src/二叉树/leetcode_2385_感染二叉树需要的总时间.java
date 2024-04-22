package 二叉树;

/**
 * @ClassName leetcode_2385_感染二叉树需要的总时间
 * @Author zxf
 * @Date 2024/1/19 17:21
 * @Questinon Describrition
 **/
public class leetcode_2385_感染二叉树需要的总时间 {

    int deepth;  // 存储目标节点的高度
    int goal;    // 目标节点的值
    int res = 0; // 经过目标节点的最长路径

    public int amountOfTime(TreeNode root, int start) {
        goal = start;
        dfs(root);
        return Math.max(deepth,res - deepth) ;
    }


    /**
     *
     * @param node
     * @param
     * @return 返回数组 0位置存储当前节点高度（叶子结点为0，这里其实也可以理解为边数） 1位置存储当前节点为根节点的树是否包含目标节点
     */
    private int[] dfs(TreeNode node){
        if(node == null) return new int[]{-1,0};

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);


        int ml = left[0];
        int mr = right[0];

        int hl = left[1];
        int hr = right[1];


        //如果遍历到了目标节点 则存储一下目标节点的高度
        if(node.val == goal){
            deepth = Math.max(mr,ml) + 1;
            return new int[]{deepth,1};
        }

        //如果左右都不存在 则返回高度 ，标记还是0
        if(hl == 1 || hr == 1){
            //如果子树中包含目标节点，更新结果值
            res = Math.max(ml+mr+2,res);
            //返回为目标节点贡献的高度值 忽略掉不包含目标节点的子树
            if(hl == 1){
                return  new int[]{ml+1, 1};
            }else {
                return new int[]{mr+1,1};
            }
        }
        return new int[]{Math.max(ml,mr) + 1,0};
    }

}
