package edu.hain.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class LeetCode0946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList();
        int index = 0;
        for(int num: pushed){
            stack.addLast(num);
            while(!stack.isEmpty()&&stack.peekLast()==popped[index]){
                stack.pollLast();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
