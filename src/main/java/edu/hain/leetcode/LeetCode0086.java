package edu.hain.leetcode;

import edu.hain.common.ListNode;
import edu.hain.common.ListNodeUtils;
import org.junit.Test;

import java.util.List;

public class LeetCode0086 {
    public ListNode partition(ListNode head, int x) {
        if (head == null && head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        ListNode tail = new ListNode(-1);
        ListNode node = tail;
        ListNode linkNode = null;
        while (head != null) {
            if (head.val < x) {
                //头插法
                ListNode temp = head.next;
                head.next = null;
                cur.next = head;
                cur = cur.next;
                head = temp;
            } else {
                //尾插法
                ListNode temp = head.next;
                head.next = null;
                node.next = head;
                node = node.next;
                head = temp;
            }

        }
       if(pre==null){
           return tail.next;
       }

       cur.next = tail.next;
        return  pre.next;
    }

    public ListNode revserse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return  pre;
    }


    @Test
    public void test(){
        int[] arr = {1,4,3,2,5,2};
        ListNode node = ListNodeUtils.generateTailListNode(arr);
        System.out.println(node);
        ListNode res = partition(node, 3);
        System.out.println(res);
    }
}
