package 单调栈;

import 链表.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ClassName leetcode_1019_链表中的下一个更大节点
 * @Author zxf
 * @Date 2024/1/26 16:15
 * @Questinon Describrition
 **/
public class leetcode_1019_链表中的下一个更大节点 {
    class Node{
        int index;
        int val;

        public Node(int index,int val){
            this.index = index;
            this.val = val;
        }
    }
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> arrayList = new ArrayList();
        LinkedList<Node> stack = new LinkedList<Node>();

        ListNode cur = head;
        int i = 0;
        while(cur!=null){
            arrayList.add(0); //增加容量
            while(!stack.isEmpty() && cur.val > stack.peek().val){
                arrayList.set(stack.peek().index,cur.val);
                stack.pop();
            }
            stack.push(new Node(i++,cur.val));
            cur = cur.next;
        }

        int[] res = new int[arrayList.size()];

        for (int j = 0; j < arrayList.size(); j++) {
            res[j] = arrayList.get(j);
        }

        return res;
    }
}
