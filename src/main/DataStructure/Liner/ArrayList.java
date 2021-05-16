package Liner;

public class ArrayList<E> extends AbstractList<E>{

    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElememts = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElememts[i] = elements[i];
        }
        elements = newElememts;
        System.out.println("扩容了： "+"旧容量，"+oldCapacity+"新容量，"+newCapacity);
    }

    public ArrayList() {
        //调用有参构造
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = (E[])new Object[capacity];
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public E get(int index) {
        rangeCheck(index);

        return elements[index];
    }

    public E set(int index, E element) {
        rangeCheck(index);

        E old = elements[index];
        elements[index] = element;
        return old;
    }

    public void add(int index, E element) {
        rangeCheckForAdd(index);
        //确保容量足够：查看容量是否足够，不够就扩容
        ensureCapacity(size + 1);
        for(int i = size; i > index; i--) {
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }

    public E remove(int index) {
        rangeCheck(index);

        E old = elements[index];
        //index后的元素前移
        while (index < size-1) {
            elements[index] = elements[index+1];
            index++;
        }

        elements[--size] = null;
        return old;
    }

    public int remove(E element) {
        int index = indexOf(element);
        remove(indexOf(element));
        return index;
    }

    public int indexOf(E element) {
        if(element == null) {
            for (int i=0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        }else {
            //那么element一定不为null，放在前面调用equals绝对没问题
            for (int i=0; i < size; i++) {
                if (element.equals(elements[i])) return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        for (int i = 0; i < size; i++) {
            if(i != 0)
                string.append(", ");
            string.append(elements[i]);

        }
        string.append("]");
        return string.toString();
    }

}
