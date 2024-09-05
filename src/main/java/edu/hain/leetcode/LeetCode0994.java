package edu.hain.leetcode;

import org.junit.Test;

public class LeetCode0994 {
    int row;
    int col;
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    boolean[][] visited;
    int[][] grid;
    int count = 0;

    public int orangesRotting(int[][] _grid) {
          grid = _grid;
          row = grid.length;
          col = grid[0].length;
          visited = new boolean[row][col];
          for(int i=0;i<row;i++) {
              for(int j=0;j<col;j++) {
                  if(grid[i][j]==2) {
                      dfs(i,j);
                  }
              }
          }
          for(int i=0;i<row;i++) {
              for (int j=0;j<col;j++){
                  if(grid[i][j]==1){
                      return  -1;
                  }
              }
          }
          return count;
    }

    private int dfs(int i, int j) {
      if(i<0 || i>=row || j<0 || j>=col || visited[i][j] || grid[i][j]==0){
          return 0;
      }
      visited[i][j] = true;
      grid[i][j] = 2;
      int sum = 0;
        for (int[] dir : dirs) {
            sum += dfs(i+dir[0],j+dir[1]);
        }
        if(sum>0){
            count++;
        }
        return 1;
    }

    @Test
    public void test(){
        int[][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
}
