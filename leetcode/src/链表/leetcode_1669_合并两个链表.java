package 链表;

/**
 * @ClassName leetcode_1669_合并两个链表
 * @Author zxf
 * @Date 2023/2/2 13:04
 **/
public class leetcode_1669_合并两个链表 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if(list1 == null) return null;


        ListNode cur = list1;
        ListNode prev = cur;
        ListNode last = cur;

        int index = 0;
        while(cur.next != null || index <= b ){
            if(index == a - 1){
                prev = cur;
            }

            if(index == b){
                last = cur.next;
            }

            cur = cur.next;
            index++;
        }

        cur = list2;
        while(cur.next != null){
            cur = cur.next;
        }

        prev.next = list2;
        cur.next = last;

        return list1;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);


        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        int a = 3;
        int b = 4;


        ListNode l11 = new ListNode(100);
        ListNode l22 = new ListNode(101);
        ListNode l33 = new ListNode(102);

        l11.next = l22;
        l22.next = l33;


        leetcode_1669_合并两个链表 v = new leetcode_1669_合并两个链表();
        ListNode listNode = v.mergeInBetween(l1, a, b, l11);

        StringBuilder sb = new StringBuilder();

        while(listNode != null){
            sb.append(listNode.val).append("->");
            listNode = listNode.next;
        }

        System.out.println(sb.toString());

    }
}
