package 二叉树;

/**
 * @ClassName leetcode_450_删除二叉搜索树中的节点
 * @Author zxf
 * @Date 2023/6/19 18:06
 *
 * mid
 *
 * 考察BST的delete
 **/
public class leetcode_450_删除二叉搜索树中的节点 {

//    /**
//     * 递归解法  100%
//     * @param root
//     * @param key
//     * @return
//     */
//
//    public TreeNode deleteNode(TreeNode root, int key) {
//        if(root == null) return null;
//
//        if(root.val == key){
//          if(root.left == null) return root.right;
//          if(root.right == null) return root.left;
//
//          TreeNode t = root.left;
//          while(t.right != null){
//              t= t.right;
//          }
//          //t.right = null
//          t.right = root.right;
//          return root.left;
//        }if(root.val > key){
//            root.left = deleteNode(root.left,key);
//        }else{
//            root.right = deleteNode(root.right,key);
//        }
//        return root;
//    }


    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;


        if(root.val > key){
            root.left = deleteNode(root.left,key);
        }else if(root.val < key){
            root.right = deleteNode(root.right,key);
        }else{
            TreeNode del = root;
            //度为1 或者 0
            if(del.left == null || del.right == null){
                return del.left == null ? del.right : del.left;
            }
            //度为2
            //1.找到前继节点
            del = del.left;
            while(del.right != null){
                del = del.right;
            }
            //2.值替换
            root.val = del.val;

            //3.删除del
            deleteNode(del,del.val);

            return root;

        }
        //没有一个等于key的
        return root;
    }
}
