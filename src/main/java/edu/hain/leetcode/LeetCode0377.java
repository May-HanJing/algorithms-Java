package edu.hain.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class LeetCode0377 {
    int res = 0;

    int target;
    int[] num;
    LinkedList<Integer> stack;
    public int combinationSum4(int[] _nums, int _target) {
        stack = new LinkedList<>();
        Arrays.sort(_nums);
        num = _nums;
        target = _target;
        dfs(0,0);
        return res;
    }

    private void dfs(int index, int sum) {
        if(sum == target){
            res++;
            //System.out.println(stack);
            return;
        }
        if(sum>target){
            return;
        }
        for(int i = 0;i<num.length;i++){
           stack.add(num[i]);
            sum += num[i];
            dfs(i,sum);
            sum -= num[i];
            stack.pollLast();
        }
    }


    @Test
    public void test(){
        System.out.println(combinationSum4(new int[]{1, 2, 3}, 35));
    }
}
