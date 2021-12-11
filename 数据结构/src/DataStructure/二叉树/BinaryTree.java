package 二叉树;

import 二叉树.BinaryTreePrinter.src.com.mj.printer.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> implements BinaryTreeInfo {
    protected Node<E> root;
    protected int size;

    protected void elementNotNullCheck(E element){
        if(element == null){
            throw new RuntimeException("Element can not be null");
        }
    }


    protected static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(){}

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean hasTwoChild(){
            return left != null && right != null;
        }

        public boolean isLeaf(){
            return left == null && right == null;
        }

        public boolean isLeftChild(){
            return parent != null && this == this.parent.left;
        }

        public boolean isRightChild(){
            return parent != null && this == this.parent.right;
        }


        public Node<E> sibling() { // 红黑树中用到, 返回兄弟节点
            if (isLeftChild()) {
                return parent.right;
            }

            if (isRightChild()) {
                return parent.left;
            }
            return null;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    protected Node<E> processor(Node<E> node){
        if(node.left != null){
            Node<E> cur = node.left;
            while(cur.right != null){
                cur = cur.right;
            }
            return cur;
        }else{
            Node<E> parent=node.parent;
            while(parent != null){
                if(node == parent.left){
                    node = parent;
                    parent = parent.parent;
                }else{
                    break;
                }
            }
            //parent == null || node = praent.right
            return parent;
        }
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }



    public interface Visitor<E>{
        void visit(E element);
    }

    /**
     * 前序遍历
     * @param node
     * @param visitor
     */
    private void preorderTraversal(Node<E> node,Visitor<E> visitor){
        if(node == null) return;
        visitor.visit(node.element);
        preorderTraversal(node.left,visitor);
        preorderTraversal(node.right,visitor);
    }
    public void preorderTraversal(Visitor<E> visitor){
        preorderTraversal(root,visitor);
    }

    /**
     * 前序遍历非递归实现
     * @param visitor
     */
    public void preorderTraversal2(Visitor<E> visitor){
        Node<E> node = root;
        if(node == null || visitor == null) return;
        LinkedList<Node<E>> stack = new LinkedList<>();
        while(true){
            if(node != null){
                visitor.visit(node.element);
                stack.push(node.right);
                node = node.left;
            }else{
                if(stack.isEmpty()) break;
                node = stack.pop();
            }
        }

    }

    /**
     * 中序遍历
     * @param node
     * @param visitor
     */
    private void inorderTraversal(Node<E> node,Visitor<E> visitor){
        if(node == null) return;
        inorderTraversal(node.left,visitor);
        visitor.visit(node.element);
        inorderTraversal(node.right,visitor);
    }
    public void inorderTraversal(Visitor<E> visitor){
        inorderTraversal(root,visitor);
    }


    /**
     * 中序遍历非递归实现
     * @param visitor
     */
    public void inorderTraversal2(Visitor<E> visitor){
        Node<E> node = root;
        if(node == null || visitor == null) return;
        LinkedList<Node<E>> stack = new LinkedList<>();

        while(true){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                if(stack.isEmpty()) break;
                node = stack.pop();
                visitor.visit(node.element);
                node = node.right;
            }
        }
    }

    /**
     * 后序遍历
     * @param node
     * @param visitor
     */
    private void postorderTraversal(Node<E> node,Visitor<E> visitor){
        if(node == null || visitor == null) return;
        postorderTraversal(node.left,visitor);
        postorderTraversal(node.right,visitor);
        visitor.visit(node.element);
    }
    public void postorderTraversal(Visitor<E> visitor){
        postorderTraversal(root,visitor);
    }

    /**
     * 后序遍历非递归实现
     * @param visitor
     */
    public void postorderTraversal2(Visitor<E> visitor){
        Node<E> node = root;
        if(node == null || visitor == null) return;
        Node<E> prev = null;
        LinkedList<Node<E>> stack = new LinkedList<>();
        while(true){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                if((node.right != null && prev == node.right) || node.right == null){
                    node = stack.pop();
                    prev = node;
                    visitor.visit(node.element);
                }else{
                    node = stack.peek();
                    node = node.right;
                }
            }
        }
    }






    public void levelOrderTranversal(Visitor<E> visitor){
        if(root == null) return;
        Queue<Node<E>> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            Node<E> poll = que.poll();
            visitor.visit(poll.element);
            if(poll.left != null){
                que.offer(poll.left);
            }
            if(poll.right != null){
                que.offer(poll.right);
            }
        }
    }


    public int height(){
        if(root == null) return 0;
        Queue<Node<E>> que = new LinkedList<>();
        que.offer(root);
        int height = 1;
        int levelSize = 1;
        while(!que.isEmpty()){
            Node<E> poll = que.poll();
             levelSize--;
            if(poll.left != null){
                que.offer(poll.left);
            }
            if(poll.right != null){
                que.offer(poll.right);
            }
            if(levelSize == 0 && (levelSize = que.size()) > 0){
                height ++ ;
            }
        }
        return height;
    }




    //todo 6.是否是完全二叉树
    public boolean isComplete(){
        if(root == null) return false;
        Queue<Node<E>> que = new LinkedList<>();
        que.offer(root);
        boolean mustBeLeaf = false;
        while(!que.isEmpty()){
            Node<E> poll = que.poll();
            if(mustBeLeaf && !poll.isLeaf()){
                return false;
            }

            if((poll.left != null && poll.right == null) || poll.isLeaf()){
                mustBeLeaf = true;
            }else if(poll.left == null && poll.right != null){
                mustBeLeaf = false;
            }

            if(poll.left != null){
                que.offer(poll.left);
            }
            if(poll.right != null){
                que.offer(poll.right);
            }
        }
        return true;
    }



    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        return node;
    }

}
