package edu.hain.leetcode;

import java.util.LinkedList;

public class LeetCode0232 {
    LinkedList<Integer> s1;
    LinkedList<Integer> s2;
    class MyQueue {

        public MyQueue() {
           s1 = new LinkedList<>();
           s2 = new LinkedList<>();
        }

        public void push(int x) {
              s1.addLast(x);
        }

        public int pop() {
          while (!s1.isEmpty() && s1.size()>1){
              s2.addLast(s1.pollLast());
          }
          int res =  s1.pollLast();
          while (!s2.isEmpty()){
              s1.addLast(s2.pollLast());
          }
          return res;
        }

        public int peek() {
            while (!s1.isEmpty() && s1.size()>1){
                s2.addLast(s1.pollLast());
            }
            int res =  s1.peekLast();
            while (!s2.isEmpty()){
                s1.addLast(s2.pollLast());
            }
            return  res;
        }

        public boolean empty() {
          return s1.isEmpty();
        }
    }
}
