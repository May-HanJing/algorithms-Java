package edu.hain.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeeytCode100111 {
    public int findKOr(int[] nums, int k) {
        if(k == 1){
           int res = nums[0];
            for (int i = 1; i <nums.length ; i++) {
                res |= nums[i];
            }
            return res;
        }
        if(nums.length == k){
            int res = nums[0];
            for (int i = 1; i <nums.length ; i++) {
                res &= nums[i];
            }
            return res;
        }
        Map<Integer,Integer> map =  new HashMap<>();
        for (int num : nums) {
            String binaryString = Integer.toBinaryString(num);
            countOne(map,binaryString);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()){
            if(mapEntry.getValue()>=k){
                res += (int) Math.pow(2,mapEntry.getKey());
            }
        }
        return res;
    }

    private void countOne(Map<Integer, Integer> map, String binaryString) {
        for (int i = binaryString.toCharArray().length - 1; i >= 0; i--) {
            if(binaryString.charAt(i) == '1'){
                Integer orDefault = map.getOrDefault(binaryString.length()-1-i, 0);
                map.put(binaryString.length()-i-1,orDefault+1);
            }
        }
    }
}
