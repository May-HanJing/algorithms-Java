package edu.hain.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0139 {

    StringBuilder sb = new StringBuilder();
    List<String> dict;
    List<String> list = new ArrayList<>();
    String target;

    public boolean wordBreak(String s, List<String> wordDict) {
        target = s;
        dict = wordDict;
        dfs(0);
        return list.size()>0;
    }

    private boolean dfs(int i) {
        if (sb.length() > target.length()) {
            return false;
        }
        if (sb.length() == target.length()) {
            if (sb.toString().equals(target)) {
               return true;
            }
            return false;
        }
        for (String str : dict) {
            if (target.charAt(i) == str.charAt(0) && i + str.length() <= target.length()) {
                sb.append(str);
                dfs(i + str.length());
                sb.delete(i, i + str.length());
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(wordBreak("catsandog",new ArrayList<String>(){{add("cats");add("dog");add("sand");add("and");add("cat");}}));
    }
}
