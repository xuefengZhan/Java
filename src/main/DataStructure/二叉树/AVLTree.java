package 二叉树;

import 二叉树.BinaryTreePrinter.src.com.mj.printer.BinaryTrees;

import java.util.Comparator;

public class AVLTree<E> extends BinarySearchTree<E> {

    public AVLTree() {
    }

    public AVLTree(Comparator comparator) {
        super(comparator);
    }

    private static class AVLNode<E> extends Node<E> {
        private int height = 1; //默认为1，因为平衡因子判断左右子节点height差为2 如果为0有歧义

        public AVLNode() {
        }

        public AVLNode(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public int balanceFactor() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>) left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>) right).height;
            return Math.abs(leftHeight - rightHeight);
        }

        public void updateHeight() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>) left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>) right).height;
            height = Math.max(leftHeight,rightHeight) + 1;
        }

        public Node<E> tallerChild() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>) left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>) right).height;

            return leftHeight > rightHeight ? left : right;
        }

    }

    private boolean isBalance(Node<E> node) {
        return ((AVLNode<E>) node).balanceFactor() < 2;
    }

    private void updateHeight(Node<E> node) {
        ((AVLNode<E>) node).updateHeight();
    }

    private Node<E> tallerChild(Node<E> node) {
        return ((AVLNode<E>) node).tallerChild();
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new AVLNode<E>(element, parent);
    }

    private void rotateRight(Node<E> grand) {
        Node<E> parent = grand.left;
        Node<E> t3 = parent.right;
        //Node<E> father = grand.parent;

        parent.right = grand;
        //grand.parent = parent;

        grand.left = t3;
        // t3.parent = grand;

        // parent.parent = father;
        //if(father == null){
        root = parent;
        //}else{
        //    if(grand == father.left){
        //        father.left = parent;
        //    }else{
        //        father.right = parent;
        //    }
        //}
        switchFather(grand, t3, parent);
    }

    private void rotateLeft(Node<E> grand) {
        Node<E> parent = grand.right;
        Node<E> t2 = parent.left;
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

    private void switchFather(Node<E> grand, Node<E> t, Node<E> parent) {
        Node<E> father = grand.parent;
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

    protected void rebalance(Node<E> grand) {
        Node<E> parent = ((AVLNode<E>) grand).tallerChild();
        Node<E> node = ((AVLNode<E>) parent).tallerChild();


        if (parent == grand.left) {//L
            if (node == parent.left) {//LL
                rotateRight(grand);
            } else {//LR
                rotateLeft(parent);
                rotateRight(grand);
            }
        } else {//R
            if (node == parent.left) {//RL
                rotateRight(parent);
                rotateLeft(grand);
            } else {//RR
                rotateLeft(grand);
            }
        }
    }


    @Override
    protected void afterAdd(Node<E> node) {
        Node<E> parent = node.parent;
        while (parent != null) {
            if (isBalance(parent)) {
                updateHeight(parent);
                parent = parent.parent;
            } else {
                rebalance(parent);
                break;
            }
        }
    }
}

class Test2{
    public static void main(String[] args) {
        AVLTree<Integer> avlt = new AVLTree<>();
        //avlt.add()
        avlt.add(35);
        avlt.add(37);
        avlt.add(34);
        avlt.add(56);
        avlt.add(25);
        avlt.add(62);
        avlt.add(57);
        avlt.add(9);
        avlt.add(74);
        avlt.add(32);
        avlt.add(94);
        avlt.add(80);
        avlt.add(75);
        avlt.add(100);
        avlt.add(16);
        avlt.add(82);
        BinaryTrees.println(avlt);
    }
}
