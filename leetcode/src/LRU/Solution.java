package LRU;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    private class Node{
        int value;
        Node prev;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }
    //get/set O(1) 必须hash表
    HashMap<Integer,Node> map = new HashMap<Integer,Node>();
    Node first;
    Node last;

    int capacity;
    int size ;

    public int[] LRU (int[][] operators, int k) {
        capacity = k;
        // write code here
        List<Integer> res = new ArrayList<>();

        for (int[] operator : operators) {
            if(operator.length == 3){
                 put(operator[1],operator[2]);
            }else{
                Node node = get(operator[1]);
                if(node == null){
                    res.add(-1);
                }else{
                    res.add(node.value);
                }
            }
        }

        return res.toArray();
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

            first.prev = newNode;
            newNode.next = first;

            if(size < capacity){
                size++;
            }else{
                last.prev.next = null;
            }
        }else{

        }
    }


    private Node get(int key){
        Node node = map.get(key);
        if(node == null) return null;


        return node;
    }

    private void removeToFirst(Node node){
        //有这个 更改值
        node.value = value;

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


}
