package edu.hain.leetcode.jd;

import org.junit.Test;

public class Main004 {

    public int maxRepeating(String sequence, String word) {
        int count = 0;
        String tmp = word;
        while (sequence.contains(word)) {
            word += tmp;
            count++;
        }
        return count;
    }
    @Test
    public void test(){
        String str = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
        System.out.println(maxRepeating(str,"aaaba"));
    }
    //aaaba aaab aaaba aaaba aaaba aaaba aaaba
}
