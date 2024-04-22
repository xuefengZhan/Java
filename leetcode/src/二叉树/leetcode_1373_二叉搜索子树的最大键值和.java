package 二叉树;

/**
 * @ClassName leetcode_1373_二叉搜索子树的最大键值和
 * @Author zxf
 * @Date 2024/1/8 13:41
 * @Questinon Describrition
 *
 * hard
 **/
public class leetcode_1373_二叉搜索子树的最大键值和 {
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return res;
    }

    int res = 0;

    /**
     *
     * @param node 当前节点
     * @return 4元素数组
     *          第一位存储 是否是BST
     *          第二位存当前BST的和  null和非BST则为0
     *          第三位是当前子树最小值
     *          第四位是当前子树最大值
     */
    private int[] dfs(TreeNode node){

        //这里初始化一定要注意 null节点返回的最大最小值是反的
        if(node == null) return new int[]{1, 0,Integer.MAX_VALUE,Integer.MIN_VALUE};

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        //左右都符合BST 还需要判断当前是否符合BST
        if(left[0] == 1 && right[0] == 1){

            int max = right[2];   //右子树的最小值
            int min = left[3];    //左子树的最大值

            //针对非叶子节点来说 下面这个判断当前节点是否符合BST是对的
            //但是考虑到叶子节点左右都是null，因此在初始化ndoe == null的时候，要注意上面的返回值 左子树的最大值和右子树的最小值是反的
            //对于不符合BST的节点 只要返回标识就够了 0标识不是BST
            if(node.val >= max || node.val <= min) {
                return new int[]{0};
            }else{
                //当前也符合BST
                int cur  = left[1] + right[1] + node.val;
                res = Math.max(cur,res);

                //注意 这里叶子节点需要更新最大最小值 不需要管这个节点是左还是右  父节点在调用的时候 会自动选择2还是3 那么另一个值就不重要了
                if(node.left == null && node.right == null){
                    return new int[]{1,cur,node.val,node.val};
                }
                //如果不是叶子节点 且 左右子节点都部位空 则继承左右子树的最值  因为当前节点必定 > 左子树 最大值  ， < 右子树最小值
                //如果不是叶子节点 且 左右子节点有一个为空 则继承左右子树的最值  因为当前节点必定 > 左子树 最大值  ， < 右子树最小值
                return new int[]{1,cur,Math.min(left[2],node.val),Math.max(right[3],node.val)};
            }
        }

        return new int[]{0};
    }
}
