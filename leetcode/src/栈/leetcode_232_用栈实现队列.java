package 栈;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName leetcode_232_用栈实现队列
 * @Author zxf
 * @Date 2024/3/4 15:33
 * @Questinon Describrition
 **/
public class leetcode_232_用栈实现队列 {

}
class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    //栈实现队列 将第一个入栈的元素放在栈顶即可
    public void push(int x) {
        s2.push(x);
    }

    public int pop() {
        if(empty()){
            throw new RuntimeException("empty stack");
        }
        help();
        return s1.pop();
    }

    public int peek() {
        if(empty()){
            throw new RuntimeException("empty stack");
        }
        help();
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    private void help(){
        if(s1.isEmpty()){
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
    }
}