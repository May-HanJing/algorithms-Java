package edu.hain.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1165 {

    public int calculateTime(String keyboard, String word) {
       Map<Character,Integer> map = new HashMap<>(keyboard.length());
        for (int i = 0; i < keyboard.length(); i++) {
            map.put(keyboard.charAt(i),i);
        }
        int res = 0;
        int pre = 0;
        for (int i = 0; i < word.length(); i++) {
            res += Math.abs(map.get(word.charAt(i))-pre);
            pre = map.get(word.charAt(i));
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(calculateTime("pqrstuvwxyzabcdefghijklmno","leetcode"));
    }
}
