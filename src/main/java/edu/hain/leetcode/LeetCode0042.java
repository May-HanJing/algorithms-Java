package edu.hain.leetcode;

import org.junit.Test;

public class LeetCode0042 {

    public int trap(int[] height) {
        int ans = 0;
        int left = 0;
        int len = height.length;
        int right = 1;
        while (right < len) {
            if (height[left] == 0) {
                left = right;
                right++;
                continue;
            }
            int sum = height[left];
            while (right < len && height[right] < height[left]) {
                sum += height[right];
                right++;
            }
            int temp = (right - left) * height[left];
            ans += (temp - sum);
            left = right+1;
            right += 2;
        }
        return ans;
    }

    @Test
    public void test(){
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }
}


