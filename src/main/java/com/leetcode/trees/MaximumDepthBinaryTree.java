package com.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthBinaryTree {
//    https://leetcode.com/problems/maximum-depth-of-binary-tree/

    // DFS Recursive
    // Time complexity O(n)
    // Time complexity O(n)
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // BFS
    public int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                var node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            depth++;
        }
        return depth;
    }


}
