package edu.hain.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode0169 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int size = nums.length/2;
         int ans = nums[0];
        for(int i = 0;i<nums.length;i++){
            int cur =  map.getOrDefault(nums[i],0);
            map.put(nums[i],cur+1);
            if(map.get(nums[i])>size){
                ans = nums[i];
                break;
            }
        }
        return  ans;
    }
}
