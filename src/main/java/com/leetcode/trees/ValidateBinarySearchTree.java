package com.leetcode.trees;

public class ValidateBinarySearchTree {
    //    https://leetcode.com/problems/validate-binary-search-tree/
//      Time complexity: O(n)
//      Space complexity: O(n)
//    The algorithm checks whether each node in the tree adheres to the BST property
//    by ensuring that the node's value is within a specific range,
//    and then recursively validates the left and right subtrees within updated ranges.
//    If all nodes satisfy the BST conditions, the tree is considered a valid BST, and the function returns True;
//    otherwise, it returns False.
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) return false;
        return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
    }
}
