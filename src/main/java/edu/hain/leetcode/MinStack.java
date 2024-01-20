package edu.hain.leetcode;

import java.util.LinkedList;

public class MinStack {
    LinkedList<Integer> queue;
    LinkedList<Integer> minQueue;
    public MinStack() {
        queue  = new LinkedList<>();
        minQueue = new LinkedList<>();
    }

    public void push(int x) {
        queue.addLast(x);
        if(minQueue.isEmpty()){
            minQueue.addLast(x);
        }else{
            int min = minQueue.peekLast()>=x?x:minQueue.peekLast();
            minQueue.addLast(min);
        }
    }

    public int pop() {
       if(queue.isEmpty()){
           return -1;
       }
       minQueue.pollLast();
       return queue.pollLast();
    }

    public int top() {
        if(queue.isEmpty()){
            return -1;
        }
        return queue.peekLast();
    }

    public int  getMin() {
        if(minQueue.isEmpty()){
            return -1;
        }
       return minQueue.peekLast();
    }
}
