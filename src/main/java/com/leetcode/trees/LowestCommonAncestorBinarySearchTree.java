package com.leetcode.trees;

public class LowestCommonAncestorBinarySearchTree {
//    https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

//    Time Complexity:
//    O(h), where h is the height of the binary search tree (BST).
//    In the worst case, the function might have to traverse the height of the tree,
//    either skewed left or right, making the traversal linear in height.

    //    Space Complexity:
//    O(1), because the function uses only a constant amount of extra space for the curr variable,
//    regardless of the size of the input tree.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Start from the root of the tree
        var curr = root;

        // Traverse the tree until we find the LCA
        while (curr != null) {
            // If both p and q are smaller than current node, move to the left subtree
            if (curr.val > p.val && curr.val > q.val)
                curr = curr.left;
                // If both p and q are greater than current node, move to the right subtree
            else if (curr.val < p.val && curr.val < q.val)
                curr = curr.right;
                // If p and q are on different sides of the current node, or one is the current node,
                // the current node is the LCA
            else
                return curr;
        }
        // If the tree is empty, or no LCA is found, return the root
        return root;
    }

}
