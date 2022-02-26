package 链表;

import java.util.HashSet;

public class NC3_链表中环的入口结点 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead == null) return null;

        HashSet<ListNode> set =  new HashSet<ListNode>();

        ListNode cur = pHead;

        while(cur!=null){
            if(!set.add(cur)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;

    }
}
