package edu.hain.common;

public class ListNodeUtils {

    /**
     * 生成链表
     *
     * @
     */
    public static ListNode generateHeadListNode(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int i : arr) {
            ListNode node = new ListNode(i);
            cur.next = node;
            cur = node;
        }
        return dummy.next;
    }

    public static ListNode generateTailListNode(int[] arr) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        for (int i = 0; i < arr.length; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }
        return head.next;
    }


    public static ListNode reverse(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}