package edu.hain.leetcode.weekrate382;

public class LeetCode100179 {
    /**
     * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
     * 一次操作中，你可以选择 nums 中满足 0 <= i < nums.length - 1 的一个下标 i ，并将 nums[i] 和 nums[i + 1] 替换为数字 nums[i] & nums[i + 1] ，其中 & 表示按位 AND 操作。
     * 请你返回 至多 k 次操作以内，使 nums 中所有剩余元素按位 OR 结果的 最小值
     */
    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        int max = 1024;
        int[][] f = new int[k][max];
        int[] g = new int[k];
        for (int i = 0; i < k; i++) {
            int size = 0;
            int[] cnt = new int[max];
            for (int j = i; j < n; j += k) {
                cnt[nums[j]]++;
                size++;
            }
            if (i == 0) {
                for (int j = 0; j < max; j++) {
                    f[0][j] = size - cnt[j];
                    g[0] = Math.max(g[0], f[0][j]);
                }
            } else {
                for (int j = 0; j < max; j++) {
                    f[i][j] = g[i - 1] + size;
                    for (int u = i; u < n; u += k) {
                        f[i][j] = Math.min(f[i][j], f[i - 1][j ^ nums[u]] + size - cnt[nums[u]]);
                    }
                    g[i] = Math.max(g[i], f[i][j]);
                }
            }
        }
        return f[k - 1][0];
    }
}
