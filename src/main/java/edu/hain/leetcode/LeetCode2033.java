package edu.hain.leetcode;

import java.util.Arrays;

public class LeetCode2033 {
    public int minOperations(int[][] grid, int x) {
        int row = grid.length;
        int col = grid[0].length;
        int[] arr = new int[row * col];
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[index++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int target = arr[row * col/2];
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int abs = Math.abs(arr[i] - target);
            if(abs %x!=0){
                return -1;
            }
            res += Math.abs(arr[i] - target)/x;
        }
        return res;
    }
    /**
     * 快排
     */
    public void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int temp = arr[left];
        while (i < j) {
            while (i < j && arr[j] >= temp) {
                j--;
            }
            while (i < j && arr[i] <= temp) {
                i++;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }


}
