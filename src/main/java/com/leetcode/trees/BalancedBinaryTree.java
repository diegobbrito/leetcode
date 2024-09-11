package com.leetcode.trees;


public class BalancedBinaryTree {
    //    https://leetcode.com/problems/balanced-binary-tree/
// Solution using the bottom up approach
//    Time Complexity
    //    The time complexity of this algorithm is O(n^2),
    //    where n is the number of nodes in the tree. This is because:
    //      The height function is called for each node to calculate its height.
    //      For each node, height makes recursive calls to both its left and right children,
    //      leading to a full traversal of the subtree rooted at that node.
    //      This recursive height calculation is repeated for each node by the isBalanced method,
    //      leading to redundant calculations.

//    Space Complexity
    //The space complexity is O(h), where h is the height of the tree.
    // This is because of the recursion stack used in both the isBalanced and height functions.
    //
    //In the worst case (a completely unbalanced tree),
    // this stack depth can be equal to the number of nodes, resulting in O(n) space.
    //In the best case (a balanced tree), the height is log(n), leading to O(log n) space complexity.

    public boolean isBalanced(TreeNode root) {
        // If the tree is empty, it is considered balanced
        if (root == null) return true;

        // Calculate the height of the left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Check if the current node is balanced:
        // 1. The height difference between left and right subtrees should be less than 2
        // 2. Recursively check if the left and right subtrees are balanced
        return Math.abs(leftHeight - rightHeight) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        // If the node is null, its height is 0
        if (root == null) return 0;

        // Recursively find the height of the left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // The height of the current node is the maximum height of its subtrees plus 1
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //Time Complexity
//The improved time complexity is O(n), where n is the number of nodes in the tree.
// This is because each node is visited exactly once.
//Space Complexity
//The space complexity remains O(h), where h is the height of the tree,
// due to the recursion stack. In the worst case, this can be O(n) (if the tree is completely unbalanced),
// or O(log n) (if the tree is balanced).
    public boolean isBalanced2(TreeNode root) {
        // Start the helper function and check the balanced status from the result
        return checkBalance(root) != -1;
    }

    private int checkBalance(TreeNode root) {
        // If the node is null, its height is 0, and it is balanced
        if (root == null) return 0;

        // Recursively check the left subtree
        int leftHeight = checkBalance(root.left);
        // If left subtree is unbalanced, propagate -1 upwards
        if (leftHeight == -1) return -1;

        // Recursively check the right subtree
        int rightHeight = checkBalance(root.right);
        // If right subtree is unbalanced, propagate -1 upwards
        if (rightHeight == -1) return -1;

        // Check if the current node is balanced
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        // Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }


}
