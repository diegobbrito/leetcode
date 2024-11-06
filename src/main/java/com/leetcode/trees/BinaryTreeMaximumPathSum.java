package com.leetcode.trees;

public class BinaryTreeMaximumPathSum {
    //    https://leetcode.com/problems/binary-tree-maximum-path-sum/
//    Time & Space Complexity
//Time complexity: O(n)
//Space complexity: O(n)
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftMax = Math.max(dfs(node.left), 0);
        int rightMax = Math.max(dfs(node.right), 0);

        maxSum = Math.max(maxSum, node.val + leftMax + rightMax);
        return node.val + Math.max(leftMax, rightMax);
    }
}
