package edu.hain.leetcode;

public class LeetCode00392 {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0 && t.length()==0){
            return true;
        }
        int index = 0;
        int size = s.length();
        for (int i = 0; i < t.length(); i++) {
            if(index<size&&s.charAt(index)==t.charAt(i)){
                index+=1;
            }
            if(index==size){
                return true;
            }
        }
        return false;
    }
}
