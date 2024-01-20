package edu.hain.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LeetCode0239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
      int[] res = new int[nums.length-k+1];
        LinkedList<Integer> queue = new LinkedList<>();
        int left = 0;
        while (left<nums.length){
            while (!queue.isEmpty() && nums[queue.peekLast()]<nums[left]){
                queue.pollLast();
            }
            queue.add(left);
            if (left-queue.peekFirst()>=k){
                queue.pollFirst();
            }
            if(left>=k-1){
                res[left-k+1] = nums[queue.peekFirst()];
            }
            left++;
        }
        return  res;
    }

    @Test
    public void  test(){
        //int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] arr = {2,3,4,2,6,2,5,1};
        Deque<Integer> queue = new ArrayDeque<>();


        int[] ints = maxSlidingWindow(arr, 3);
        System.out.println(ints);
    }
}
