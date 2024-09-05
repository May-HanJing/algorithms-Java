package edu.hain.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode0826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Map<Integer,Integer> map = new HashMap<>();
        // 存储难度和收益的对应关系
        for (int i = 0; i < difficulty.length; i++) {
            map.put(difficulty[i], Math.max(map.getOrDefault(difficulty[i], 0), profit[i])); // 记录难度)
        }
        Arrays.sort(difficulty);
        for (int i = 0; i < profit.length; i++) {
            profit[i] = map.get(difficulty [i]); // 更新收益
        }

        int res = 0;
        Arrays.sort(worker);
        int[] dp = new int[worker.length];
        dp[0] = worker[0]>= difficulty[0] ? profit[0] : 0;
        res += dp[0]; // 累加收益
        // 存储难度和收益的对应关系
        for (int i = 1; i < worker.length; i++) {
            if(worker[i]>=difficulty[i]){
                dp[i] = Math.max(dp[i-1],profit[i]);
            }else{
                int j = i;
                while(j>=0 && difficulty[j]>worker[j]){
                    j--;
                }
                if(j>=0){
                    dp[i] = Math.max(dp[j],profit[j]);
                }

            }
            res += dp[i]; // 累加收益
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(maxProfitAssignment(new int[]{2,4,6,8,10},new int[]{10,20,30,40,50},new int[]{4,5,6,7}));
    }
}