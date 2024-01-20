package edu.hain.leetcode;

import org.junit.Test;

public class LeetCode1184 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
       int[] arr = new int[distance.length+1];
       int sum = 0;
         for (int i = 0; i < distance.length; i++) {
             sum += distance[i];
              arr[i+1] = arr[i] + distance[i];
         }
         return Math.min(sum-(arr[destination]-arr[start]),arr[destination]-arr[start]);
    }

    @Test
    public void test(){
        int[] arr = {1,2,3,4};
        int i = distanceBetweenBusStops(arr, 0, 1);
        System.out.println(i);
    }
}
