package DataStructure.线性表;

public class DoubleLinkedList<E> extends AbstractList<E>{
    private Node<E> first;
    private Node<E> last;
    private static class Node<E>{
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(E element,Node<E> prev,Node<E> next){
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();

            if(prev == null){
                sb.append("null");
            }else{
                sb.append(prev.element);
            }
            sb.append(",");
            if(element == null){
                sb.append("null");
            }else{
                sb.append(element);
            }
            sb.append(",");
            if(next == null){
                sb.append("null");
            }else{
                sb.append(next.element);
            }
            return sb.toString();
        }
    }

    private Node<E> node(int index){
        rangeCheck(index);
        Node<E> current = first;
        if(index > (size>>1)){
            current = last;
            for (int i = size-1; i >index ; i--) {
                current = current.prev;
            }
            //出来的时候，i=index
        }else{
            for(int i = 0;i<index;i++){
                current = current.next;
            }
        }
        return current;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldE = node.element;
        node.element = element;
        return oldE;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if(index == 0){
            Node<E> newHead = new Node<>(element, null, first);
            if(size == 0){
                last = newHead;
            }else{
                first.prev = newHead;
            }
            first = newHead;
        }else if(index == size){
            Node<E> newTail = new Node<>(element,last,null);
            last.next = newTail;
            last = newTail;
        }else{
            Node<E> node = node(index);
            Node<E> newNode = new Node<>(element,node.prev,node);
            node.prev = newNode;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        Node<E> oldNode = node(index);
        if(index==0){
            first = first.next;
            if(first != null){
                first.prev = null;
            }else{
                last = first;
            }
        }else if(index == size-1){
            last = last.prev;
            last.next = null;
        }else{
            oldNode.prev.next= oldNode.next;
            oldNode.next.prev = oldNode.prev;
        }
        size--;
        return oldNode.element;
    }

    @Override
    public int indexOf(E element) {
        if(first == null) throw new RuntimeException("empty list");
        Node<E> current = first;
        if(element == null){
            for (int i = 0; i < size; i++) {
                if(current.element == null){
                    return i;
                }
                current = current.next;
            }
        }else{
            for (int i = 0; i < size; i++) {
                if(element.equals(current.element)){
                    return i;
                }
                current = current.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public void clear() {
        first= null;
        last = null;
        size = 0;
    }

    @Override
    public String toString(){
        Node node = first;
        if(first == null) return "empty list";
        StringBuilder sb = new StringBuilder();
        sb.append("first:").append(first.element);
        sb.append("--last:").append(last.element).append("\n");

        while(node  != null){
            sb.append(node).append(" --- ");
            node = node.next;
        }
        sb.append("\n");
        return sb.toString();
    }
}
class Test{
    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.add(1);
        System.out.println(list);
        list.add(2);


        list.add(0,3);
        System.out.println(list); //3 1 2


        list.set(1,4);
        System.out.println(list); //3 4 2

        //System.out.println(list.get(3));


        System.out.println(list.remove(2));  //2
        System.out.println(list);//3 4


        System.out.println(list.indexOf(4));//1

        list.clear();
        System.out.println(list.size());//0

        System.out.println(list);


        list.add(1);
        list.add(2);
        list.add(null);
        list.add(3);
        list.add(4);

        System.out.println(list);


        System.out.println(list.indexOf(null));
        System.out.println(list.indexOf(4));
    }
}
