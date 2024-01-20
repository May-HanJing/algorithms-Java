package edu.hain.leetcode;

import edu.hain.common.ListNode;
import edu.hain.common.ListNodeUtils;
import org.junit.Test;

public class LeetCode2807 {

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            int gcd = gcd(pre.val, cur.val);
            ListNode node = cur.next;
            ListNode temp = new ListNode(gcd);
            pre.next = temp;
            pre = cur;
            temp.next = cur;
            cur = node;
        }
        return head;
    }


    /**
     * 求两个数的最大公约数
     *
     * @param a
     * @p
     */
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    @Test
    public void test() {
        int[] arr = {18, 6, 10, 3};
        ListNode listNode = ListNodeUtils.generateHeadListNode(arr);
        System.out.println(listNode);
        ListNode node = ListNodeUtils.reverse(listNode);
        System.out.println(node);
    }

    /**
     * 给你一个链表的头 head ，每个结点包含一个整数值。
     * 在相邻结点之间，请你插入一个新的结点，结点值为这两个相邻结点值的 最大公约数 。
     * 请你返回插入之后的链表。
     * 两个数的 最大公约数 是可以被两个数字整除的最大正整数。
     *
     * @param head
     */
    public ListNode insertGreatestCommonDivisors2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            int gcd = gcd(pre.val, cur.val);
            ListNode node = cur.next;
            ListNode temp = new ListNode(gcd);
            pre.next = temp;
            pre = cur;
            temp.next = cur;
            cur = node;
        }
        return head;

    }
}

