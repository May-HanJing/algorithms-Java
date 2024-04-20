package edu.hain.leetcode.jd;

import org.junit.Test;

import java.util.*;

public class Main005 {

    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer,Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Map<Integer, List<Integer>> countMap = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            List<Integer> aDefault = countMap.getOrDefault(entry.getValue(), new ArrayList<>());
            aDefault.add(entry.getKey());
            countMap.put(entry.getValue(),aDefault);
            if(!queue.contains(entry.getValue())){
                queue.add(entry.getValue());
            }
        }
        int[] sum = new int[nums.length];
        int index = 0;
        while (!queue.isEmpty() && k!=0){
            Integer poll = queue.poll();
            List<Integer> integers = countMap.get(poll);
            for (Integer integer : integers) {
                sum[index++] = integer;
                 k -= 1;
                 if(k==0){
                     break;
                 }
            }
        }
        return Arrays.copyOf(sum,index);
    }

    @Test
    public void test(){
        int[] arr = {4,1,-1,2,-1,2,3};
        int[] ints = topKFrequent(arr, 2);
        System.out.println(Arrays.toString(ints));
    }
}
