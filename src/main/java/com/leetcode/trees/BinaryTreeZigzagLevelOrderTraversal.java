package com.leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

//    https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

    //    Time complexity: O(n), where n is the number of nodes in the tree.
//    We traverse the tree once.
//    Space complexity: O(n), where n is the number of nodes in the tree.
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        boolean reverse = true;
        while (!queue.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
            var size = queue.size();
            for (int i = 0; i < size; i++) {
                var node = queue.poll();
                curr.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            if (reverse)
                result.add(curr);
            else {
                List<Integer> reverseList = new ArrayList<>();
                for (int i = size - 1; i >= 0; i--) {
                    reverseList.add(curr.get(i));
                }
                result.add(reverseList);
            }
            reverse = !reverse;
        }
        return result;
    }

    //    Time complexity: O(n), where n is the number of nodes in the tree.
//    We traverse the tree once.
//    Space complexity: O(n), where n is the number of nodes in the tree.
    public List<List<Integer>> zigzagLevelOrderOptimize(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        boolean reverse = true;
        while (!queue.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
            var size = queue.size();
            for (int i = 0; i < size; i++) {
                if (reverse) {
                    var node = queue.pollFirst();
                    curr.add(node.val);
                    if (node.left != null)
                        queue.addLast(node.left);
                    if (node.right != null)
                        queue.addLast(node.right);
                } else {
                    var node = queue.pollLast();
                    curr.add(node.val);
                    if (node.right != null)
                        queue.addFirst(node.right);
                    if (node.left != null)
                        queue.addFirst(node.left);
                }
            }
            result.add(curr);
            reverse = !reverse;
        }
        return result;
    }
}
