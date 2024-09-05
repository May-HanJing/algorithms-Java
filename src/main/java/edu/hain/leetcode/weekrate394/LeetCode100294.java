package edu.hain.leetcode.weekrate394;

import java.util.HashMap;
import java.util.Map;

public class LeetCode100294 {
    public int numberOfSpecialChars(String word) {
      int[] arr = new int[26];
      int[] temp = new int[26];
      int res = 0;
      for(int i=0;i<word.length();i++) {
          char c= word.charAt(i);
          if(Character.isLowerCase(c)){
              arr[c-'a']=1;
          }else{
              temp[c-'A']=1;
          }
      }
        for (int i = 0; i < 26; i++) {
            if(arr[i]==temp[i] && arr[i]==1){
                res++;
            }
        }
      return  res;
    }
}
