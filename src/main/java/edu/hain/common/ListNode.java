package edu.hain.common;

import lombok.Data;

@Data
public class ListNode {

    public int val;


    public ListNode next;


    public ListNode(ListNode next, int val) {
        this.next = next;
        this.val = val;
    }

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }
}
