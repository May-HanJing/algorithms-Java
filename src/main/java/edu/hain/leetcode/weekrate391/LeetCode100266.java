package edu.hain.leetcode.weekrate391;

import org.junit.Test;

public class LeetCode100266 {
    /**
     * 给你一个二进制数组 nums
     *     如果一个子数组中 不存在 两个 相邻 元素的值 相同 的情况，我们称这样的子数组为 交替子数组 。
     *     返回数组 nums 中交替子数组的数量。
     */
    public int countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        int res = 1;
        int prev = 1;
        int next = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
               next = prev + 1;
            } else {
                next = 1;
            }
            res += next;
            prev = next;
        }
        return res;
    }



    @Test
    public  void test(){
        System.out.println(5000050000L>Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);

    }
}
