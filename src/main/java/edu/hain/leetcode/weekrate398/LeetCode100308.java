package edu.hain.leetcode.weekrate398;

import org.junit.Test;

public class LeetCode100308 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        if(nums.length==1){
            return new boolean[]{true};
        }
        int len = nums.length;
        int[] spilt = new int[len-1];
        for (int i = 1; i < len; i++) {
            spilt[i-1] = nums[i]%2==nums[i-1]%2?1:0;
        }
        int[] sum = new int[spilt.length];
        sum[0] = spilt[0];
        for (int i = 1; i < spilt.length; i++) {
            sum[i] = sum[i-1]+spilt[i];
        }
        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
           int form = queries[i][0];
              int to = queries[i][1];
              int ans = (to==0?sum[to]:sum[to-1])-sum[form];
              if(ans%2==0){
                  res[i] = true;
              }else{
                  res[i] = false;
              }
        }
        return res;
    }



    @Test
    public void test(){
        System.out.println(isArraySpecial(new int[]{1,1}, new int[][]{{0,1}}));
    }
}
