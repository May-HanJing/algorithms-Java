package edu.hain.leetcode.weekrate381;

import org.junit.Test;

public class LeetCode100119 {
    public int minimumPushes(String word) {
         int size = word.length();
         int count = 1;
         int ans = 0;
         for (int i = 1; i <= size; i++) {
           int last =  i%8;
           int time = i/8;
           if(last!=0){
             ans += count;
           }else{
               ans += count;
               count += 1;
           }
         }
        return  ans;
    }

    @Test
    public void test(){
        System.out.println(minimumPushes("xycdefghij"));
    }
}
