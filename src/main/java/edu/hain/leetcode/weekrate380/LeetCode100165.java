package edu.hain.leetcode.weekrate380;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeetCode100165 {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        int left = 0;
        int right = 0;
        List<Integer> list = new ArrayList<>();
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        while (s.indexOf(a, left) != -1) {
            int aIndex = s.indexOf(a, left);
            aList.add(aIndex);
            left = aIndex + 1;
        }
        while (s.indexOf(b, right) != -1) {
            int aIndex = s.indexOf(b, right);
            bList.add(aIndex);
            right = aIndex + 1;
        }
        for (Integer i : aList) {
            retry:
            for (Integer j : bList) {
                if (Math.abs(i - j) <= k) {
                    list.add(i);
                    break retry;
                }
            }
        }
        return list;
    }


    @Test
    public void test() {
        String str = "isawsquirrelnearmysquirrelhouseohmy";
        String a = "my";
        String b = "squirrel";
        beautifulIndices(str, a, b, 15);

    }
}
