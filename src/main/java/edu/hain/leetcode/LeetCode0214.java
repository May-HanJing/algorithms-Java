package edu.hain.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode0214{
    List<List<Integer>> list = new ArrayList<>();
    LinkedList<Integer> stack = new LinkedList<>();

    int target;

    int len;
    public List<List<Integer>> combinationSum3(int k, int n) {
        target = n;
        len = k;
        dfs(0,0);
        return list;
    }

    public void dfs1(int index, int sum){
        if(stack.size() == len){
            if(sum == target){
                list.add(new ArrayList<>(stack));
            }
            return;
        }
        for(int i = index+1;i<=9;i++){
            stack.addLast(i);
            dfs(i,sum+i);
            stack.pollLast();
        }
    }
    public void dfs(int index, int sum){
        if(stack.size() == len){
            if(sum == target){
                list.add(new ArrayList<>(stack));
            }
            return;
        }
        if(index<len){
            dfs(index+1,sum);

        }
        stack.addLast(index);
        dfs(index+1,sum+index);
        stack.pollLast();

    }


    @Test
    public void test(){
        System.out.println(combinationSum3(3, 9));
    }
}
