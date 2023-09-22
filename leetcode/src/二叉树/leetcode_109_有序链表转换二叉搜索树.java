package 二叉树;


import 链表.ListNode;

/**
 * @ClassName leetcode_109_有序链表转换二叉搜索树
 * @Author zxf
 * @Date 2023/2/3 10:43
 **/
public class leetcode_109_有序链表转换二叉搜索树 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null ) return null;
        if(head.next == null) return new TreeNode(head.val);

        //找到链表中点
        ListNode cur = new ListNode(-1);
        cur.next = head;
        ListNode fast = head;
        while(fast != null &&  fast.next !=null){
            cur = cur.next;
            fast = fast.next.next;
        }

        //fast.next == null  || fast == null
        TreeNode root = new TreeNode(cur.next.val);//中点 做root

        //中点前后都断开形成两个新链表
        ListNode second = cur.next.next;
        cur.next = null;

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(second);


        return root;
    }
}
