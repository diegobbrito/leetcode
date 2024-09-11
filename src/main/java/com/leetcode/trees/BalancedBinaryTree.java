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

}
