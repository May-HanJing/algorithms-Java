package edu.hain.leetcode;

import org.junit.Test;

import java.util.*;

import static java.util.Comparator.*;

public class LeetCode2182 {
    public String repeatLimitedString(String s, int repeatLimit) {
        Map<Character, Integer> map = new TreeMap<>();
        for (char c : s.toCharArray()) {
            Integer orDefault = map.getOrDefault(c, 0);
            map.put(c, orDefault + 1);
        }
        StringBuilder sb = new StringBuilder();

        LinkedList<Map.Entry<Character, Integer>> list = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            list.addFirst(entry);
        }
        while (!list.isEmpty()) {
            Map.Entry<Character, Integer> poll = list.poll();
            if(sb.length()>0 && poll.getKey()==sb.charAt(sb.length()-1)){
                break;
            }
            Map.Entry<Character, Integer> entry = list.peekFirst();
            if(entry!=null &&entry.getKey().compareTo(poll.getKey())>0){
                sb.append(poll.getKey());
                if(poll.getValue()-1>0){
                    poll.setValue(poll.getValue()-1);
                    int index =list.isEmpty()?0:1;
                    list.add(index,poll);
                }
            }else {
                if (poll.getValue() <= repeatLimit) {
                    for (int i = 0; i < poll.getValue(); i++) {
                        sb.append(poll.getKey());
                    }
                } else {
                    for (int i = 0; i < repeatLimit; i++) {
                        sb.append(poll.getKey());
                    }
                    poll.setValue(poll.getValue() - repeatLimit);
                    int index =list.isEmpty()?0:1;
                    list.add(index,poll);
                }
            }
        }

        return sb.toString();
}

    @Test
    public  void test(){
        String s = "robnsdvpuxbapuqgopqvxdrchivlifeepy";
        String s1 = repeatLimitedString(s, 2);
        System.out.println(s1);
        //yxxvvuvusrrqqppopponliihgfeeddcbba
       // yxxvvuvusrrqqppopponliihgfeeddcbba
    }
}
