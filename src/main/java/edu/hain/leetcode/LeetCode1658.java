package edu.hain.leetcode;

import org.junit.Test;

public class LeetCode1658 {
    public int minOperations(int[] nums, int x) {
      int sum = 0;
      for(int i = 0;i<nums.length;i++){
          sum+=nums[i];
      }
      int res = Integer.MAX_VALUE;
      if(sum < x) return -1;
      int target = sum - x;
      int left = 0;
      int right = 0;
      while(right < nums.length){
          while(right<nums.length && target>0){
              target -= nums[right];
              right++;
          }

          while(left<right && target<0){
              target += nums[left];
              left++;
          }
          if(target==0){
              res = Math.min(res, nums.length - right + left);
              if(right<nums.length){
                    target -= nums[right];
                    right++;
              }
          }
      }
        return res==Integer.MAX_VALUE?-1:res;
    }

    @Test
    public void test(){
        int[] nums = {5,2,3,1,1};
        int x = 5;
        System.out.println(minOperations(nums, x));
    }
}
