package edu.hain.leetcode.weekrate382;

import org.junit.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class LeetCode100206 {
    /**
     * 给你一个 正整数 数组 nums 。
     * 你需要从数组中选出一个满足下述条件的子集：
     * 你可以将选中的元素放置在一个下标从 0 开始的数组中，并使其遵循以下模式：[x, x2, x4, ..., xk/2, xk, xk/2, ..., x4, x2, x]（注意，k 可以是任何 非负 的 2 的幂）。例如，[2, 4, 16, 4, 2] 和 [3, 9, 3] 都符合这一模式，而 [2, 4, 8, 4, 2] 则不符合。
     * 返回满足这些条件的子集中，元素数量的 最大值 。
     *
     */

    public int maximumLength(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.naturalOrder());
        for (int num : nums) {
            Integer orDefault = map.getOrDefault(num, 0);
            map.put(num, orDefault + 1);
        }
        if(map.size()==nums.length){
            return 1;
        }
        int max = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            Integer key = entry.getKey();
            if(key==1){
                max = Math.max(max,entry.getValue()%2==0?entry.getValue()-1:entry.getValue());
                continue;
            }
            int count= entry.getValue()>=2?2:1;
            if(count==1){
                max = Math.max(max,count);
                continue;
            }
            int pow = 2;
            int ans = 2;
            int powValue = (int)Math.pow(key, pow);
            while (map.containsKey(powValue)){
                if(map.containsKey(powValue)){
                    if( map.get(powValue)>=2){
                        ans +=2;
                        pow *=2;
                        powValue = (int)Math.pow(key, pow);
                    }else if(map.get(powValue)==1){
                        ans +=1;
                        break;
                    }
                }
            }
            ans = ans%2==0?ans-1:ans;
            max = Math.max(max,ans);

        }

        return  max;
    }

    @Test
    public void test(){
        int[] nums = {4,36,9,16,1,1,4,121,64,4};
        int i = maximumLength(nums);
        System.out.println(i);
    }


}
