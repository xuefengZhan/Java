package 线性表;

public abstract class AbstractList<E> implements List<E> {
    protected int size;
    protected void rangeCheck(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index out of Bound");
        }
    }

    protected void rangeCheckForAdd(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("index out of Bound");
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean contains(E element) {
        return indexOf(element) == ELEMENT_NOT_FOUND;
    }

    @Override
    public void add(E element) {
        add(size,element);
    }





}
