package 排序;

import java.util.ArrayList;
import java.util.Arrays;

public class NC70_单链表的排序 {
     public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val){
            this.val = val;
        }
     }

    public ListNode sortInList (ListNode head) {

        ListNode cur = head;
        ArrayList<Integer> arrayList = new ArrayList();
        while(cur != null){
            arrayList.add(cur.val);
            cur = cur.next;
        }

        int[] objects = new int[arrayList.size()];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = arrayList.get(i);
        }

        System.out.println(Arrays.toString(objects));

        mergeSort(objects,0,objects.length-1);

        cur = head;
        for (Integer object : objects) {
            cur.val = object;
            cur = cur.next;
        }

        return head;
    }

    private static void  mergeSort(int[] arr,int low,int high){


        if(low >= high) return;

        int mid = low + (high - low)/2;

        mergeSort(arr,low,mid);
        mergeSort(arr,mid + 1,high);

        merge(arr,low,mid,high);
    }


    private static void merge(int[] arr,int low,int mid,int high){
        int[] leftArr = new int[mid - low + 1];
        for(int i = low;i<= mid;i++){
            leftArr[i - low] = arr[i];
        }

        int left = 0;
        int right = mid + 1;

        for (int i = low; i <= high; i++) {
            if((left < leftArr.length && right <= high && leftArr[left] < arr[right]) || right > high){
                arr[i] = leftArr[left];
                left ++;
            }else{
                arr[i] = arr[right];
                right++;
            }
        }

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next  = new ListNode(5);

        NC70_单链表的排序 v = new NC70_单链表的排序();
        ListNode listNode = v.sortInList(head);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
