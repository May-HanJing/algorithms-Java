package edu.hain.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetCode0128 {
    public int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.stream(nums).forEach(queue::add);
        int count = 1;
        int max = 1;
        int cur = queue.poll();
        while (!queue.isEmpty()){
            int temp = queue.poll();
            if(temp-cur==1){
                count++;
            }else if(temp-cur==0){
                continue;
            }else{
                count = 1;
            }
            max = Math.max(max,count);
            cur = temp;
        }
        return max;
    }
}
