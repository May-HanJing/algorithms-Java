package edu.hain.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LeetCode2861 {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stockTemp, List<Integer> costTemp) {
      int ans = 0;
        int[] cost = costTemp.stream().mapToInt(i -> i).toArray();
        for (List<Integer> list : composition) {
            int[] ints = list.stream().mapToInt(i -> i).toArray();
            int[] stock = stockTemp.stream().mapToInt(i -> i).toArray();
            int curCost = 0;
            int count = 0;
            while(curCost<=budget){
                for (int i = 0; i < ints.length; i++) {
                    if(ints[i]<=stock[i]) {
                         stock[i] -= ints[i];
                    }else{
                         curCost += (ints[i]-stock[i]) *cost[i];
                         stock[i] = 0;
                         if(curCost>budget){
                             break;
                         }
                    }
                }
                if(curCost<=budget){
                    count++;
                }

            }
            ans = Math.max(ans,count);
        }
        return  ans;
    }

    @Test
    public void test(){
        int n = 8;
        int k = 4;
        int budget = 196;
        List<List<Integer>> composition = Arrays.asList(Arrays.asList(5,2,3,4,7,3,3,1),Arrays.asList(1,5,9,9,6,1,9,7),
                Arrays.asList(5,8,3,10,2,4,8,7),Arrays.asList(9,9,5,9,6,8,4,3));
        List<Integer> stock = Arrays.asList(3,5,3,6,1,5,8,1);
        List<Integer> cost = Arrays.asList(4,5,4,9,4,8,7,5);
        System.out.println(maxNumberOfAlloys(n,k,budget,composition,stock,cost));
    }
}
