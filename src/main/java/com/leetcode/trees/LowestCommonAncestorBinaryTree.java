package com.leetcode.trees;

public class LowestCommonAncestorBinaryTree {
//    https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
//    Time Complexity: O(N), where N is the number of nodes in the tree. We potentially visit every node.
//    Space Complexity: O(H), where H is the height of the tree, representing the space used by the recursion stack.

    //    Approach
//If the current node is null, return null.
//If the current node matches either p or q, return that node.
//Recursively search for p and q in the left and right subtrees.
//If both left and right subtrees return non-null values, the current node is the LCA.
//If only one subtree returns a non-null value, that value is the LCA.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If the root is null, return null as there's no tree to traverse.
        if (root == null) return null;
        // If the current node is either p or q, return the current node (it could be the LCA).
        if (root == p || root == q) return root;
        // Recursively search for p and q in the left subtree.
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // Recursively search for p and q in the right subtree.
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // If p is found in one subtree and q is found in the other, the current node is the LCA.
        if (left != null && right != null) return root;
        // If both nodes are in the right subtree, return the right subtree's result.
        if (left == null) return right;
        // If both nodes are in the left subtree, return the left subtree's result.
        return left;
    }


}
