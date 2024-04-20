package edu.hain.leetcode.weekrate381;

import java.util.*;

public class LeetCode100188 {
    public int[] countOfPairs(int n, int x, int y) {
        int[] ans = new int[2];
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=i+1;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = n-1;
        while (left<right){
            if(nums[left]+nums[right]==x){
                ans[0]++;
                left++;
                right--;
            }else if(nums[left]+nums[right]>x){
                right--;
            }else{
                left++;
            }
        }
        left = 0;
        right = n-1;
        while (left<right){
            if(nums[left]+nums[right]==y){
                ans[1]++;
                left++;
                right--;
            }else if(nums[left]+nums[right]>y){
                right--;
            }else{
                left++;
            }
        }
        return ans;
    }
}
