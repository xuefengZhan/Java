package DataStructure.二叉树;

import java.util.Comparator;

public class BinarySearchTree<E> extends BinaryTree<E> {
    protected Comparator<E> comparator;

    public BinarySearchTree(){}
    public BinarySearchTree(Comparator<E> comparator){
        this.comparator = comparator;
    }

    protected int compare(E e1, E e2) {
        if (comparator == null) {
            return ((Comparable<E>) e1).compareTo(e2);
        } else {
            return comparator.compare(e1, e2);
        }
    }


    protected Node<E> createNode(E element,Node<E> parent){ return new Node<E>(element,parent);}
    protected void afterAdd(Node<E> node){}
    protected void afterRemove(Node<E> node,Node<E> child){}

    public void add(E element) {
        elementNotNullCheck(element);
        if (root == null) {
            root = createNode(element,null);
            afterAdd(root);
            size++;
            return;
        }

        Node<E> cur = root;
        Node<E> parent = null;
        int cmp = 0;
        while (cur != null) {
            cmp = compare(element, cur.element);
            parent = cur;
            if (cmp > 0) {
                cur = cur.right;
            } else if (cmp < 0) {
                cur = cur.left;
            } else {
                cur.element = element;
                return;
            }
        }
        //cur == null
        Node<E> newNode = createNode(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left =  newNode;
        }

        afterAdd(newNode);
        size++;
    }


    //todo 删除
    // todo delete  1.根据值找到节点
    private Node<E> node(E element){
        elementNotNullCheck(element);
        Node<E> cur = root;
        while(cur != null){
            int cmp = compare(element,cur.element);
            if(cmp > 0){
                cur = cur.right;
            }else if(cmp < 0){
                cur = cur.left;
            }else{
                return cur;
            }
        }
        return null;
    }


    public void remove(E element) {
        Node<E> node = node(element);
        if(node == null) return;
        Node<E> remove;
        if(node.hasTwoChild()){
            remove = processor(node);
            node.element = remove.element;
        }else{
            remove = node;
        }

        //remove 度为1 or 0
        Node<E> child = remove.left == null? remove.right : remove.left;

        if(child != null){
            //remove 度为1
            child.parent = remove.parent;
        }
        if(remove.parent == null){
            root = child;
        }else{
            if(remove == remove.parent.left){
                remove.parent.left = child;
            }else{
                remove.parent.right = child;
            }
        }
        //注意删除节点  remove.parent.left or right = child  但是remove.parent 仍然指向parent
        afterRemove(remove,child);
        size--;
    }

    public boolean contains(E element){
        return node(element) != null;
    }



    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
//        bst.add(8);
//        bst.add(4);
//        bst.add(2);
//        bst.add(1);
//        bst.add(3);
//        bst.add(6);
//        bst.add(5);
//        bst.add(7);
//        bst.add(13);
//        bst.add(10);
//        bst.add(9);
//        bst.add(12);
//        bst.add(11);
//        bst.add(15);
//        bst.add(14);
//
//        BinaryTrees.println(bst);
//        System.out.println(bst.height());
//
//        bst.remove(11);
//        BinaryTrees.println(bst);
//
//        System.out.println(bst.height());
//        System.out.println(bst.isComplete());

        bst.add(6);
        bst.add(4);
        bst.add(7);
        bst.add(5);
        bst.add(2);
        bst.add(3);
        bst.add(1);

        bst.preorderTraversal2(new BinaryTree.Visitor<Integer>() {
            @Override
            public void visit(Integer element) {
                System.out.println(element);
            }
        });

        bst.inorderTraversal2(new BinaryTree.Visitor<Integer>() {
            @Override
            public void visit(Integer element) {
                System.out.println(element);
            }
        });



    }
}

