package edu.hain.leetcode;

import edu.hain.common.ListNode;

public class LeetCode0023 {
    public ListNode mergeKLists(ListNode[] lists) {
      ListNode head = lists[0];
        for (int i = 1; i < lists.length; i++) {
            head = merge(head,lists[i]);
        }
        return head;
    }

    public ListNode merge(ListNode head1,ListNode head2){
        if (head1==null ||head2==null){
            return  head1==null?head2:head1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while (head1!=null && head2!=null){
            if(head1.val<head2.val){
                ListNode temp = head1.next ;
                head1.next = null;
                node.next = head1;
                head1 = temp;
            }else{
                ListNode temp = head2.next ;
                head2.next = null;
                node.next = head2;
                head2 = temp;
            }
        }
        if(head1!=null || head2!=null){
            node.next = head1!=null?head1:head2;
        }
        return dummy;
    }
}
