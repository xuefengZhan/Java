package 栈;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 *
 * easy  99.73%
 */
public class 剑指Offer30_包含min函数的栈 {

    /** initialize your data structure here. */
    public 剑指Offer30_包含min函数的栈() {}
    int globalMin;

    private class Node{
        int val;
        int min;
        Node prev;
        Node next;

        public Node(int val){
            this(val,null,null);
        }


        public Node(int val,Node prev,Node next){
            this.val = val;
            if(val < globalMin){
                min = val;
                globalMin = val;
            }else{
                min = globalMin;
            }

            this.prev = prev;
            this.next = next;
        }

        public Node(int val,int min,Node prev,Node next){
            this.val = val;
            this.min = min;
            globalMin = min;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node first;
    private Node last;




    public void push(int x) {
        if(first == null){
            first = new Node(x,x,null,null);
            last  = first;
            return;
        }


        last.next = new Node(x,last,null);
        last = last.next;
    }

    public void pop() {
        if(first == null) throw new RuntimeException("empty stack");
        if(first == last){
            first = null;
            last = null;
            globalMin = 0;
        }else{
            if(last.val == globalMin){
                globalMin = last.prev.min;
            }
            last = last.prev;

        }
     }

    public int top() {
        if(first == null) throw new RuntimeException("empty stack");
        return last.val;
    }

    public int min() {
        return last.min;
    }
}
