package edu.hain.leetcode;

import edu.hain.common.ListNode;

import java.util.List;

public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = reverse(headA);
        ListNode B = reverse(headB);
        if(A.val!=B.val){
            return null;
        }
        ListNode curA = A.next;
        ListNode curB = B.next;
        while (curA!=null && curB!=null && curA.val==curB.val){
            curA = curA.next;
            curB = curB.next;
        }
        if(curA==null || curB==null){
            return null;
        }
        return curA;

    }
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return  head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
