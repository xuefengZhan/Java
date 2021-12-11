package 二叉树;

import java.util.Comparator;

public abstract class BalancedBinarySearchTree<E> extends BinarySearchTree<E>{

    public BalancedBinarySearchTree() {
    }

    public BalancedBinarySearchTree(Comparator<E> comparator) {
        super(comparator);
    }

    //此类用于封装 平衡二叉树 所特有的旋转操作
    protected void rotateRight(BinaryTree.Node<E> grand) {
        BinaryTree.Node<E> parent = grand.left;
        BinaryTree.Node<E> t3 = parent.right;
        //Node<E> father = grand.parent;

        parent.right = grand;
        //grand.parent = parent;

        grand.left = t3;
        // t3.parent = grand;

        // parent.parent = father;
        //if(father == null){
        //root = parent;
        //}else{
        //    if(grand == father.left){
        //        father.left = parent;
        //    }else{
        //        father.right = parent;
        //    }
        //}
        switchFather(grand, t3, parent);
    }

    protected void rotateLeft(BinaryTree.Node<E> grand) {
        BinaryTree.Node<E> parent = grand.right;
        BinaryTree.Node<E> t2 = parent.left;
        //Node<E> father = grand.parent;

        parent.left = grand;
        //grand.parent = parent;

        grand.right = t2;
        //t2.parent = grand;

        //parent.parent = father;
        //if(father == null){
        //    root = parent;
        //}else{
        //   if(grand == father.left){
        //        father.left = parent;
        //   }else{
        //        father.right = parent;
        //    }
        // }
        switchFather(grand, t2, parent);
    }

    protected void switchFather(BinaryTree.Node<E> grand, BinaryTree.Node<E> t, BinaryTree.Node<E> parent) {
        BinaryTree.Node<E> father = grand.parent;
        grand.parent = parent;
        if(t != null){
            t.parent = grand;
        }

        parent.parent = father;
        if (father == null) {
            root = parent;
        } else {
            if (grand == father.left) {
                father.left = parent;
            } else {
                father.right = parent;
            }
        }

    }
}
