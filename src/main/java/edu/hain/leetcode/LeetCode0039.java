package edu.hain.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode0039 {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> stack = new LinkedList<>();

    int target;
    int[] candidates;
    public List<List<Integer>> combinationSum(int[] _candidates, int _target) {
       candidates = _candidates;
       target = _target;
       dfs(0,0);
       return res;
    }

    private void dfs(int i, int sum) {
        if(sum>target){
            return;
        }
        if(sum==target){
            res.add(new ArrayList<>(stack));
            return;
        }
        dfs(i,sum);
       stack.addLast(i);
       dfs(i,sum+candidates[i]);
       stack.pollLast();
    }
}
