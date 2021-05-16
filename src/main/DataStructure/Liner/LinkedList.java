package Liner;
public class LinkedList<E> extends AbstractList<E>{
    private Node<E> first;

    //内部类：Node节点
    private static class Node<E>{
        E element;
        Node next;
        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> oldNode = node(index);
        E oldElement = oldNode.element;
        oldNode.element = element;
        return oldElement;
    }

    //todo 此方法用于返回index位置的node，提供给其他公共方法使用
    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        //插到头部
        if(index == 0) {
            first.next = new Node<E>(element, first.next);
        }else {
            Node<E> perNode = node(index-1);
            perNode.next = new Node<E>(element, perNode.next);
        }
        size++;

    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> oldNode = null;
        if(index == 0) {
            oldNode = first;
            first = first.next;
        }else {
            Node<E> preNode = node(index-1);
            oldNode = preNode.next;
            preNode.next = preNode.next.next;
        }
        size--;
        return oldNode.element;

    }

    @Override
    public int indexOf(E element) {
        Node<E> tmpNode = first;
        if(element == null) {
            for (int i=0; i < size; i++) {
                if (tmpNode.element == null) return i;
                tmpNode = tmpNode.next;
            }
        }else {
            //那么element一定不为null，放在前面调用equals绝对没问题
            for (int i=0; i < size; i++) {
                if (element.equals(tmpNode.element)) return i;
                tmpNode = tmpNode.next;
            }
        }
        return ELEMENT_NOT_FOUND;

    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        Node<E> tmpNode = first;
        string.append("[");
        for (int i = 0; i < size; i++) {
            if(i != 0) string.append(", ");
            string.append(tmpNode.element);
            tmpNode = tmpNode.next;
        }
        string.append("]");
        return string.toString();
    }

}

