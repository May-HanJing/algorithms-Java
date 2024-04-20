package edu.hain.leetcode.weekrate391;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode100240 {
    /**
      给你一个下标从 0 开始的数组 points ，它表示二维平面上一些点的整数坐标，其中 points[i] = [xi, yi] 。
      两点之间的距离定义为它们的曼哈顿距离。
      请你恰好移除一个点，返回移除后任意两点之间的 最大 距离可能的 最小 值。
     */

    public int minimumDistance(int[][] points) {
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();

        for (int[] point : points) {
            xList.add(point[0]);
            yList.add(point[1]);
        }

        int minX = findMinDistance(xList);
        int minY = findMinDistance(yList);

        return Math.max(minX, minY);
    }

    private int findMinDistance(List<Integer> list) {
        list.sort(null);
        int n = list.size();
        int minDistance = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            int distance = list.get(i) - list.get(i-1);
            if (i != 1 && i != n-1) {
                distance /= 2;
            }
            minDistance = Math.min(minDistance, distance);
        }

        return minDistance;
    }

@Test
    public void test(){
        System.out.println(minimumDistance(new int[][]{{3, 10}, {5, 15}, {10, 2},{4,4}}));
}

}
