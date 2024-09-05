package edu.hain.leetcode.weekrate398;

import org.junit.Test;

public class LetCode100310 {

    public boolean isArraySpecial(int[] nums) {
      int pre = nums[0]/2;
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]/2==pre){
                return false;
            }
            pre = nums[i]/2;
        }

        return true;
    }

    @Test
    public void test(){
        System.out.println(isArraySpecial(new int[]{4,3,1,6}));
    }
}
