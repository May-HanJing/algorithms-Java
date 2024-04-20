package edu.hain.leetcode.weekrate391;

import org.junit.Test;

public class LeetCode100235 {

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        if(numBottles< numExchange) {
            return numBottles;
        }
        int res = numBottles;

        int ans = 0;
        int emptyBottle = numBottles;
         while(emptyBottle>=numExchange) {
            ans+=1;
            res += 1;
            emptyBottle =  emptyBottle - numExchange;
             numExchange +=1;
             if(emptyBottle<numExchange) {
                 emptyBottle += ans;
                 ans = 0;
             }
         }
        return  res;
    }


    @Test
    public void test() {
        //System.out.println(maxBottlesDrunk(13, 6));
        System.out.println(maxBottlesDrunk(10, 3));
       // System.out.println(maxBottlesDrunk(5, 5));
//System.out.println(maxBottlesDrunk(2, 3));
    }
}
