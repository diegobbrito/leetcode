package com.leetcode.trees;

public class MergeTwoBinaryTrees {
    //    https://leetcode.com/problems/merge-two-binary-trees/
//    Time Complexity O(n or m)
//    Memory Complexity O(h)
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode node = new TreeNode((root1 != null ? root1.val : 0) + (root2 != null ? root2.val : 0));
        node.left = mergeTrees(root1 != null ? root1.left : null, root2 != null ? root2.left : null);
        node.right = mergeTrees(root1 != null ? root1.right : null, root2 != null ? root2.right : null);
        return node;
    }
}
