package edu.hain.leetcode.jd;

import java.util.LinkedList;

public class Main007 {
    class MyCircularDeque {
        LinkedList<Integer> deQueue;
        int size;
        public MyCircularDeque(int k) {
           deQueue = new LinkedList<>();
           size = k;
        }

        public boolean insertFront(int value) {
            if(deQueue.size()>=size){
                return false;
            }
            deQueue.addFirst(value);
            return true;
        }

        public boolean insertLast(int value) {
            if(deQueue.size()>=size){
                return false;
            }
            deQueue.addLast(value);
            return true;
        }

        public boolean deleteFront() {
            if(deQueue.isEmpty()){
                return false;
            }
            deQueue.pollFirst();
            return true;
        }

        public boolean deleteLast() {
            if(deQueue.isEmpty()){
                return false;
            }
            deQueue.pollLast();
            return true;
        }

        public int getFront() {
           return deQueue.isEmpty()?-1:deQueue.peekFirst();
        }

        public int getRear() {
            return deQueue.isEmpty()?-1:deQueue.peekLast();

        }

        public boolean isEmpty() {
           return deQueue.isEmpty();
        }

        public boolean isFull() {
           return  deQueue.size() == size;
        }
    }

}
