package edu.hain.leetcode.weekrate391;

import org.junit.Test;

public class LeetCode100263 {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
          int temp = x;
         int sum = 0;
          while (x > 0) {
                sum += x % 10;
                x /= 10;
          }
          return temp%sum==0?sum:-1;
    }

    @Test
    public void test(){
        System.out.println(sumOfTheDigitsOfHarshadNumber(23));
    }
}
