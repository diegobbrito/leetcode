package com.leetcode.trees;

public class SubtreeAnotherTree {
    //    https://leetcode.com/problems/subtree-of-another-tree/
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // If subRoot is null, it is always considered a subtree
        if (subRoot == null) return true;

        // If root is null but subRoot is not, subRoot cannot be a subtree
        if (root == null) return false;

        // Check if the current trees rooted at root and subRoot are the same
        if (isSameTree(root, subRoot)) return true;

        // Recursively check the left and right subtrees of the current root
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode newRoot, TreeNode subRoot) {
        // If both nodes are null, they are the same (base case)
        if (newRoot == null && subRoot == null) return true;

        // If one of the nodes is null or the values do not match, they are not the same
        if (newRoot == null || subRoot == null || newRoot.val != subRoot.val) return false;

        // Recursively check if the left and right children are the same
        return isSameTree(newRoot.left, subRoot.left) && isSameTree(newRoot.right, subRoot.right);
    }


}
