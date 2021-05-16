package Tree;

public abstract class _01_tree<E>{
    protected int size;
    protected Node<E> root;

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void clear(){
        root = null;
    }
    public abstract void add(E element);
    public abstract void remove(E element);

    public abstract boolean contains(E element);



    protected class Node<E>{
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    '}';
        }
    }
}
