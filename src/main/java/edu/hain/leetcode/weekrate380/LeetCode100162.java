package edu.hain.leetcode.weekrate380;

public class LeetCode100162 {
    public int maxFrequencyElements(int[] nums) {
        int[] count = new int[101];
        int max = 0;
        for (int num : nums) {
            count[num] += 1;
            max = Math.max(max, count[num]);
        }
        int res = 0;
        for (int i = 1; i <= 100; i++) {
            if (count[i] == max) {
                res += count[i] ;
            }
        }
        return  res;
    }
}
