package edu.hain.leetcode;

public class LeetCode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum > target) {
                sum -= nums[left];
                left++;
            }
            if (sum == target) {
                min = Math.min(min, right - left + 1);
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
