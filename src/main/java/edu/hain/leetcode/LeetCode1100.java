package edu.hain.leetcode;

import org.junit.Test;

public class LeetCode1100 {
    public int numKLenSubstrNoRepeats(String s, int k) {
      int res = 0;
      int[] cnt = new int[26];
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            cnt[s.charAt(r) - 'a'] += 1;
            while (cnt[s.charAt(r) - 'a'] > 1) {
                cnt[s.charAt(l) - 'a']--;
                l++;
            }
            if (r - l + 1 == k) {
                res++;
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(numKLenSubstrNoRepeats("havefunonleetcode", 5));
    }
}
