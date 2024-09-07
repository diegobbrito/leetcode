package com.leetcode.trees;

public class InvertBinaryTree {
    //    https://leetcode.com/problems/invert-binary-tree/
//    Time Complexity O(n)
//    Space Complexity O(n)
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null; // base case
        var temp = root.left; // create a temporarily variable to swap the values
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);// then, invert the left and right values
        invertTree(root.right);
        return root;
    }

    //    Time Complexity O(n)
//    Space Complexity O(n)
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        TreeNode node = new TreeNode(root.val);
        node.right = invertTree(root.left);
        node.left = invertTree(root.right);
        return node;
    }
}
