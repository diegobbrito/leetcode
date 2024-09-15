package com.leetcode.trees;

public class DiameterBinaryTree {
//    https://leetcode.com/problems/diameter-of-binary-tree/

//    Time complexity: O(n),
//    where n is the number of nodes in the tree. Each node is visited once during the traversal.

//    Space complexity: O(h),
//    where h is the height of the tree, due to the recursion stack.
//    In the worst case (skewed trees), this can be O(n).

    // Instance variable to keep track of the maximum diameter found.
    private int diameter = 0;

    // Main function to compute the diameter of the binary tree.
    public int diameterOfBinaryTree(TreeNode root) {
        // Call the dfs function to calculate the diameter.
        dfs(root);
        // Return the computed diameter.
        return diameter;
    }

    // DFS function to calculate the diameter of the binary tree.
    private int dfs(TreeNode root) {
        // Base case: If the current node is null, the height is 0.
        if (root == null) return 0;

        // Recursively compute the height of the left and right subtree.
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        // Update the diameter with the maximum value between the current diameter
        // and the sum of the heights of the left and right subtrees.
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return the height of the current node, which is 1 plus the maximum of
        // the heights of the left and right subtrees.
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
