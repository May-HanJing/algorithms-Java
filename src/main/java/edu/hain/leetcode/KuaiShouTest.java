package edu.hain.leetcode;

import edu.hain.leetcode.kuaishou.MaxStack;

public class KuaiShouTest {

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(5);
        maxStack.push(1);
        maxStack.popMax();
        maxStack.peekMax();
    }
}
