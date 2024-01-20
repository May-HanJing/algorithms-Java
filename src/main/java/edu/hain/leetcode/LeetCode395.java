package edu.hain.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LeetCode395 {
    public int longestSubstring(String s, int k) {
     Map<Character,Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
       int len = charArray.length;
       int left =0;
       int right = 0;
       int min = Integer.MIN_VALUE;
       while (right<len){
           Integer orDefault = map.getOrDefault(charArray[right], 0);
           orDefault+=1;
           map.put(charArray[right],orDefault);
           if (orDefault>=k){
               boolean sign = true;
               for(Map.Entry<Character,Integer> entry:map.entrySet()){
                     if(entry.getValue()<k){
                         sign = false;
                         break;
                     }
               }
               while (sign && right<len && map.containsKey(charArray[right]) ){
                   min = Math.max(min,right-left+1);
                   right++;
               }
           }
           right++;
       }
       return  min==Integer.MIN_VALUE?0:min;
    }

    @Test
    public void test(){
        String s = "ababbc";
        int k = 3;
        int i = longestSubstring(s, k);
        System.out.println(i);
    }
}
