package 线性表;

public class Stack<E> {


    private List<E> list = new DynamicArray<>();

    public void clear(){
        list.clear();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void push(E element){
        list.add(element);
    }

    public E pop(){
        return list.remove(list.size() - 1);
    }

    public E peek(){
        return list.get(list.size() - 1);
    }
}

class Test03{
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        stack.push(1);
        stack.push(2);
    }
}
