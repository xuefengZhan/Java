package 二叉树;

/**
 * @ClassName leetcode_2673_使二叉树所有路径值相等的最小代价
 * @Author zxf
 * @Date 2024/1/23 14:28
 * @Questinon Describrition
 **/
public class leetcode_2673_使二叉树所有路径值相等的最小代价 {
    int res = 0;
    int[] cost;
    public int minIncrements(int n,  int[] cost) {
        this.cost = cost;
        dfs(1);
        return res;
    }


    //返回让节点i为根节点的时候 路径和
    private int dfs(int i){

        //如果是叶子结点
        if(2*i >= cost.length) return cost[i-1];

        int left = dfs(2*i);
        int right = dfs(2*i+1);

        res += Math.abs(right - left);

        return Math.max(left,right) + cost[i-1];

    }
}
