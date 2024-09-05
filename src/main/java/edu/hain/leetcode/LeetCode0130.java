package edu.hain.leetcode;

public class LeetCode0130 {

    int m, n;
    int[][] location = {{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
       m = board.length;
       n = board[0].length;
       for(int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               if (board[i][j] == 'O'){
                   dfs(i,j,board);
               }
           }
       }
    }

    private void dfs(int i, int j, char[][] board) {
      if(i<0 || i>=m || j<0 || j>=n || board[i][j] != 'O'){
          return;
      }
      if(i==0 || j==0 || i==m-1 ||j==n-1){
          return;
      }
      board[i][j] = 'X';
        for (int[] ints : location) {
            dfs(i + ints[0], j + ints[1], board);
        }

    }
}
