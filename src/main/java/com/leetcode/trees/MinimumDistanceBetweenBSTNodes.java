package com.leetcode.trees;

public class MinimumDistanceBetweenBSTNodes {
    //    https://leetcode.com/problems/minimum-distance-between-bst-nodes/
// Time Complexity O(n)
// Space Complexity O(n)
    int min;
    int last;
    public int minDiffInBST(TreeNode root) {
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
