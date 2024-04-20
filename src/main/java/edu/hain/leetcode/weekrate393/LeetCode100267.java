package edu.hain.leetcode.weekrate393;

import org.junit.Test;

import java.util.*;

public class LeetCode100267 {
    public long findKthSmallest1(int[] coins, int k) {
        int len = coins.length;
        int[] times = new int[len];
        Arrays.fill(times,1);
        Arrays.sort(coins);
        Map<Long,Integer> map = new HashMap<>(len);
        PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());
        while (queue.size()<k){
            for (int i = 0; i < coins.length; i++) {
                if(i<=coins.length-2){
                    while (coins[i]*times[i]<= coins[i+1]*times[i+1]){
                        long l = (long) coins[i] * (long) times[i];
                        if(!map.containsKey(l)){
                            queue.add(l);
                            if(queue.size()==k){
                                return queue.poll();
                            }
                            map.put(l,1);
                        }
                        times[i] += 1;
                    }
                }else{
                    while (coins[i]*times[i]<= coins[0]*times[0]){
                        long l = (long) coins[i] * (long) times[i];
                        if(!map.containsKey(l)){
                            queue.add(l);
                            if(queue.size()==k){
                                return queue.poll();
                            }
                            map.put(l,1);
                        }
                        times[i] += 1;
                    }
                }

            }
        }
     return    -1;
    }

    public long findKthSmallest2(int[] coins, int k) {
        int len = coins.length;
        Arrays.sort(coins);
        Map<Long,Integer> map = new HashMap<>(len);
        PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());
      for (int i = 1;i<=k;i++){
          for (int j = 0; j < coins.length; j++) {
              long l = (long) coins[j] * (long)i;
                if(!map.containsKey(l)){
                    map.put(l,1);
                    queue.add(l);
                }
          }
      }
      while (queue.size()>=k+1){
          queue.poll();
      }
      return queue.poll();
    }



    @Test
    public void test(){
        int[] arr = {3,6,9};
        System.out.println(findKthSmallest(arr,3));
    }


        public int findKthSmallest(int[] coins, int k) {
            // 从1开始二分查找，因为我们最小的金额是硬币面额的1倍。
            // 假定所有硬币面额均小于 Integer.MAX_VALUE / k 以避免整数溢出。
            int left = 1, right = coins[0] * k;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 判断小于等于mid的倍数总数是否至少为k
                if (countMultiples(coins, mid) < k) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }

        // 计算小于等于mid的倍数总数
        private int countMultiples(int[] coins, int mid) {
            int count = 0;
            for (int coin : coins) {
                count += mid / coin; // coin的倍数小于等于mid的个数
            }
            return count;
        }


    // 示例用法


}
