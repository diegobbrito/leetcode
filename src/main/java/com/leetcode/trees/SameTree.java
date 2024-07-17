package com.leetcode.trees;

public class SameTree {
    // Time complexity O(p +q)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null || p.val != q.val) // Check if only one element is null or if the values are different
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); // Return the comparison with the left and right side of the tree
    }
}
