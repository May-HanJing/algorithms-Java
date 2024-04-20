package edu.hain.leetcode.jd;

public class Main009 {
    public boolean isPalindrome(int x) {
     String string = String.valueOf(x);
     int i = 0;
     int j = string.length();
     while (i<j){
         if(string.charAt(i)!=string.charAt(j)){
             return false;
         }
         i++;
         j--;
     }
     return  true;
    }
}
