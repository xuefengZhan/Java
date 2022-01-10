package LRU;

import java.util.*;
import java.util.stream.Stream;

public class Solution {

    private class Node{
        int value;
        Node prev;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    HashMap<Integer,Node> map = new HashMap<Integer,Node>();
    Node first;
    Node last;

    int capacity;
    int size ;

    public int[] LRU (int[][] operators, int k) {
        capacity = k;
        // write code here
        int count = (int) Stream.of(operators).filter(x -> x.length == 2).count();

        int[] res = new int[count];

        System.out.println(count);

        int i = 0;
        for (int[] operator : operators) {
            if(operator.length == 3){
                 put(operator[1],operator[2]);
            }else{
                Node node = get(operator[1]);
                if(node == null){
                    res[i] = -1;
                    i++;
                }else{
                    res[i] = node.value;
                    i++;
                }
            }
        }

        return res;
    }

    private void put(int key,int value){

        if(size == 0){
            Node node = new Node(value);
            first = node;
            last = node;

            map.put(key,node);
            size++;

            return;
        }

        //size > 0
        Node node = map.get(key);

        if(node == null){
            //没有这个  增加一个节点
            Node newNode = new Node(value);
            map.put(key,newNode);

            removeToFirst( newNode );

            if(size < capacity){
                size++;
            }else{
                last.prev.next = null;
                map.remove(key);
            }
        }else{
            //有这个 更改值
            node.value = value;
            removeToFirst(node);
        }

        Node cur = first;
        while(cur != null){
            System.out.println(cur.value);
            cur = cur.next;
        }
    }


    private Node get(int key){
        Node node = map.get(key);
        if(node == null) return null;


        return node;
    }

    private void removeToFirst(Node node){

        //更改结构
        Node prev = node.prev;
        Node next = node.next;

        if(prev == null){
            return;
        }else{
            prev.next = next;
        }

        if(next != null){
            //node不是尾节点
            next.prev = prev;
        }

        //放到头部
        node.next = first;
        first.prev = node;
        first = node;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] operators = {{1,1,1},{1,2,2},{1,3,2} ,{2,1},{1,4,4},{2,2}};
        int k = 3;
        int[] lru = solution.LRU(operators, k);

        System.out.println(Arrays.toString(lru));
    }
}
