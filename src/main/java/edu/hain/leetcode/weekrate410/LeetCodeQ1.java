package edu.hain.leetcode.weekrate410;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LeetCodeQ1 {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int res = -1;
        int i = 0;
        int j = 0;
        for (String command : commands) {
            if ("UP".equals(command)) {
                i -= 1;
            } else if ("DOWN".equals(command)) {
                i += 1;
            } else if ("LEFT".equals(command)) {
                j -= 1;
            } else {
                j += 1;
            }
        }
        return n * i +j;
    }

    @Test
    public void test(){
        System.out.println(finalPositionOfSnake(3, Arrays.asList("DOWN","RIGHT","UP")));
    }
}
