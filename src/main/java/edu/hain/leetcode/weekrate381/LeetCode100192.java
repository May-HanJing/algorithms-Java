package edu.hain.leetcode.weekrate381;

import org.junit.Test;

import java.util.*;

public class LeetCode100192 {
    public int minimumPushes(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        HashSet<Integer> list = new HashSet<>(map.values());
        TreeMap<Integer, List<Character>> sortMap = new TreeMap<>(Comparator.reverseOrder());
        for (Integer integer : list) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue().equals(integer)) {
                    List<Character> orDefault = sortMap.getOrDefault(integer, new ArrayList<>());
                    orDefault.add(entry.getKey());
                    sortMap.put(integer, orDefault);
                }
            }
        }
        int ans = 0;
        int i = 1;
        int count = 1;
        for (Map.Entry<Integer, List<Character>> entry : sortMap.entrySet()) {
            int size = entry.getValue().size();
            for (int j = 0; j < size; j++) {
                int last = i % 8;
                if (last != 0) {
                    ans += count*entry.getKey();
                } else {
                    ans += count*entry.getKey();
                    count += 1;
                }
                i++;
            }
        }

        return ans;
    }

    @Test
    public void test(){
        System.out.println(minimumPushes("aabbccddeeffgghhiiiiii"));
    }
}

