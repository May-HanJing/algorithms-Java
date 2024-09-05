package edu.hain.leetcode.weekrate394;

import java.util.*;

public class LeetCode100291 {
    public int numberOfSpecialChars(String word) {
     Map<Character, List<Integer>> samllMap =new HashMap<>();
     Map<Character,List<Integer>> bigMap =new HashMap<>();


      for(int i=0;i<word.length();i++) {
          char c= word.charAt(i);
          if(Character.isLowerCase(c)){
              List<Integer> orDefault = samllMap.getOrDefault(c, new ArrayList<>());
              orDefault.add(i);
              samllMap.put(c,orDefault);
          }else{
              List<Integer> orDefault = bigMap.getOrDefault(c, new ArrayList<>());
              orDefault.add(i);
              bigMap.put(c,orDefault);
          }
      }
      int res = 0;
     for(Map.Entry<Character,List<Integer>> entry: samllMap.entrySet()){
         Character key = entry.getKey();
         List<Integer> value = entry.getValue();
         int distance = key-'a';
         char big = (char) ('A'+distance);
         if(bigMap.containsKey(big)){
             List<Integer> integers = bigMap.get(big);
             if(integers.get(0)>value.get(value.size()-1)){
                 res += 1;
             }
         }
     }
      return  res;
    }
}
