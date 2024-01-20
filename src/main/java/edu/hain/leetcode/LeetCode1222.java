package edu.hain.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1222 {
    int row;
    int col;
    int[][] flags;
    int[][] array = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}};

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new ArrayList<>();
        row = 8;
        col = 8;
        flags = new int[row][col];
        for (int[] queen : queens) {
            flags[queen[0]][queen[1]] = 1;
        }
        for (int[] ints : array) {
            dfs(king[0],king[1],ints[0],ints[1]);
        }
        for (int m = 0; m < row; m++) {
            for (int k = 0; k < col; k++) {
                if (flags[m][k] == 2) {
                    result.add(Arrays.asList(m, k));
                }
            }
        }
        return result;
    }

    void dfs(int x, int y, int a, int b) {
        while (x >= 0 && y >= 0 && x < row && y < col) {
            if (flags[x][y] == 1) {
                flags[x][y] = 2;
                break;
            }
            x -= a;
            y -= b;
        }
    }

    @Test
    public void ableToAddresses() throws Exception {
        int[][] arr = {{5, 6}, {7, 7}, {2, 1}, {0, 7}, {1, 6}, {5, 1}, {3, 7}, {0, 3}, {4, 0}, {1, 2}, {6, 3}, {5, 0}, {0, 4}, {2, 2}, {1, 1}, {6, 4}, {5, 4}, {0, 0}, {2, 6}, {4, 5}, {5, 2}, {1, 4}, {7, 5}, {2, 3}, {0, 5}, {4, 2}, {1, 0}, {2, 7}, {0, 1}, {4, 6}, {6, 1}, {0, 6}, {4, 3}, {1, 7}};
        queensAttacktheKing(arr, new int[]{3, 4});
    }
}
