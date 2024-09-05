package edu.hain.leetcode;

public class LeetCode0072 {
    String s;
    String t;
    public int minDistance(String word1, String word2) {
        s = word1;
        t = word2;
        return dfs(word1.length()-1,word2.length()-1);
    }

    private int dfs(int i, int j) {
        if(i<0){
            return j+1;
        }
        if (j<0){
            return i+1;
        }
        if(s.charAt(i)==t.charAt(j)){
            return dfs(i-1,j-1);
        }
        return Math.min(dfs(i-1,j-1)+1,Math.min(dfs(i-1,j),dfs(i,j-1)))+1;
    }
}
