package edu.hain.common;

import java.util.LinkedList;

/**
 * @author HanJing
 */
public class TreeNodeUtils {
    public static TreeNode buildTree(Integer[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        for (Integer integer : A) {
            TreeNode node = integer != null ? new TreeNode(integer) : null;
            queue.addLast(node);
        }
        TreeNode root = queue.pollFirst();
        //存放父亲节点（上一层节点）
        LinkedList<TreeNode> fatherNode = new LinkedList<>();
        // 存放当前节点
        LinkedList<TreeNode> sonNode = new LinkedList<>();
        fatherNode.addLast(root);
        // 层次遍历 记录不是空节点的个数 用来决定下一层应该有多少个节点
        int noEmpty = 1;
        while (!queue.isEmpty()) {
            //确定下一层节点个数
            int size = 2 * noEmpty;
            // 最后一层叶子可能不满，所以记录最后一层多少节点
            if (queue.size() < size) {
                size = queue.size();
            }
            noEmpty = 0;
            while (size != 0) {
                //计算不为空节点的个数
                TreeNode first = queue.pollFirst();
                if (first != null) {
                    noEmpty++;
                }
                sonNode.addLast(first);
                size--;
            }
            int i = 0;
            int j = 0;
            for (i = 0; i < fatherNode.size(); i++) {
                TreeNode node = fatherNode.get(i);
                //如果当前节点是空的，则不需要给他分配左右子树节点
                if (node == null) {
                    continue;
                }
                int left = 2 * j;
                int right = 2 * j + 1;
                j++;
                // 分配左右子树节点 另外对边界进行一个验证
                if (left < sonNode.size()) {
                    node.left = sonNode.get(left);
                }
                if (right < sonNode.size()) {
                    node.right = sonNode.get(right);
                }
            }
            //给上一层节点都绑定了左右子树 所以层数往下移动 当前节点层数充当下一次的父节点层数
            fatherNode.clear();
            fatherNode.addAll(sonNode);
            sonNode.clear();
        }
        return root;
    }
}
