package edu.hain.leetcode.weekrate393;

import org.junit.Test;

public class LeetCode100265 {

    public int maximumPrimeDifference(int[] nums) {
      int left = 0;
      int right = nums.length-1;
      int i = -1;
      int j = -1;
      while (left<=right){
          if(i==-1 && isPrime(nums[left])){
              i = left;
          }else if(i==-1){
              left++;
          }
          if(j==-1 &&isPrime(nums[right])){
              j = right;
          }else if(j==-1){
              right--;
          }
          if(i!=-1 && j!=-1){
              break;
          }
      }
      return  j-i;
    }

    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        int[] arr = {3,6,6};
        System.out.println(maximumPrimeDifference(arr));
    }


}
