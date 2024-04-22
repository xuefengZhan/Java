package 栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName leetcode_225_用队列实现栈
 * @Author zxf
 * @Date 2024/3/4 9:41
 * @Questinon Describrition
 **/
public class leetcode_225_用队列实现栈 {

}

//思路：让队列模仿栈 peek()和pop()都要暴露栈顶，也就是队尾元素
//     如何暴露队尾？ 让队尾元素保证在一个队列的头部
class MyStack {
    Queue<Integer> q1 ; //存储先进去的
    Queue<Integer> q2 ; //存储后进去的


    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    //放置的过程中把队尾元素暴露在队列2的队首
    public void push(int x) {
        //如果q2不为空，将q2清空 放到q1 然后q2放进元素 （保证q2只有最后一个元素）
        if(!q2.isEmpty()){
            q1.offer(q2.poll());
        }

        q2.offer(x);
    }

    public int pop() {
        if(empty()){
            throw new RuntimeException("empty stack");
        }
        help();
        return q2.poll();
    }

    public int top() {
        if(empty()){
            throw new RuntimeException("empty stack");
        }
        help();
        return q2.peek();
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    private void help(){
        //如果q2不为空 那么q2只有一个元素就是栈顶元素
        //为空 则将1掏空
        if(q2.isEmpty()){
            while(q1.size() > 1){
                q2.offer(q1.poll());
            }

            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }
    }
}