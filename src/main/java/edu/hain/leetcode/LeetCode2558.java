package edu.hain.leetcode;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode2558 {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int gift : gifts) {
            queue.add(gift);
        }
        while (!queue.isEmpty() && k>0){
            Integer poll = queue.poll();
            queue.add((int) Math.sqrt(poll));
            k--;
        }
        long result = 0;
        while (!queue.isEmpty()){
            result += queue.poll();
        }
        return result;
    }

    @Test
    public void testSetKeys(){
        int[] arr = {9,4,25,100,64};
        long pickGifts = pickGifts(arr, 4);
        System.out.println(pickGifts);
    }
}
