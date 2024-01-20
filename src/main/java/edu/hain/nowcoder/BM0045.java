package edu.hain.nowcoder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class BM0045 {
    public ArrayList<Integer> maxInWindows (int[] num, int size) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>();
        int start = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        while (start<num.length){
            while (!queue.isEmpty()&& num[queue.peekLast()]<num[start]){
                queue.pollLast();
            }
            queue.add(start);
            if(start-queue.peekFirst()>=size){
                queue.pollFirst();
            }
            if(start>=size-1){
                res.add(num[queue.peekFirst()]);
            }

        }
        return res;
    }

    /**
     * 给定一个长度为 n 的数组 num 和滑动窗口的大小 size ，找出所有滑动窗口里数值的最大值。
     * 例如，如果输入数组 num 为 [2, 3, 4, 2, 6, 2, 5, 1]，滑动窗口的大小 size 为 3，
     *
     */










    /*@Test
    public void test(){
        int[] arr = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> integers = maxInWindows(arr, 3);
        System.out.println(integers);
    }*/
}
