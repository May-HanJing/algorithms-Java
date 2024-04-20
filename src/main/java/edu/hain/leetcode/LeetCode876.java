package edu.hain.leetcode;

import edu.hain.common.ListNode;

public class LeetCode876 {
    public ListNode middleNode(ListNode head) {
       if(head==null || head.next==null){
           return head;
       }
       ListNode slow = head;
       ListNode fast = head.next;
       while (slow!=null && fast.next!=null){
           slow = slow.next;
           fast = fast.next.next;

       }
       return fast==null?slow:slow.next;
    }
}
