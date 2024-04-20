package edu.hain.leetcode.jd;

public class Main002 {

    public int fixedPoint(int[] arr) {
     int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if(i==arr[i]){
                index = i;
                break;
            }
        }
     return  index;
    }
}
