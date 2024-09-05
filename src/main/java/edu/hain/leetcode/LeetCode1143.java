package edu.hain.leetcode;

public class LeetCode1143 {

    String s;
    String t;
    public int longestCommonSubsequence1(String _text1, String _text2) {
        s = _text1; t = _text2;
        int m = s.length(), n = t.length();
        return dfs(m-1,n-1);
    }

    private int dfs(int i, int j) {
        if(i<0 || j<0){
            return 0;
        }
        if(s.charAt(i)==t.charAt(j)){
            return dfs(i-1,j-1)+1;
        }
        return Math.max(dfs(i-1,j),dfs(i,j-1));
    }

    public int longestCommonSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
