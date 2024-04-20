package edu.hain.leetcode;

import org.junit.Test;

public class LeetCode2765 {


    public int alternatingSubarray(int[] nums) {
       int i = 0;
       int j = 1;
       int len = nums.length;
       int max = 0;
       while (i<len && j<len){
           int start = i;
           int right = j;
           if(nums[j]-1==nums[i]){
               while (start<len&&right<len&&nums[i]==nums[start] && nums[j]==nums[right]){
                   start+=2;
                   right+=2;
               }
               if(right>=len){
                   max = Math.max(max,right-i-1);
               }else{
                   max = Math.max(max,right-i-1);
               }

           }
           i++;
           j++;
       }
       return max==0?-1:max;
    }

    @Test
    public void test(){
        int[] arr = {2,3,4,3,4};
        System.out.println(alternatingSubarray(arr));
    }

}
