package DataStructure.二叉树;

public class RBTree<E> extends BalancedBinarySearchTree<E> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private static class RBNode<E> extends Node<E> {


        private boolean color = RED;

        public RBNode() {
        }

        public RBNode(E element, Node<E> parent) {
            super(element, parent);
        }

        @Override
        public String toString() {
            String str = color == RED ? "R_" : "";
            return str + element.toString();
        }
    }

    private Node<E> color(Node<E> node, boolean color) {
        if (node == null) return node;
        ((RBNode<E>) node).color = color;
        return node;
    }

    private Node<E> red(Node<E> node) {
        return color(node, RED);
    }

    private Node<E> black(Node<E> node) {
        return color(node, BLACK);
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new RBNode<>(element, parent);
    }

    private boolean colorOf(Node<E> node) {
        if (node == null) return BLACK;//空节点在红黑树中往往是叶子结点，因此返回黑色
        return ((RBNode<E>) node).color;
    }


    private boolean isBlack(Node<E> node) {
        return colorOf(node) == BLACK;
    }

    private boolean isRed(Node<E> node) {
        return colorOf(node) == RED;
    }


    @Override
    protected void afterAdd(Node<E> node) {
        Node<E> parent = node.parent;
        if (parent == null) {
            black(node);
            return;
        }
        //4种情况
        if (isBlack(parent)) {
            return;
        }
        // R<-B->R 上溢
        Node<E> uncle = parent.sibling();
        Node<E> grand = parent.parent;
        if (isRed(uncle)) {
            Node<E> redGrand = red(grand);
            black(parent);
            black(uncle);
            afterAdd(redGrand);
            return;
        }

        // R<-B  或者 B->R
        if (parent.isLeftChild()) {
            if (node.isLeftChild()) {
                //LL
                black(parent);
                red(grand);
                rotateRight(grand);
            } else {
                //LR
                black(node);
                red(grand);
                rotateLeft(parent);
                rotateRight(grand);
            }
        } else {
            if (node.isRightChild()) {
                //RR
                red(grand);
                black(parent);
                rotateLeft(grand);
            } else {
                //RL
                black(node);
                red(grand);
                rotateRight(parent);
                rotateLeft(grand);
            }
        }

    }

    @Override
    protected void afterRemove(Node<E> node, Node<E> child) {
        //5
        if (isRed(node)) {
            return;
        }
        //2
        if (isRed(child)) {
            black(child);
            return;
        }
        Node<E> parent = node.parent;
        if (parent == null) {
            return;
        }
        boolean isLeft = parent.left == null;
        Node<E> brother = isLeft ? parent.right:parent.left;

        if(isLeft){
            if(isRed(brother)){
                rotateLeft(parent);
                black(brother);
                red(parent);
                brother = parent.right;
            }
            if(isBlack(brother.right) && isBlack(brother.left)){
                boolean colorOfParent = colorOf(parent);
                black(parent);
                red(brother);
                if(colorOfParent == BLACK){
                    afterRemove(parent,null);
                }
            }else{
                if(isBlack(brother.right)){
                    rotateRight(brother);
                    brother = brother.parent;
                }
                rotateLeft(parent);
                color(brother,colorOf(parent));
                black(parent);
            }
        }else{
            if(isRed(brother)){
                rotateRight(parent);
                black(brother);
                red(parent);
                brother = parent.left;
            }
            if(isBlack(brother.left) && isBlack(brother.right)){
                boolean colorOfParent = colorOf(parent);
                black(parent);
                red(brother);
                if(colorOfParent == BLACK){
                    afterRemove(parent,null);
                }
            }else{
                if(isBlack(brother.left)){
                    rotateLeft(brother);
                    brother = brother.parent;
                }
                rotateRight(parent);
                color(brother,colorOf(parent));
                black(parent);
            }
        }



    }

}

//class Test {
//    public static void main(String[] args) {
//        Integer data[] = new Integer[]{
//                55, 87, 56, 74, 96, 22, 62, 20, 70, 68, 90, 50
//        };
//
//        RBTree<Integer> rb = new RBTree();
//
//        for (int i = 0; i < data.length; i++) {
//            rb.add(data[i]);
//        }
//        BinaryTrees.println(rb);
//
//
//        for (int i = 0; i < data.length; i++) {
//            rb.remove(data[i]);
//            System.out.println("[" + data[i] + "]");
//            BinaryTrees.println(rb);
//        }
//
//
//    }
//}