package edu.hain.leetcode.kuaishou;

public class Main001 {
    public int search(int[] nums, int target) {
      int index  = -1;
      int left = 0;
      int right = nums.length-1;
      while (left<=right){
          int mid = (right-left)/2+left;
          if(nums[mid]==target){
              index = mid;
              break;
          }else if(nums[mid]<target){
              left = mid+1;
          }else { // nums[mid]>target
              right = mid-1;
          }
      }
      return  index;
    }
}
