package 链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class No206_反转链表 {
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null) return head;

//        ListNode tail = head.next;
//
//        ListNode newHead = reverseList(tail);
//        tail.next = head;
//        head.next = null;
//        return newHead;

        ListNode newNext = null;
        ListNode cur = head;
        ListNode tmp = cur.next;

       while(cur != null){
           cur.next = newNext;
           newNext = cur;
           cur = tmp;
           if(tmp == null) continue;
           tmp = tmp.next;
       }
        return newNext;
    }




}
