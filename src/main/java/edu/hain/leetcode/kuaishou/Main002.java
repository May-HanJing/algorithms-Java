package edu.hain.leetcode.kuaishou;

import edu.hain.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main002 {
    public List<List<Integer>> decorateRecord(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        boolean sign = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
          while (size!=0){
              TreeNode treeNode = queue.pollFirst();
              size--;
              if (sign){
                  list.addLast(treeNode.val);
              }else {
                  list.addFirst(treeNode.val);
              }
                if (treeNode.left!=null){
                    queue.addLast(treeNode.left);
                }
                if (treeNode.right!=null){
                    queue.addLast(treeNode.right);
                }
          }
          sign = !sign;
          res.add(list);
        }
        return res;
    }
}
