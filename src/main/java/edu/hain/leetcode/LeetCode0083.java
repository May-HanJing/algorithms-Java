package edu.hain.leetcode;

import edu.hain.common.ListNode;

public class LeetCode0083 {
    public ListNode deleteDuplicates(ListNode head) {
       if(head==null||head.next==null){
                return head;
            }
            ListNode cur = head;
            while (cur!=null&&cur.next!=null){
                if(cur.val==cur.next.val){
                    cur.next = cur.next.next;
                }else {
                    cur = cur.next;
                }
            }
            return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            while (next!=null&&cur.val==next.val){
                next = next.next;
            }
            cur.next = next;
            cur = next;
        }
        return head;
    }
}
