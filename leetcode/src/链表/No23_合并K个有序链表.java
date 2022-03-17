package 链表;

/**
 *
 *  hard
 * 	执行耗时:115 ms,击败了12.02% 的Java用户
 * 	内存消耗:43.2 MB,击败了31.48% 的Java用户
 */
public class No23_合并K个有序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0 ) return null;
        if(lists.length == 1) return lists[0];
        ListNode tmp = lists[0];
        for (int i = 1; i < lists.length; i++) {
            tmp = mergeTwo(tmp,lists[i]);
        }

        return tmp;
    }
    private ListNode mergeTwo(ListNode l1,ListNode l2){

        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1 == null && l2 == null) return null;

        ListNode min = null;
        ListNode max = null;
        ListNode res = null;
        if(l1.val < l2.val){
            min = l1;
            max = l2;
            res = l1;
        }else{
            min = l2;
            max = l1;
            res = l2;
        }

        ListNode tail = min;
        while(min != null && max != null && min.val <= max.val){
            tail = min;
            min = min.next;
        }
        // min == null     min.val > max.val
        tail.next = max;
        mergeTwo(min,max);

        return res;
    }
}
