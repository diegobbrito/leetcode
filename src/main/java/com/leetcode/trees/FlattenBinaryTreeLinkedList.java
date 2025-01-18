package com.leetcode.trees;

public class FlattenBinaryTreeLinkedList {
    //    https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//    Time complexity: O(n), where n is the number of nodes in the tree.
//    We traverse the tree once.
//    Space complexity: O(h), where h is the height of the tree.
    public void flatten(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return;

        if (root.left != null) {
            var right = root.right;
            root.right = root.left;
            root.left = null;
            flatten(root.right);
            while (root.right != null)
                root = root.right;
            root.right = right;
        }
        flatten(root.right);
    }
}
