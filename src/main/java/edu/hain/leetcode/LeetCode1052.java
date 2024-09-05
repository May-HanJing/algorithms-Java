package edu.hain.leetcode;

import org.junit.Test;

import java.util.LinkedList;

public class LeetCode1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
      int res = 0;
        int len = customers.length;
        int right = 0;
        int real = 0;
        int fake = 0;
        int preFake = 0;
        int preReal = 0;
        while (right < len) {
            while (right<len && grumpy[right] == 0) {
                res += customers[right++];
            }
            int count = 0;
            fake = 0;
            real = 0;
            while (right<len && count<minutes) {
              if(grumpy[right] == 0){
                  real += customers[right];
              }
              fake += customers[right];
              count++;
              right++;
            }
            if(fake>preFake){
                res += (preReal-preFake);
                res += fake;
                preReal = real;
                preFake = fake;
            }
        }
      return res;
    }

    @Test
    public void test(){
        System.out.println(maxSatisfied(new int[]{1,0,1,2,1,1,7,5},new int[]{0,1,0,1,0,1,0,1},3));
    }
}
