package edu.hain.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode2391 {


    public int garbageCollection(String[] garbage, int[] travel) {
        int[] G = new int[garbage.length];
        int[] M = new int[garbage.length];
        int[] P = new int[garbage.length];
        for (int i = 0; i < garbage.length; i++) {
            String str = garbage[i];
            for (char c : str.toCharArray()) {
                if(c=='G'){
                    G[i]++;
                }else if(c=='M'){
                    M[i]++;
                }else{
                    P[i]++;
                }
            }
        }
        return help(M,travel)+help(G,travel)+help(P,travel);
    }

    private int help(int[] arr, int[] travel) {
        int len = arr.length-1;
        while (len>=0 && arr[len]==0){
            len--;
        }
        int res = 0;
        while (len>=0){
            res += arr[len]+(len-1>=0?travel[len-1]:0);
            len--;
        }
        return res;
    }





    @Test
    public void test(){
        String[] res = {"MMM","PGM","GP"};
        int[] ints = {3,10};
        System.out.println(garbageCollection(res, ints));
    }
}
