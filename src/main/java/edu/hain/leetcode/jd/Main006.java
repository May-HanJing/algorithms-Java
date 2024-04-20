package edu.hain.leetcode.jd;

import org.junit.Test;

public class Main006 {
    int[][] location = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int ans = 0;
    int[][] matrix;
    int row;
    int col;
    int temp = 0;
    ;
    boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        visited = new boolean[row][col];
        matrix = grid;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    dfs(i, j);
                    ans = Math.max(ans, temp);
                    temp = 0;
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j] || matrix[i][j]!=1) {
            return;
        }
        visited[i][j] = true;
        matrix[i][j] = -1;
        temp += 1;
        for (int[] ints : location) {
            dfs(i + ints[0], j + ints[1]);
        }
    }

    @Test
    public void test() {
        int[][] arr = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(arr));
    }
}
