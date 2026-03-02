package com.leetcode.trees;

public class SumRootToLeafBinaryNumbers {

    //https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers
    // Time Complexity O(n)
    // Space Complexity O(h)

    public int sumRootToLeaf(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode node, int current) {
        if (node == null)
            return 0;

        current = (current << 1) | node.val;
//        current = current * 2 + node.val;

        if (node.left == null && node.right == null)
            return current;

        return helper(node.left, current) + helper(node.right, current);
    }
}
