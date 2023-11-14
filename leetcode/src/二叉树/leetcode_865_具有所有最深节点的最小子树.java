package 二叉树;

/**
 * @ClassName leetcode_865_具有所有最深节点的最小子树
 * @Author zxf
 * @Date 2023/11/14 11:51
 * @Questinon Describrition
 **/
public class leetcode_865_具有所有最深节点的最小子树 {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return f(root).getKey();
    }

    private class Pair<T,Y>{
        T t;
        Y y;

        public Pair(){}

        public Pair(T t,Y y){
            this.t = t;
            this.y = y;
        }


        public T getKey(){
            return t;
        }

        public Y getValue(){
            return y;
        }
    }
    private Pair<TreeNode, Integer> f(TreeNode root) {
        if (root == null) {
            return new Pair<>(root, 0);
        }

        Pair<TreeNode, Integer> left = f(root.left);
        Pair<TreeNode, Integer> right = f(root.right);

        //返回深一点的子节点
        if (left.getValue() > right.getValue()) {
            return new Pair<>(left.getKey(), left.getValue() + 1);
        }
        if (left.getValue() < right.getValue()) {
            return new Pair<>(right.getKey(), right.getValue() + 1);
        }
        return new Pair<>(root, left.getValue() + 1);
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/lowest-common-ancestor-of-deepest-leaves/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
