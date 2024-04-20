package edu.hain.leetcode;

public class LeetCode3065 {
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        for (int num : nums) {
            if(num<k){
                ans++;
            }
        }
        return  ans;
    }
}
