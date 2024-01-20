package edu.hain.leetcode;

import edu.hain.common.ListNode;
import edu.hain.common.ListNodeUtils;
import org.junit.Test;

public class LeetCode2704 {

    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        int len = 2;
        while (temp != null) {
            int m = len;
            if (len % 2 == 0) {
                ListNode start = temp;
                while (m > 0 && start != null) {
                    start = start.next;
                    m--;
                }
                if (start != null) {
                    ListNode end = start.next;
                    start = temp.next;
                    ListNode pre = null;
                    ListNode next = null;
                    while (end != start) {
                        next = start.next;
                        start.next = pre;
                        pre =start;
                        start = next;
                    }
                    temp.next = pre;
                    temp = end;
                    len ++;
                }else{
                    return head;
                }
            }else{
                int  n = len;
                while (n>0 && temp!=null){
                    temp = temp.next;
                    n--;
                }
                len++;
            }
        }
        return head;
    }


    @Test
    public  void test(){
        int[] arr = {5,2,6,3,9,1,7,3,8,4};
        ListNode head = ListNodeUtils.generateHeadListNode(arr);
        System.out.println(head);
        ListNode node = reverseEvenLengthGroups(head);
        System.out.println(node);
    }
}
