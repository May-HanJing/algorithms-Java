package edu.hain;


import edu.hain.common.TreeNode;
import org.junit.Test;
import edu.hain.common.TreeNodeUtils;

public class Main {
    public static void main(String[] args) {



    }



    /**
     *
     * 滑动窗口 计算数组arr长度为len区间的最大值
     *
     */
public  int[] getMaxWindow(int[] arr, int len) {
    if (arr == null || len < 1 || arr.length < len) {
        return null;
    }
    int[] res = new int[arr.length - len + 1];
    int index = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
        max = Math.max(max, arr[i]);
        if (i >= len - 1) {
            res[index++] = max;
            max = Integer.MIN_VALUE;
        }
    }
    return res;
}

@Test
 public void test(){
    int[] arr = {1,5,7,3,5,7,89,0,56,12,43,5,6,1};
    getMaxWindow(arr,3);
}


}