package edu.hain.leetcode;

import org.junit.Test;

import java.util.*;

public class LeetCode0049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> orDefault = map.getOrDefault(key, new ArrayList<>());
            orDefault.add(str);
            map.put(key,orDefault);
        }
        return new ArrayList<>(map.values());
    }

    @Test
    public void test(){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }
}
