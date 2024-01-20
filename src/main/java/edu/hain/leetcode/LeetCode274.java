package edu.hain.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LeetCode274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < citations.length; i++) {
            if(!map.containsKey(citations[i])){
                map.put(citations[i], citations.length-i);
            }
        }
        int key = -1;
        int res = -1;
        for(Map.Entry<Integer, Integer> item : map.entrySet()){
            if(key==-1){
                key = item.getKey();
                res = key;
            }else{
                if(item.getValue()>=item.getKey() && item.getKey()>key){
                    key = item.getKey();
                    res = key;
                }
            }
        }
       return res;
    }

    @Test
    public void testAddKeys(){
        int[] arr = {3,0,6,1,5};
        System.out.println(15&1024);
    }
}
