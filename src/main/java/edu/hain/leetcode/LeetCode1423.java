package edu.hain.leetcode;

public class LeetCode1423 {

    public int maxScore(int[] cardPoints, int k) {
        //计算cardPoints数组的和
        int sum = 0;
        for (int cardPoint : cardPoints) {
            sum += cardPoint;
        }
        //计算cardPoints数组的前k个元素的和
        int temp = 0;
        for (int i = 0; i < k; i++) {
            temp += cardPoints[i];
        }
        int min = temp;
        int len = cardPoints.length;
        for (int i = k; i < len; i++) {
            temp = temp + cardPoints[i] - cardPoints[i - k];
            min = Math.min(min, temp);
        }
        return sum - min;
    }
}
