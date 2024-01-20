package edu.hain.leetcode;

import edu.hain.common.TreeNode;
import edu.hain.common.TreeNodeUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode0094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty()|| root!=null){
            if (root!=null){
                stack.addLast(root);
                root = root.left;
            }else{
                TreeNode node = stack.pollLast();
                nums.add(node.val);
                root = node.right;
            }

        }
        return nums;
    }

    @Test
    public void test(){
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, null, 2, 3, 5, 6, 7, 8, 9});
        System.out.println(treeNode);
        List<Integer> integers = inorderTraversal(treeNode);
        System.out.println(integers);
    }
}
