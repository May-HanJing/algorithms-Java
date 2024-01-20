package edu.hain.leetcode;

import org.junit.Test;

import java.util.LinkedList;

public class LeetCode0394 {

    private String decodeString(String s){
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=']'){
                stack.addLast(s.charAt(i));
            }else{
                StringBuilder sb = new StringBuilder();
                while (stack.peekLast()!='['){
                    sb.append(stack.pollLast());
                }
                stack.pollLast();
                StringBuilder num = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peekLast())){
                    num.append(stack.pollLast());
                }
                int count = Integer.parseInt(num.reverse().toString());
                String str = sb.reverse().toString();
                for (int j = 0; j < count; j++) {
                    for (int k = 0; k < str.length(); k++) {
                        stack.addLast(str.charAt(k));
                    }
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.append(stack.pollLast());
        }
        return res.reverse().toString();
    }


    @Test
    public void test(){
        String s = "a2[b[4fg[3T]2W]c]";
        String res = decodeString(s);
        System.out.println(res);
    }
}
