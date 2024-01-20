package edu.hain.leetcode;

public class LeetCode0011 {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right= height.length-1;
        while (left<right){
            int temp = Math.min(height[left],height[right])*(right-left);
            max = Math.max(max,temp);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
