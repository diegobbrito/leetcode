package com.leetcode.trees;

import java.util.Stack;

public class SymmetricTree {
    //    https://leetcode.com/problems/symmetric-tree/
    // Time Complexity O(n)
    // Space Complexity O(n) worst-case, O(logN) best-case
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    // Time Complexity O(n)
    // Space Complexity O(n) worst-case, O(logN) best-case
    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if (left.val != right.val) {
                return false;
            }
            if (left.left != null && right.right != null) {
                stack.push(left.left);
                stack.push(right.right);
            } else if (left.left != null || right.right != null) {
                return false;
            }
            if (left.right != null && right.left != null) {
                stack.push(left.right);
                stack.push(right.left);
            } else if (left.right != null || right.left != null) {
                return false;
            }
        }
        return true;
    }
}
