package edu.hain.leetcode.weekrate398;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode100300 {
    public long sumDigitDifferences(int[] nums) {
       int[][] cnt = new int[String.valueOf(nums[0]).length()][10];

        long res = 0L;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for(int j = 0; num>0;  j++){
                int d = num%10;
                num /=10;
                res += i -cnt[j][d]++;
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(sumDigitDifferences(new int[]{13,23,12}));
    }
}
