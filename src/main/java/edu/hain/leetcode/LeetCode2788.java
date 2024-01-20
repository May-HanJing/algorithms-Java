package edu.hain.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode2788 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        String string = "\\"+separator;
        for(String str: words){
            String[] split = str.split(string);
            for (String s : split) {
                if(s!=null && !s.isEmpty()){
                    res.add(s);
                }
            }
        }

        return res;
    }

    @Test
    public void test(){
        List<String> words = Arrays.asList("hello.world", "llo.world.rtr", "hello");
        List<String> res = splitWordsBySeparator(words, '.');
        System.out.println(res);
    }
}
