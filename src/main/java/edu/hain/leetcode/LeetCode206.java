package edu.hain.leetcode;

import edu.hain.common.ListNode;
import edu.hain.common.ListNodeUtils;
import org.junit.Test;

public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
       if(head==null || head.next==null){
           return null;
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

    @Test
    public void test(){
        ListNode listNode = ListNodeUtils.generateTailListNode(new int[]{1,4,6,3,2,9});
        System.out.println(listNode);
        ListNode listNode1 = reverseList(listNode);
        System.out.println(listNode1);
    }
}
