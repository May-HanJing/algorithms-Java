package edu.hain.leetcode;

import edu.hain.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode0148 {

    public ListNode sortList(ListNode head) {
       if(head==null || head.next==null){
           return head;
       }
       ListNode node = head;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
        while (node!=null){
            queue.add(node.val);
            node = node.next;
        }
        node = head;
        while (node!=null) {
            node.val = queue.poll();
            node = node.next;
        }
       return  head;
    }
}
