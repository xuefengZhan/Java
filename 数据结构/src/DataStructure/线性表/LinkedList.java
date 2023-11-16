package DataStructure.线性表;

public class LinkedList<E> extends AbstractList<E> {

    Node<E> first;

    private static class Node<E>{
        E element;
        Node<E> next;

        public Node(E element,Node<E> next){
            this.element = element;
            this.next = next;
        }
        public Node(E element){
            this(element,null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    '}';
        }
    }
    private Node<E> node(int index){
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> oldNode = node(index);
        E oldV =  oldNode.element;
        oldNode.element = element;
        return  oldV;
    }

    @Override
    public void add(int index, E element) {
        // add --> index = [0,size]
        rangeCheckForAdd(index);
        if(index == 0){
            first = new Node(element,first);
        }else{
            Node<E>  prev = node(index - 1);
            prev.next = new Node(element,prev.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        //index [0,size-1]
        rangeCheck(index);
        Node<E> oldNode;
        if(index == 0){
            oldNode = first;
            first = first.next;
        }else {
            Node<E> prev = node(index - 1);
            oldNode = prev.next;
            prev.next = oldNode.next;
        }
        size--;
        return oldNode.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if(element == null){
            for (int i = 0; i < size; i++) {
                if(node.element == null){
                    return i;
                }
            }
        }else{
            for (int i = 0; i < size; i++) {
                if(element.equals(node.element) ){
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public void clear() {
        first = null;
        size=0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> node = first;
        while(node != null){
            sb.append(node.element).append(",");
            node = node.next;
        }
        return sb.toString();
    }
}

class Test02{
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i : arr) {
            list.add(i);
        }
        System.out.println(list);
        list.add(2,11);

        System.out.println(list);
        list.add(3);

        System.out.println(list);
        list.add(0,1);
        System.out.println(list);

        list.remove(0);
        System.out.println(list);
    }
}