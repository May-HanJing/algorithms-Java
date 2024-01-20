package edu.hain.leetcode;

import edu.hain.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<Integer> list = new ArrayList<>();
    public Solution(ListNode head) {
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
      int index = (int) (Math.random() * list.size());
      return list.get(index);
    }
}
