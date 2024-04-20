package edu.hain.leetcode.weekrate382;

public class LeetCode100215 {
    public int countKeyChanges(String s) {
     s = s.toUpperCase();
     int i = 0;
     int j = 1;
        int count = 0;
        while (j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                count++;
            }
            i++;
            j++;
        }
        return count;
    }
}
