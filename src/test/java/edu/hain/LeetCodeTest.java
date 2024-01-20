package edu.hain;

import edu.hain.leetcode.LockingTree;
import org.junit.Test;

public class LeetCodeTest {

    @Test
    public void test(){
        LockingTree lockingTree = new LockingTree(new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(lockingTree.lock(2, 2));
        System.err.println(lockingTree.unlock(2, 3));
        System.err.println(lockingTree.unlock(2, 2));
        System.err.println(lockingTree.lock(4, 5));
        System.err.println(lockingTree.upgrade(0, 1));
        System.err.println(lockingTree.lock(0, 1));
    }
}
