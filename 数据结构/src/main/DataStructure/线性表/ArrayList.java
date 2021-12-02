package 线性表;

import java.util.Arrays;

public class ArrayList<E> extends AbstractList<E> {

    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    public ArrayList(){

    }

    public ArrayList(int capacity){
        if(capacity < DEFAULT_CAPACITY){
            capacity = DEFAULT_CAPACITY;
        }
        elements = (E[]) new Object[capacity];
    }
    private void ensureCapacity(int size){

        if(elements==null || elements.length == 0){
            elements = (E[]) new Object[DEFAULT_CAPACITY];
            return;
        }
        if(size > elements.length){
            int oldCapacity = elements.length;
            int newCapacity = (oldCapacity>>1) + oldCapacity;
            E[] newArray = (E[]) new Object[newCapacity];
            for (int i = 0; i < oldCapacity; i++) {
                newArray[i] = elements[i];
            }
            elements = newArray;
        }
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size+1);
        for (int i = size; i > index; i--) {
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        E oldV = elements[index];
        for (int i = index; i < size -1; i++) {
            elements[i] = elements[i+1];
        }
        elements[size-1] = null;
        size--;
        return oldV;
    }

    @Override
    public int indexOf(E element) {
        if(element == null){
            for (int i = 0; i < size; i++) {
                if(elements[i] == null){
                    return i;
                }
            }
        }else{
            for (int i = 0; i < size; i++) {
                if(element.equals(elements[i])){
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }
    @Override
    public E set(int index, E element) {
        E oldV = elements[index];
        elements[index] = element;
        return null;
    }

    @Override
    public String toString() {
        return "DynamicArray{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}
class Test01{
    public static void main(String[] args) {
        ArrayList<Integer> Dyarr = new ArrayList<>();
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i : arr) {
            Dyarr.add(i);
        }
        System.out.println(Dyarr);
        Dyarr.add(2,11);
        Dyarr.add(3);
        Dyarr.remove(0);
        System.out.println(Dyarr);
    }
}
