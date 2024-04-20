package edu.hain.leetcode.bytedance;

import org.junit.Test;

public class Main003 {
    public boolean isValid(String s) {
      int len = s.length();
      if(len%3!=0){
          return false;
      }
        s= s.replace("abc","");
      int newLen = s.length();
      while (newLen!=len){
          len = newLen;
          s = s.replace("abc","");
          newLen = s.length();
      }
      return newLen==0;
    }

    @Test
    public void test(){
        System.out.println(isValid("abccba"));
    }
}
