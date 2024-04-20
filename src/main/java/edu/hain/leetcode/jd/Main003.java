package edu.hain.leetcode.jd;

public class Main003 {

    public boolean checkPerfectNumber(int num) {
        if(num==1){
            return  true;
        }
       int distance = (int) Math.ceil(num/2);
       int sum = 1;
       for (int i = 1; i <= distance ; i++) {
            if(num%i==0){
                sum += i;
            }

        }
       return  sum == num;
    }
}
