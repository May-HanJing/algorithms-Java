package edu.hain.leetcode.weekrate396;

import java.util.HashMap;
import java.util.Map;

public class LeetCode100284 {

    static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('A', 1);
        map.put('E', 1);
        map.put('I', 1);
        map.put('O', 1);
        map.put('U', 1);
    }

    public boolean isValid(String word) {
        word = word.toUpperCase();
        int YUAN = 0;
        int FU = 0;
        int NUM = 0;
        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);
            if (Character.isDigit(c)) {
                NUM++;
            } else if (Character.isLetter(c)){
                if (map.containsKey(c)) {
                    YUAN++;
                } else {
                    FU++;
                }
            }else{
                return false;
            }
        }
        return NUM+YUAN + FU>= 3 && YUAN>=1 && FU>=1;
    }
}
