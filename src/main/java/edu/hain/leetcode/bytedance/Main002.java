package edu.hain.leetcode.bytedance;

import org.junit.Test;

public class Main002 {
    public boolean checkPerfectNumber(int num) {
     int sum = 1;
     int distance = (int) Math.ceil(num/2);
        for (int i = 2; i <=distance ; i++) {
            if(num%i==0){
                sum+=i;
            }
        }
        return sum == num;
    }
    @Test
    public  void test(){
        System.out.println(checkPerfectNumber(28));
    }
}
