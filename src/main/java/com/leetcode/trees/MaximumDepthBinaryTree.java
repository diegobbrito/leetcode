package com.leetcode.trees;

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


}
