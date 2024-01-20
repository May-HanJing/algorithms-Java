package edu.hain.leetcode;

import java.util.Arrays;

public class LeetCode902 {
    int[] memo;
    char[] s;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        s = String.valueOf(n).toCharArray();
        memo = new int[s.length];
        Arrays.fill(memo, -1);
        return dfs(0, true, false, digits);
    }

    int dfs(int i, boolean isLimit, boolean isNum, String[] digits) {
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && memo[i] != -1) {
            return memo[i];
        }
        if (!isNum) {
            return dfs(i + 1, false, false, digits);
        }
        int ans = 0;
        char end = isLimit ? s[i] : '9';
        for (String digit : digits) {
            if (digit.charAt(0) > end) {
                break;
            }
            ans += dfs(i + 1, isLimit && (digit.charAt(0) == end), true, digits);
        }
        if (!isLimit && isNum) {
            memo[i]= ans;
        }
        return ans;
    }
}
