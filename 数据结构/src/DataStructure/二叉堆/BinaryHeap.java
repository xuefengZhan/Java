package 二叉堆;

import java.util.Comparator;

public class BinaryHeap<E> extends AbstractHeap<E> {


    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap(E[] elements, Comparator<E> comparator)  {
        super(comparator);

        if (elements == null || elements.length == 0) {
            this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        } else {
            size = elements.length;
            int capacity = Math.max(elements.length, DEFAULT_CAPACITY);
            this.elements = (E[]) new Object[capacity];
            for (int i = 0; i < elements.length; i++) {
                this.elements[i] = elements[i];
            }
            heapify();
        }
    }

    public BinaryHeap(E[] elements)  {
        this(elements, null);
    }

    public BinaryHeap(Comparator<E> comparator) {
        this(null, comparator);
    }

    public BinaryHeap() {
        this(null, null);
    }

    private int compare(E e1,E e2){
        if(comparator == null){
           return  ((Comparable<E>)e1).compareTo(e2);
        }else{
            return comparator.compare(e1,e2);
        }
    }

    private void nullCheck(E e){
        if(e == null){
            throw new RuntimeException("param can not be null");
        }
    }


    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    private void ensureCapacity(int size){
        if(size > elements.length){
            E[] newArr = (E[])new Object[elements.length << 1];
            for (int i = 0; i < size; i++) {
                newArr[i] = elements[i];
            }
            elements = newArr;
        }
    }

    @Override
    public void add(E element) {
        nullCheck(element);
        ensureCapacity(size+1);
        elements[size++] = element;
        siftUp(size - 1);
    }

    private void siftUp(int index){
        //todo 找应该放置的位置
        E cur = elements[index];
        //当index > 0的时候才有父节点
        while(index > 0){
            int parentIndex = (index  - 1) >> 1;
            E parent = elements[parentIndex];

            if(compare(cur,parent) <= 0) break;//找到位置 就是index的位置

            elements[index] = parent;
            index = parentIndex;
        }
        elements[index] = cur;
    }


    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    private void emptyCheck(){
       if(size == 0){
           throw new RuntimeException("empty heap");
       }
    }

    @Override
    public E remove() {
        //用最后一个节点覆盖根结点
        //删除最后一个节点
        //下虑 和 最大的子节点互换
        emptyCheck();
        E root = elements[0];
        int lastIndex = --size;
        elements[0]  = elements[lastIndex];
        elements[lastIndex] = null;

        siftDown(0);

        return root;
    }

    private void siftDown(int index){
        E cur = elements[index];

        int haveChild = (size - 2) >> 1;
        //index <= haveChild 有子节点
        while(index <= haveChild){

            int leftchildIndex = (index << 1) + 1;//左子节点
            int rightChildIndex = leftchildIndex + 1;//右子节点
            int maxChildIndex = leftchildIndex;

            //有右子节点的时候
            if( rightChildIndex < size ){
               maxChildIndex = compare(elements[leftchildIndex],elements[rightChildIndex]) > 0? leftchildIndex:rightChildIndex;
            }
            E maxchild = elements[maxChildIndex];

            if(compare(cur,maxchild) > 0) break; //index 就是目标位置

            elements[index] = maxchild;
            index = maxChildIndex;
        }
        elements[index] = cur;
    }


    /**
     * 删除堆顶元素的同时插入一个新元素
     * @param element
     * @return
     */
    @Override
    public E replace(E element) {
        nullCheck(element);

        E root = null;

        if (size == 0) {
            elements[0] = element;
            size++;
        } else {
            root = elements[0];
            elements[0] = element;
            siftDown(0);
        }
        return root;
    }


    /**
     * 批量建堆
     */
    private void heapify() {
        // 自上而下的上滤
//		for (int i = 1; i < size; i++) {
//			siftUp(i);
//		}

        // 自下而上的下滤
        for (int i = (size >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {22,54,13,57,1,5,8,4,3,46,12,47,23};
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>(arr, (o1,o2) -> o2-o1);

        System.out.println(heap.get());

    }
}
