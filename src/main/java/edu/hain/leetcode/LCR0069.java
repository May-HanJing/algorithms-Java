package edu.hain.leetcode;

import java.util.LinkedList;

public class LCR0069 {
    public int peakIndexInMountainArray(int[] arr) {
        int temp = arr[0];
        int index = 0;
        for(int i = 1;i<arr.length;i++){
            if(arr[i]>temp){
                temp = arr[i];
                index = i;
            }else{
                break;
            }
        }
        return index;
    }
}
