package edu.hain.leetcode.weekrate393;

public class LeetCode100256 {

    public String findLatestTime(String s) {
        char[] time = s.toCharArray();

        // 如果小时的十位是"?"，根据小时的个位确定它应该替换成什么
        if (time[0] == '?') {
            if (time[1] == '?' || time[1] < '4') {
                time[0] = '1';
            } else {
                time[0] = '0';
            }
        }

        // 如果小时的个位是"?"，根据小时的十位确定它应该替换成什么
        if (time[1] == '?') {
            if (time[0] == '1') {
                time[1] = '1'; // 11点
            } else {
                time[1] = '9'; // 09点
            }
        }

        // 如果分钟的十位是"?"，它可以被替换成5，因为分钟的最大值是59
        if (time[3] == '?') {
            time[3] = '5';
        }

        // 如果分钟的个位是"?"，它可以被替换成9
        if (time[4] == '?') {
            time[4] = '9';
        }

        return new String(time);
    }
}
