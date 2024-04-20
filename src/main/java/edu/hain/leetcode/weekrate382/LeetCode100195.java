package edu.hain.leetcode.weekrate382;

import java.util.HashMap;
import java.util.Map;

public class LeetCode100195 {

    /**
     *Alice 和 Bob 在一个长满鲜花的环形草地玩一个回合制游戏。环形的草地上有一些鲜花，Alice 到 Bob 之间顺时针有 x 朵鲜花，逆时针有 y 朵鲜花。
     * 游戏过程如下：
     * Alice 先行动。
     * 每一次行动中，当前玩家必须选择顺时针或者逆时针，然后在这个方向上摘一朵鲜花。
     * 一次行动结束后，如果所有鲜花都被摘完了，那么 当前 玩家抓住对手并赢得游戏的胜利。
     * 给你两个整数 n 和 m ，你的任务是求出满足以下条件的所有 (x, y) 对：
     * 按照上述规则，Alice 必须赢得游戏。
     * Alice 顺时针方向上的鲜花数目 x 必须在区间 [1,n] 之间。
     * Alice 逆时针方向上的鲜花数目 y 必须在区间 [1,m] 之间。
     * 请你返回满足题目描述的数对 (x, y) 的数目。
     */

    public long flowerGame(int n, int m) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>(2);
        for (int i = 1; i <=m ; i++) {
            int key = i%2==0?0:1;
            map.put(key,map.getOrDefault(key,0)+1);
        }
        // 遍历所有可能的 x 和 y 组合
        for (int x = 1; x <= n; x++) {
            int key = x%2==0?0:1;
            if(key==1){
                count += map.getOrDefault(0,0);
            }else{
                count += map.getOrDefault(1,0);
            }

        }
        return count;
    }



    public int countWinningPairs(int n, int m) {
        // 计算 n 和 m 中奇数和偶数的数量
        int oddN = (n + 1) / 2;
        int evenN = n / 2;
        int oddM = (m + 1) / 2;
        int evenM = m / 2;

        // 奇数 x 可以与奇数 y 配对，偶数 x 可以与偶数 y 配对
        return oddN * oddM + evenN * evenM;
    }



}
