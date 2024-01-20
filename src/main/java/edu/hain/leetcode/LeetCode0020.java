package edu.hain.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LeetCode0020 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>(4);
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        char[] chars = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                stack.addLast(aChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pollLast();
                if (map.get(pop) != aChar) {
                    return false;
                }
            }
        }
        return true;
    }
}
