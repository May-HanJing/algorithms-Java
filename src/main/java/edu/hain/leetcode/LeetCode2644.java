package edu.hain.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode2644 {

    public int maxDivScore(int[] nums, int[] divisors) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> divMap = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int divisor : divisors) {
            divMap.put(divisor, 0);
        }
        int res = Integer.MAX_VALUE;
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : divMap.entrySet()) {
            for (Map.Entry<Integer, Integer> integerEntry : map.entrySet()) {
                if (integerEntry.getKey() % entry.getKey() == 0) {
                    divMap.put(entry.getKey(), divMap.get(entry.getKey()) + integerEntry.getValue());
                    max = Math.max(max, divMap.get(entry.getKey()));
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry : divMap.entrySet()) {
            if (entry.getValue() == max) {
                res = Math.min(res, entry.getKey());
            }
        }
        return res;
     }
}
