package edu.hain.leetcode;

import java.util.Arrays;

public class LeetCode0300 {
    int[] visited;
    int[] nums;
    public int lengthOfLIS(int[] _nums) {
        nums = _nums;
     int len = nums.length;
     visited = new int[len];
     Arrays.fill(visited,-1);
     int res = 0;
     dfs(len-1);
        for (int i = 0; i < visited.length; i++) {
            res = Math.max(res,visited[i]);
        }
        return res;
    }

    private int dfs(int index) {
        if(visited[index]!=-1){
            return visited[index];
        }
        for(int i = 0;i<index;i++){
            if(nums[i]<nums[index]){
                if(visited[i]==-1){
                    visited[i] = dfs(i);
                }
                visited[index] = Math.max(visited[index],dfs(i))+1;
            }
        }
        return visited[index]+1;
    }
}
