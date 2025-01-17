package com.leetcode.trees;

public class SumRootLeafNumbers {

    //https://leetcode.com/problems/sum-root-to-leaf-numbers/

    //Time complexity: O(n), where n is the number of nodes in the tree.
    //We traverse the tree once.
    //Space complexity: O(n), where n is the number of nodes in the tree.
    int sum;

    public int sumNumbers(TreeNode root) {
        sum = 0;
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int val) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            sum += val + root.val;
        }
        dfs(root.left, (val + root.val) * 10);
        dfs(root.right, (val + root.val) * 10);
    }
}
