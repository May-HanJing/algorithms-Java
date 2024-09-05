package edu.hain.leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode0487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        // 双端队列, 用于存储连续的 1>
        LinkedList<Integer> queue = new LinkedList<>();
        int max = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                queue.addLast(num);
            } else {
                if(count==0){
                    queue.addLast(num);
                    count++;
                }else{
                    while (queue.size() > 1 && queue.getFirst() != 0) {
                        queue.pollFirst();
                    }
                    if(!queue.isEmpty()){
                        queue.pollFirst();
                        count--;
                    }
                queue.addLast(num);
                }
            }
            max = Math.max(max, queue.size());
        }
        return max;
    }
    @Test
    public void test(){
        System.out.println(findMaxConsecutiveOnes(new int[]{1,0,1,1,0}));
    }


}
