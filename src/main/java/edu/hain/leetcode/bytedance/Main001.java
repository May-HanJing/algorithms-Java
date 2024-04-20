package edu.hain.leetcode.bytedance;

import org.junit.Test;

import java.util.Arrays;

public class Main001 {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
      int[] res = new int[digits.length+1];
      int last = 0;
      for (int i = len-1; i >= 0; i--) {
          int sum = last + digits[i] + (i == len-1 ? 1 : 0);
          last = sum / 10;
          sum %=10;
            res[i+1] = sum;
      }
      if(last==1){
          res[0] = 1;
          return res;
      }
       System.arraycopy(res, 1, digits, 0, len);
      return digits;
    }

    @Test
    public void test(){
        int[] arr = {9,9,9,9};
        System.out.println(Arrays.toString(plusOne(arr)));
    }
}
