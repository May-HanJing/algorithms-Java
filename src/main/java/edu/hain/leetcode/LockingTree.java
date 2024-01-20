package edu.hain.leetcode;

import org.junit.Test;

import java.util.*;

public class LockingTree {

    Map<Integer, List<Integer>> fatherMap = new HashMap<>();
    Map<Integer, Integer> sonsMap = new HashMap<>();

    Map<Integer, Integer>  lockStatusMap = new HashMap<>();

    List<Integer> upLock = new ArrayList<>();

    int count = 0;
    public LockingTree(int[] parent) {
        for (int i = 0; i < parent.length; i++) {
            List<Integer> orDefault = fatherMap.getOrDefault(parent[i], new ArrayList<>());
            orDefault.add(i);
            fatherMap.put(parent[i], orDefault);
            sonsMap.put(i,parent[i]);
        }
    }

    public boolean lock(int num, int user) {
        if(lockStatusMap.containsKey(num)){
            return false;
        }
        if(!sonsMap.containsKey(user)||!sonsMap.containsKey(num)){
            return false;
        }
        lockStatusMap.put(num,user);
        return true;
    }

    public boolean unlock(int num, int user) {
        if(!sonsMap.containsKey(user)||!sonsMap.containsKey(num)){
            return false;
        }
       if(lockStatusMap.containsKey(num)&&lockStatusMap.get(num)==user){
           lockStatusMap.remove(num);
           return true;
       }
       return false;
    }

    public boolean upgrade(int num, int user) {
       if(lockStatusMap.containsKey(num)){
           return false;
       }
       //没上锁，开始找对应的子节点没上锁
        if(checkFather(sonsMap.get(num)) && checkSon(num)){
            count = 0;
            for (Integer i : upLock) {
                lockStatusMap.remove(i);
            }
            return lock(num,user);
        }
        return false;
    }
    public boolean checkSon(int num){
        if(lockStatusMap.containsKey(num)){
            count += 1;
            if(count>=1){
                return true;
            }
            upLock.add(num);
        }
        if(!fatherMap.containsKey(num)){
            return true;
        }
        boolean sign = true;
        List<Integer> integers = fatherMap.get(num);
        for (Integer integer : integers) {
            sign &=checkSon(integer);
        }
        return sign;
    }

    public boolean checkFather(int num){
        if(lockStatusMap.containsKey(num)){
            return false;
        }
        if(!sonsMap.containsKey(num)){
            return true;
        }
        return checkSon(sonsMap.get(num));
    }



}
