package Tree;

import java.util.Comparator;

public class _02_BinaryTree<E> extends _01_tree<E>{
    private Comparator<E> comparator;
    public _02_BinaryTree(){
        this(null);
    }
    public _02_BinaryTree(Comparator comparator){
        this.comparator = comparator;
    }

    private int compare(E e1,E e2 ){
        if(comparator == null){
            return ((Comparable<E>)e1).compareTo(e2);
        }else{
           return  comparator.compare(e1,e2);
        }
    }

    @Override
    public void add(E element) {
        if(element == null) throw new RuntimeException("Element is null");

        if(root == null){
            root = new Node(element,null);
            size++;
            return;
        }

        Node<E> current = root;
        Node<E> parent = null;
        int cmp = 0;
        while(current != null){
            parent = current;
            cmp = compare(current.element,element);
            if(cmp > 0){
                current = current.left;
            }else if(cmp < 0){
                current = current.right;
            }else{
                return;
            }
        }
        if(cmp>0){
            parent.left = new Node(element,parent);
        }else{
            parent.right = new Node(element,parent);
        }
        size++;
    }

    //todo 前序遍历
    public void PreorderTraversal(){
        PreorderTraversal(root);
    }
    private void PreorderTraversal(Node<E> node){
        if(node == null) return;
        System.out.println(node);
        PreorderTraversal(node.left);
        PreorderTraversal(node.right);
    }

    @Override
    public void remove(E element) {

    }

    @Override
    public boolean contains(Object element) {
        return false;
    }
}
