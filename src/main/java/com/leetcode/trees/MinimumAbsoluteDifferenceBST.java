package com.leetcode.trees;

public class MinimumAbsoluteDifferenceBST {

//    https://leetcode.com/problems/minimum-absolute-difference-in-bst/
//    Time complexity: O(n), where n is the number of nodes in the tree.
//    We traverse the tree once.
//    Space complexity: O(h), where h is the height of the tree.

    int min;
    int last;

    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        last = Integer.MAX_VALUE;
        dfs(root);
        return min;
    }

    private void dfs(TreeNode node) {
        if (node != null) {
            dfs(node.left);
            int diff = Math.abs(node.val - last);
            min = Math.min(min, diff);
            last = node.val;
            dfs(node.right);
        }
    }
}
