package LRU;

import java.util.*;
import java.util.stream.Stream;

public class Solution {

    private class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    HashMap<Integer,Node> map = new HashMap<Integer,Node>();
    Node first;
    Node last;

    int capacity;
    int size ;

    public int[] LRU (int[][] operators, int k) {
        capacity = k;

        int count = (int) Stream.of(operators).filter(x -> x.length == 2).count();

        int[] res = new int[count];

        int i = 0;
        for (int[] operator : operators) {
            if(operator.length == 3){
                 put(operator[1],operator[2]);
            }else{
                Node node = get(operator[1]);
                if(node == null){
                    res[i++] = -1;
                }else{
                    res[i++] = node.value;
                }
            }
        }

        return res;
    }

    private void put(int key,int value){

       // System.out.println("put key=" +key + "value=" +value + "=========================");
        //size > 0
        Node node = map.get(key);

        if(node == null){
            //没有这个  增加一个节点
            Node newNode = new Node(key,value);
            putNode(newNode);
        }else{
            //有这个 更改值
            updateNode(node,value);
        }
    }


    private void putNode(Node node){
        //System.out.println("put" + node);
        map.put(node.key,node);
        node.next = first;
        if(size != 0){
            first.prev = node;
        }else{
            last = node;
        }
        first = node;

        if(size < capacity){
            size++;
        }else{

            map.remove(last.key);

            last = last.prev;
            last.next = null;
        }
    }

    private void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;

        if(prev != null){
            prev.next = next;
        }

        if(next != null){
           next.prev = prev;
        }

        if(last == node){
            last = node.prev;
        }

        if(first == node){
            first = node.next;
        }

        node.next = null;
        node.prev = null;

        size--;
    }

    private void updateNode(Node node,int value){
        node.value = value;
        map.put(node.key,node);

        removeNode(node);
        putNode(node);
    }



    private Node get(int key){

        //System.out.println("get key=" +key  + "=========================");
        Node node = map.get(key);

        if(node == null) return null;

        removeNode(node);
        putNode(node);
        return node;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] operators = {{1,1,1},{1,2,2},{1,3,2} ,{2,1},{1,4,4},{2,2}};
        int k = 3;
        int[] lru = solution.LRU(operators, k);

        System.out.println(Arrays.toString(lru));


        System.out.println("===============================================");
        Solution solution2 = new Solution();
        int[][] operators2 = {{1,1,1},{1,2,2},{2,1} ,{1,3,3},{2,2},{1,4,4},{2,1},{2,3},{2,4}};
        int k2 = 2;

        int[] lru2 = solution2.LRU(operators2, k2);

        System.out.println(Arrays.toString(lru2));
    }
}
