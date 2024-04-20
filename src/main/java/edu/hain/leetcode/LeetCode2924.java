package edu.hain.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode2924 {

    public int findChampion(int n, int[][] edges) {
    return 0;
    }

    class FindUnion{
       int[] parent;
        public FindUnion(int n) {
          parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public  int find(int a){
            while (a!=parent[a]){
                parent[a] = parent[parent[a]];
                a = parent[a];
            }
            return a;
        }

        public void union(int a,int b){
            int parnetA = find(a);
            int parnetB = find(b);
            if(parnetB==parnetA){
                return;
            }
            if(parnetB>parnetA){
                parent[parnetA] = parnetB;
            }else{
                parent[parnetB] = parnetA;
            }

        }
    }
}
