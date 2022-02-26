package 数组;

/**
 * https://leetcode-cn.com/problems/find-center-of-star-graph/
 *
 * easy
 */

public class No1791_找出星型图的中心节点 {
    public int findCenter(int[][] edges) {
        int res = edges[0][0];
        return res == edges[1][0] ? res : edges[1][1];
    }
}
